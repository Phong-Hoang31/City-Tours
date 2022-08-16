package com.techelevator.dao;

import com.techelevator.model.Itinerary;
import com.techelevator.model.Landmark;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcItineraryDao implements ItineraryDao{

    JdbcTemplate jdbcTemplate;
    private LandmarkDao landmarkDao;

    public JdbcItineraryDao(JdbcTemplate jdbcTemplate, LandmarkDao landmarkDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.landmarkDao = landmarkDao;
    }

    public List<Itinerary> getItinerariesByUserId(int userId) {

        List<Itinerary> itineraryList = new ArrayList<>();
        String sql = "SELECT * from itinerary \n" +
                "WHERE user_id = ?";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql, userId);

        while (sqlRowSet.next()) {
            itineraryList.add(mapToRowSet(sqlRowSet));
        }
        return itineraryList;
    };

    public Itinerary getItineraryById(int itineraryId) {
        Itinerary itinerary;

        String sql = "SELECT * from itinerary \n" +
                "WHERE itinerary_id = ?";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql, itineraryId);

        if (sqlRowSet.next()){
            itinerary = mapToRowSet(sqlRowSet);
            return itinerary;
        }
        return null;
    };

    public void createItinerary(String itineraryName, String startingPoint, LocalDate localDate, int userId) {
        String sql = "INSERT INTO itinerary(itinerary_name, starting_point, itinerary_date, user_id)" +
                " VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, itineraryName, startingPoint, localDate, userId);
    }

    public void addLandmarkToItinerary(Integer itineraryId, Integer landmarkId) {

        int itineraryLength = getItineraryById(itineraryId).getLandmarkList().size();

        String sql = "insert into itinerary_landmark(itinerary_id, landmark_id, landmark_order)" +
                " values(?, ?, ?)";

        jdbcTemplate.update(sql, itineraryId, landmarkId, itineraryLength + 1);
    }

    public void deleteLandmarkFromItinerary(Integer itineraryId, Integer landmarkId) {

        String sql = "DELETE FROM itinerary_landmark WHERE itinerary_id = ? AND landmark_id = ?;";
        jdbcTemplate.update(sql, itineraryId, landmarkId);
    }

    @Override
    public void deleteItinerary(int itineraryId) {

        String sql = "DELETE FROM itinerary WHERE itinerary_Id = ? ";
        jdbcTemplate.update(sql, itineraryId);
    }

    public void updateItineraryStartingPoint(Integer itineraryId, String startingPoint) {

        String sql = "UPDATE itinerary \n" +
                "SET starting_point = ? \n" +
                "WHERE itinerary_id = ?;";

        jdbcTemplate.update(sql, startingPoint, itineraryId);
    }

    private Itinerary mapToRowSet(SqlRowSet sqlRowSet) {
        Itinerary itinerary = new Itinerary();
        itinerary.setItineraryId(sqlRowSet.getInt("itinerary_id"));
        itinerary.setStartingPoint(sqlRowSet.getString("starting_point"));
        itinerary.setItineraryDate(sqlRowSet.getDate("itinerary_date").toLocalDate());
        itinerary.setItineraryName(sqlRowSet.getString("itinerary_name"));
        itinerary.setUserId(sqlRowSet.getInt("user_id"));
        itinerary.setLandmarkList(landmarkDao.getLandmarksByItineraryId(itinerary.getItineraryId()));

        return itinerary;
    }


}
