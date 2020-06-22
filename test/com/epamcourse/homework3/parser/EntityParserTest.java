package com.epamcourse.homework3.parser;

import com.epamcourse.homework3.entity.Ball;
import com.epamcourse.homework3.entity.BallSize;
import com.epamcourse.homework3.entity.Basket;
import com.epamcourse.homework3.entity.ItemColor;
import com.epamcourse.homework3.parser.EntityParser;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class EntityParserTest {
    EntityParser entityParser;

    @BeforeTest
    public void setUp() {
        entityParser = new EntityParser();
    }

    @DataProvider(name = "BallPositiveData")
    public Object[][] createBallPositiveData() {
        return new Object[][]{
                {"ball, GREEN, L, 35", new Ball(ItemColor.GREEN, BallSize.L, 35)},
                {"ball, BLUE, M, 20", new Ball(ItemColor.BLUE, BallSize.M, 20)},
                {"ball, BLUE, S, 15", new Ball(ItemColor.BLUE, BallSize.S, 15)},
                {"ball, BROWN, XL, 88", new Ball(ItemColor.BROWN, BallSize.XL, 88)}
        };
    }

    @Test(dataProvider = "BallPositiveData")
    public void parseBallTestPositive(String ballsData, Ball expected) {
        Ball actual = entityParser.parseBall(ballsData);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "BallNegativeData")
    public Object[][] createBallNegativeData() {
        return new Object[][]{
                {"ball, GREEN, L, 35", new Ball(ItemColor.BLUE, BallSize.L, 35)},
                {"ball, BLUE, M, 20", new Ball(ItemColor.BLUE, BallSize.XL, 20)},
                {"ball, BLUE, S, 15", new Ball(ItemColor.BLUE, BallSize.S, 51)},
                {"ball, BROWN, XL, 88", new Ball(ItemColor.BLACK, BallSize.L, 0)}
        };
    }

    @Test(dataProvider = "BallNegativeData")
    public void parseBallTestNegative(String ballsData, Ball expected) {
        Ball actual = entityParser.parseBall(ballsData);
        assertNotEquals(actual, expected);
    }

    @DataProvider(name = "BasketPositiveData")
    public Object[][] createBasketPositiveData() {
        return new Object[][]{
                {"basket, 800, 400", new Basket(800, 400)},
                {"basket, 350, 180", new Basket(350, 180)},
                {"basket, 400, 190", new Basket(400, 190)},
        };
    }

    @Test(dataProvider = "BasketPositiveData")
    public void parseBasketTestPositive(String basketsData, Basket expected) {
        Basket actual = entityParser.parseBasket(basketsData);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "BasketNegativeData")
    public Object[][] createBasketNegativeData() {
        return new Object[][]{
                {"basket, 800, 400", new Basket(500, 400)},
                {"basket, 350, 180", new Basket(180, 350)},
                {"basket, 400, 190", new Basket(400, 910)},
        };
    }

    @Test(dataProvider = "BasketNegativeData")
    public void parseBasketTestNegative(String basketsData, Basket expected) {
        Basket actual = entityParser.parseBasket(basketsData);
        assertNotEquals(actual, expected);
    }
}