package com.techelevator.dao;

import com.techelevator.model.Landmark;
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
        String sql = "SELECT * FROM landmarks";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql);

        while(sqlRowSet.next()) {
            landmarkList.add(mapToRowSet(sqlRowSet));
        }
        return landmarkList;
    }
    public List<Category> getCategories() {
        List<Category> categoryList = new ArrayList<>();
        String sql = "SELECT category FROM landmarks";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql);

        while(sqlRowSet.next()) {
            landmarkList.add(mapToRowSet(sqlRowSet));
        }
        return categoryList;
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
