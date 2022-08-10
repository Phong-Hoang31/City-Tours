package com.techelevator.dao;

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

}
