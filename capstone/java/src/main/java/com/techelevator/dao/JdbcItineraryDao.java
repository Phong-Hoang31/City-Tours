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

    public void createItinerary(String itinerary_name, String starting_point, LocalDate localDate, int user_id) {
        String sql = "INSERT INTO itinerary(itinerary_name, starting_point, itinerary_date, user_id)" +
                " VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, itinerary_name, starting_point, localDate, user_id);
    }

    public void addLandmarkToItinerary(Landmark landmark, Itinerary itinerary) {
        int landmarkId = landmark.getLandmarkID();
        int itineraryId = itinerary.getItineraryId();
        int itineraryLength = itinerary.getLandmarkList().size();

        String sql = "insert into itinerary_landmark(itinerary_id, landmark_id, landmark_order)" +
                " values(?, ?, ?)";
        jdbcTemplate.update(sql, itineraryId, landmarkId, itineraryLength + 1);

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
