package com.techelevator.dao;

import com.techelevator.model.Landmark;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcLandmarkDao implements LandmarkDao {

    JdbcTemplate jdbcTemplate;

    public JdbcLandmarkDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Landmark> getLandmarksByName(String landmarkName) {
        List<Landmark> landmarkList = new ArrayList<>();
        String sql = "SELECT * FROM landmarks WHERE ?";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql, landmarkName);

        while(sqlRowSet.next()) {
            landmarkList.add(mapToRowSet(sqlRowSet));
        }
        return landmarkList;
    }

    private Landmark mapToRowSet(SqlRowSet sqlRowSet) {
        Landmark landmark = new Landmark();
        landmark.setLandmarkID(sqlRowSet.getInt("landmark_id"));
        landmark.setLandmarkName(sqlRowSet.getString("landmark_name"));
        landmark.setCategory(sqlRowSet.getString("category"));
        landmark.setDescription(sqlRowSet.getString("description"));
        landmark.setUpRatings(sqlRowSet.getInt("up_ratings"));
        landmark.setDownRatings(sqlRowSet.getInt("down_ratings"));
        return landmark;
     }

}
