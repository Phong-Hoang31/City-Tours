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

    private Landmark mapToRowSet(SqlRowSet sqlRowSet) {
        Landmark landmark = new Landmark();
        landmark.setLandmarkID(sqlRowSet.getInt("landmark_id"));
        landmark.setLandmarkName(sqlRowSet.getString("landmark_name"));
        landmark.setCategory(sqlRowSet.getString("category"));
        landmark.setDescription(sqlRowSet.getString("description"));
        landmark.setUpRatings(sqlRowSet.getInt("up_ratings"));
        landmark.setDownRatings(sqlRowSet.getInt("down_ratings"));

        landmark.setImageUrlList(getImagesByLandmarkId(landmark.getLandmarkID()));
        landmark.setScheduleList(getSchedulesByLandmarkId(landmark.getLandmarkID()));

        return landmark;
    }

    private Schedule mapToSchedule(SqlRowSet sqlRowSet) {
        Schedule schedule = new Schedule();

        schedule.setDayName(sqlRowSet.getString("day_of_week"));
        schedule.setOpenTime(sqlRowSet.getTime("open_time"));
        schedule.setCloseTime(sqlRowSet.getTime("close_time"));

        return schedule;

    }
}
