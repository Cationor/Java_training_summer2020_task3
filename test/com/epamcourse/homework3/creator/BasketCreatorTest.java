package com.epamcourse.homework3.creator;

import com.epamcourse.homework3.entity.Basket;
import com.epamcourse.homework3.exception.ProjectInvalidDataException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class BasketCreatorTest {
    BasketCreator basketCreator;

    @BeforeTest
    public void setUp() {
        basketCreator = new BasketCreator();
    }

    @Test(dataProvider = "basketPositiveData", dataProviderClass = CreatorDataProvider.class)
    public void createBasketsListTestPositive(List<String> basketsData, List<Basket> expected) {
        try {
            List<Basket> actual = basketCreator.createBasketsList(basketsData);
            assertEquals(actual, expected);
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test(dataProvider = "basketNegativeData", dataProviderClass = CreatorDataProvider.class)
    public void createBasketsListTestNegative(List<String> basketsData, List<Basket> expected) {
        try {
            List<Basket> actual = basketCreator.createBasketsList(basketsData);
            assertNotEquals(actual, expected);
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class, dataProvider = "basketExceptionData",
            dataProviderClass = CreatorDataProvider.class)
    public void createBasketsListTestException(List<String> basketsData) throws ProjectInvalidDataException {
        basketCreator.createBasketsList(basketsData);
    }
}