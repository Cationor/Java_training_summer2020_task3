package com.epamcourse.homework3.creator;

import com.epamcourse.homework3.creator.BallCreator;
import com.epamcourse.homework3.entity.Ball;
import com.epamcourse.homework3.exception.ProjectInvalidDataException;
import org.testng.annotations.BeforeTest;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.Assert.*;

public class BallCreatorTest {
    BallCreator ballCreator;

    @BeforeTest
    public void setUp() {
        ballCreator = new BallCreator();
    }

    @Test(dataProvider = "ballPositiveData", dataProviderClass = CreatorDataProvider.class)
    public void createBallsListTestPositive(List<String> ballsData, List<Ball> expected) {
        try {
            List<Ball> actual = ballCreator.createBallsList(ballsData);
            assertEquals(actual, expected);
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test(dataProvider = "ballNegativeData", dataProviderClass = CreatorDataProvider.class)
    public void createBallsListTestNegative(List<String> ballsData, List<Ball> expected) {
        try {
            List<Ball> actual = ballCreator.createBallsList(ballsData);
            assertNotEquals(actual, expected);
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class, dataProvider = "ballExceptionData",
            dataProviderClass = CreatorDataProvider.class)
    public void createBallsListTestException(List<String> ballsData) throws ProjectInvalidDataException {
        ballCreator.createBallsList(ballsData);
    }
}