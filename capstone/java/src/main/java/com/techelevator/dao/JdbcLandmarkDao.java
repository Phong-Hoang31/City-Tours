package com.techelevator.dao;

import com.techelevator.model.Landmark;
import com.techelevator.model.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcLandmarkDao implements LandmarkDao {

    JdbcTemplate jdbcTemplate;

    public JdbcLandmarkDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Landmark> getLandmarks() {
        List<Landmark> landmarkList = new ArrayList<>();
        String sql = "SELECT * FROM landmark";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql);

        while (sqlRowSet.next()) {
            landmarkList.add(mapToRowSet(sqlRowSet));
        }
        return landmarkList;
    }

    public ArrayList<Landmark> getLandmarksByItineraryId(int itineraryId) {

        ArrayList<Landmark> landmarks = new ArrayList<Landmark>();
        String sql = "SELECT * from itinerary \n" +
                "JOIN itinerary_landmark ON itinerary_landmark.itinerary_id = itinerary.itinerary_id \n " +
                "JOIN landmark on itinerary_landmark.landmark_id = landmark.landmark_id \n" +
                "WHERE itinerary.itinerary_id = ?";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql, itineraryId);

        while (sqlRowSet.next()) {
            Landmark landmark = mapToRowSet(sqlRowSet);
            landmark.setLandmarkOrder(sqlRowSet.getInt("landmark_order"));
            landmarks.add(landmark);
        }
        return landmarks;
    }

    public ArrayList<String> getImagesByLandmarkId(int landmarkId) {

        ArrayList<String> imageUrls = new ArrayList<String>();
        String sql = "SELECT url FROM image WHERE landmark_id = ?";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql, landmarkId);

        while (sqlRowSet.next()) {
            imageUrls.add(sqlRowSet.getString("url"));
        }
        return imageUrls;
    }

    public ArrayList<Schedule> getSchedulesByLandmarkId(int landmarkId) {

        ArrayList<Schedule> scheduleList = new ArrayList<>();
        String sql = "SELECT * FROM schedule WHERE landmark_id = ?";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql, landmarkId);

        while (sqlRowSet.next()) {
            scheduleList.add(mapToSchedule(sqlRowSet));
        }
        return scheduleList;
    }

    @Override
    public Landmark getLandmarksById(int landmarkId) {
        Landmark landmark;
        String sql = "SELECT * FROM landmark \n" +
                "WHERE landmark_id = ?";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql, landmarkId);
        if (sqlRowSet.next()){
            landmark = mapToRowSet(sqlRowSet);
            return landmark;
        }
        return null;
    }
    
    @Override
    public void updateUpRatings(int landmarkId) {
        String sql = "UPDATE landmark\n " +
                "SET up_ratings = up_ratings + 1\n " +
                "WHERE landmark_id = ?;\n ";
    jdbcTemplate.update(sql, landmarkId );
    }

    @Override
    public void updateDownRatings(int landmarkId) {
        String sql = "UPDATE landmark\n " +
                "SET down_ratings = down_ratings + 1\n " +
                "WHERE landmark_id = ?;\n ";
        jdbcTemplate.update(sql, landmarkId );

    }

    public Landmark mapToRowSet(SqlRowSet sqlRowSet) {
        Landmark landmark = new Landmark();
        landmark.setLandmarkID(sqlRowSet.getInt("landmark_id"));
        landmark.setLandmarkName(sqlRowSet.getString("landmark_name"));
        landmark.setCategory(sqlRowSet.getString("category"));
        landmark.setDescription(sqlRowSet.getString("description"));
        landmark.setUpRatings(sqlRowSet.getInt("up_ratings"));
        landmark.setDownRatings(sqlRowSet.getInt("down_ratings"));
        landmark.setAddress(sqlRowSet.getString("address"));
        landmark.setPrice(sqlRowSet.getString("price"));

        landmark.setImageUrlList(getImagesByLandmarkId(landmark.getLandmarkID()));
        landmark.setScheduleList(getSchedulesByLandmarkId(landmark.getLandmarkID()));

        return landmark;
    }



    private Schedule mapToSchedule(SqlRowSet sqlRowSet) {
        Schedule schedule = new Schedule();

        schedule.setDayName(sqlRowSet.getString("day_of_week"));
        schedule.setOpenTime(sqlRowSet.getString("open_time"));
        schedule.setCloseTime(sqlRowSet.getString("close_time"));
        schedule.setCloseTime(sqlRowSet.getString("close_time"));

        return schedule;
    }
}
