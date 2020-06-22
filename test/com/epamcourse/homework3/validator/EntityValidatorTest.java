package com.epamcourse.homework3.validator;

import com.epamcourse.homework3.entity.Ball;
import com.epamcourse.homework3.entity.BallSize;
import com.epamcourse.homework3.entity.Basket;
import com.epamcourse.homework3.entity.ItemColor;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class EntityValidatorTest {
    EntityValidator entityValidator;

    @BeforeTest
    public void setUp() {
        entityValidator = new EntityValidator();
    }

    @DataProvider(name = "ballPositiveData")
    public Object[][] createBallPositiveData() {
        return new Object[][]{
                {new Ball(ItemColor.RED, BallSize.L, 1.5), true},
                {new Ball(ItemColor.RED, BallSize.L, 4), false},
                {new Ball(ItemColor.RED, BallSize.L, 0.1), false},
                {new Ball(ItemColor.RED, BallSize.L, 0.5), true},
                {new Ball(ItemColor.RED, BallSize.L, 3.0), true},
        };
    }

    @Test(dataProvider = "ballPositiveData")
    public void validateBallTestPositive(Ball ball, boolean expected) {
        boolean actual = entityValidator.validateBall(ball);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "ballNegativeData")
    public Object[][] createBallNegativeData() {
        return new Object[][]{
                {new Ball(ItemColor.RED, BallSize.L, 1.5), false},
                {new Ball(ItemColor.RED, BallSize.L, 4), true},
                {new Ball(ItemColor.RED, BallSize.L, 0.1), true},
                {new Ball(ItemColor.RED, BallSize.L, 0.5), false},
                {new Ball(ItemColor.RED, BallSize.L, 3.0), false},
        };
    }

    @Test(dataProvider = "ballNegativeData")
    public void validateBallTestNegative(Ball ball, boolean expected) {
        boolean actual = entityValidator.validateBall(ball);
        assertNotEquals(actual, expected);
    }

    @DataProvider(name = "basketPositiveData")
    public Object[][] createBasketPositiveData() {
        return new Object[][]{
                {new Basket(150, 30), true},
                {new Basket(50, 30), true},
                {new Basket(700, 30), true},
                {new Basket(150, 3), true},
                {new Basket(150, 50), true},
                {new Basket(40, 30), false},
                {new Basket(710, 30), false},
                {new Basket(150, 1), false},
                {new Basket(150, 51), false},
        };
    }

    @Test(dataProvider = "basketPositiveData")
    public void validateBasketTestPositive(Basket basket, boolean expected) {
        boolean actual = entityValidator.validateBasket(basket);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "basketNegativeData")
    public Object[][] createBasketNegativeData() {
        return new Object[][]{
                {new Basket(150, 30), false},
                {new Basket(50, 30), false},
                {new Basket(700, 30), false},
                {new Basket(150, 3), false},
                {new Basket(150, 50), false},
                {new Basket(40, 30), true},
                {new Basket(710, 30), true},
                {new Basket(150, 1), true},
                {new Basket(150, 51), true},
                {new Basket(-150, 10), true},
                {new Basket(150, -10), true},
        };
    }

    @Test(dataProvider = "basketNegativeData")
    public void validateBasketTestNegative(Basket basket, boolean expected) {
        boolean actual = entityValidator.validateBasket(basket);
        assertNotEquals(actual, expected);
    }
}