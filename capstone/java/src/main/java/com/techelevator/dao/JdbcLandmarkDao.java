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
            landmarks.add(mapToRowSet(sqlRowSet));
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
        Landmark landmark = new Landmark();
        String sql = "SELECT * FROM landmark \n" +
                "WHERE landmark_id = ?";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql, landmarkId);
        if (sqlRowSet.next()){
            landmark = mapToRowSet(sqlRowSet);
            return landmark;
        }
        return null;
    }

    private Landmark mapToRowSet(SqlRowSet sqlRowSet) {
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
        schedule.setOpenTime(schedule.convertTime(sqlRowSet.getTime("open_time"))));
        schedule.setCloseTime(sqlRowSet.getTime("close_time");
        schedule.setCloseTime(sqlRowSet.getTime("close_time"));

        return schedule;
    }
}
