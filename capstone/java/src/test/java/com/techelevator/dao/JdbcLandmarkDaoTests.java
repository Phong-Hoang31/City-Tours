package com.techelevator.dao;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.techelevator.model.Landmark;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcLandmarkDaoTests extends BaseDaoTests {

    private JdbcLandmarkDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcLandmarkDao(jdbcTemplate);
    }

    @Test
    public void getLandmarks_returns_all_landmarks_is_not_empty() {
        Assert.assertNotNull(sut.getLandmarks());
    }
    @Test
    public void getLandmarks_returns_correct_landmark_for_id(){
        Landmark landmark= sut.getLandmarksById(1);
    }

    private void assertLandmarkMatch(Landmark expected, Landmark actual){
        Assert.assertEquals(expected.getLandmarkID(),actual.getLandmarkID());
        Assert.assertEquals(expected.getLandmarkName(),actual.getLandmarkName());
        Assert.assertEquals(expected.getAddress(),actual.getAddress());
        Assert.assertEquals(expected.getCategory(),actual.getCategory());
        Assert.assertEquals(expected.getDescription(),actual.getDescription());
        Assert.assertEquals(expected.getImageUrlList(),actual.getImageUrlList());
        Assert.assertEquals(expected.getLandmarkOrder(),actual.getLandmarkOrder());
        Assert.assertEquals(expected.getPrice(),actual.getPrice());
        Assert.assertEquals(expected.getUpRatings(),actual.getUpRatings());
        Assert.assertEquals(expected.getDownRatings(),actual.getDownRatings());
        Assert.assertEquals(expected.getScheduleList(),actual.getScheduleList());
    }

}
