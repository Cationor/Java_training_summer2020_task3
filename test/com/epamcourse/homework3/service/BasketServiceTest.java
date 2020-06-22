package com.epamcourse.homework3.service;

import com.epamcourse.homework3.entity.Ball;
import com.epamcourse.homework3.entity.BallSize;
import com.epamcourse.homework3.entity.Basket;
import com.epamcourse.homework3.entity.ItemColor;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class BasketServiceTest {
    BasketService basketService;
    Basket checkingBasket1;
    Basket checkingBasket2;
    Basket checkingBasket3;
    Basket checkingBasket4;
    List<Ball> checkingBalls1;
    List<Ball> checkingBalls2;
    List<Ball> checkingBalls3;

    @BeforeTest
    public void setUp() {
        basketService = new BasketService();
        checkingBasket1 = new Basket(400, 30);
        checkingBasket1.addBall(new Ball(ItemColor.RED, BallSize.L, 2.1));
        checkingBasket1.addBall(new Ball(ItemColor.BLUE, BallSize.M, 1.1));
        checkingBasket1.addBall(new Ball(ItemColor.GREEN, BallSize.S, 0.5));
        checkingBasket1.addBall(new Ball(ItemColor.BLUE, BallSize.XL, 2.4));
        checkingBasket1.addBall(new Ball(ItemColor.BLUE, BallSize.XXL, 2.9));
        checkingBasket1.addBall(new Ball(ItemColor.BROWN, BallSize.L, 2.0));

        checkingBasket2 = new Basket(700, 11);
        checkingBasket2.addBall(new Ball(ItemColor.RED, BallSize.S, 2.1));
        checkingBasket2.addBall(new Ball(ItemColor.YELLOW, BallSize.M, 1.1));
        checkingBasket2.addBall(new Ball(ItemColor.GREEN, BallSize.L, 0.5));
        checkingBasket2.addBall(new Ball(ItemColor.BLACK, BallSize.XL, 2.4));
        checkingBasket2.addBall(new Ball(ItemColor.GRAY, BallSize.XXL, 2.9));
        checkingBasket2.addBall(new Ball(ItemColor.BROWN, BallSize.S, 2.0));

        checkingBasket3 = new Basket(56, 50);
        checkingBasket3.addBall(new Ball(ItemColor.BLUE, BallSize.L, 1.1));
        checkingBasket3.addBall(new Ball(ItemColor.BLUE, BallSize.S, 0.9));
        checkingBasket3.addBall(new Ball(ItemColor.GREEN, BallSize.S, 0.5));
        checkingBasket3.addBall(new Ball(ItemColor.BLUE, BallSize.M, 2.0));
        checkingBasket3.addBall(new Ball(ItemColor.GRAY, BallSize.XXL, 3.0));
        checkingBasket3.addBall(new Ball(ItemColor.BROWN, BallSize.M, 2.0));
        checkingBasket3.addBall(null);

        checkingBasket4 = new Basket(700, 50);

        checkingBalls1 = new ArrayList<>();
        checkingBalls1.add(new Ball(ItemColor.RED, BallSize.L, 2.1));
        checkingBalls1.add(new Ball(ItemColor.RED, BallSize.XL, 2.9));
        checkingBalls1.add(new Ball(ItemColor.GREEN, BallSize.S, 0.6));
        checkingBalls1.add(new Ball(ItemColor.BROWN, BallSize.M, 1.3));
        checkingBalls1.add(new Ball(ItemColor.GRAY, BallSize.XL, 2.7));
        checkingBalls1.add(new Ball(ItemColor.BLACK, BallSize.S, 0.5));

        checkingBalls2 = new ArrayList<>();
        checkingBalls2.add(new Ball(ItemColor.RED, BallSize.XXL, 2.1));
        checkingBalls2.add(new Ball(ItemColor.RED, BallSize.XL, 2.9));
        checkingBalls2.add(new Ball(ItemColor.GREEN, BallSize.XL, 0.6));
        checkingBalls2.add(new Ball(ItemColor.BROWN, BallSize.L, 1.3));
        checkingBalls2.add(new Ball(ItemColor.GRAY, BallSize.M, 2.7));
        checkingBalls2.add(new Ball(ItemColor.BLACK, BallSize.S, 0.5));

        checkingBalls3 = new ArrayList<>();
        checkingBalls3.add(new Ball(ItemColor.RED, BallSize.XXL, 2.1));
        checkingBalls3.add(new Ball(ItemColor.RED, BallSize.XL, 1.9));
        checkingBalls3.add(new Ball(ItemColor.GREEN, BallSize.M, 0.8));
        checkingBalls3.add(new Ball(ItemColor.BROWN, BallSize.M, 1.3));
        checkingBalls3.add(new Ball(ItemColor.GRAY, BallSize.XL, 2.7));
        checkingBalls3.add(null);
    }

    @DataProvider(name = "BallWeightDataPositive")
    public Object[][] createBallWeightDataPositive() {
        return new Object[][]{
                {null, -1},
                {checkingBasket1, 11.0},
                {checkingBasket2, 11.0},
                {checkingBasket3, 9.5},
                {checkingBasket4, 0}
        };
    }

    @Test(dataProvider = "BallWeightDataPositive")
    public void calculateBallsWeightTestPositive(Basket basket, double expected) {
        double actual = basketService.calculateBallsWeight(basket);
        assertEquals(actual, expected, 0.001);
    }

    @DataProvider(name = "ballWeightDataNegative")
    public Object[][] createBallWeightDataNegative() {
        return new Object[][]{
                {null, 0},
                {checkingBasket1, 11.5},
                {checkingBasket2, 9.0},
                {checkingBasket3, 10.5},
                {checkingBasket4, 1}
        };
    }

    @Test(dataProvider = "ballWeightDataNegative")
    public void calculateBallsWeightTestNegative(Basket basket, double expected) {
        double actual = basketService.calculateBallsWeight(basket);
        assertNotEquals(actual, expected, 0.001);
    }

    @DataProvider(name = "ballColorDataPositive")
    public Object[][] createBallColorDataPositive() {
        return new Object[][]{
                {null, ItemColor.BLUE, -1},
                {checkingBasket1, ItemColor.BLUE, 3},
                {checkingBasket2, ItemColor.BLUE, 0},
                {checkingBasket3, ItemColor.BLUE, 3},
                {checkingBasket4, ItemColor.BLUE, 0}
        };
    }

    @Test(dataProvider = "ballColorDataPositive")
    public void calculateSameBallsTestPositive(Basket basket, ItemColor ballColor, int expected) {
        int actual = basketService.calculateSameColorBalls(basket, ballColor);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "ballColorDataNegative")
    public Object[][] createBallColorDataNegative() {
        return new Object[][]{
                {null, ItemColor.BLUE, 0},
                {checkingBasket1, ItemColor.BLUE, 2},
                {checkingBasket2, ItemColor.BLUE, 1},
                {checkingBasket3, ItemColor.BLUE, 2},
                {checkingBasket4, ItemColor.BLUE, -1}
        };
    }

    @Test(dataProvider = "ballColorDataNegative")
    public void calculateSameBallsTestNegative(Basket basket, ItemColor ballColor, int expected) {
        int actual = basketService.calculateSameColorBalls(basket, ballColor);
        assertNotEquals(actual, expected);
    }

    @DataProvider(name = "basketVolumeDataPositive")
    public Object[][] createBasketVolumeDataPositive() {
        return new Object[][]{
                {null, -1},
                {checkingBasket1, 328},
                {checkingBasket2, 635},
                {checkingBasket3, 0},
                {checkingBasket4, 700}
        };
    }

    @Test(dataProvider = "basketVolumeDataPositive")
    public void calculateBasketVolumeTestPositive(Basket basket, double expected) {
        double actual = basketService.calculateBasketFreeVolume(basket);
        assertEquals(actual, expected, 0.001);
    }

    @DataProvider(name = "basketVolumeDataNegative")
    public Object[][] createBasketVolumeDataNegative() {
        return new Object[][]{
                {null, 0},
                {checkingBasket1, 329},
                {checkingBasket2, 11},
                {checkingBasket3, 56},
                {checkingBasket4, 0}
        };
    }

    @Test(dataProvider = "basketVolumeDataNegative")
    public void calculateBasketVolumeTestNegative(Basket basket, double expected) {
        double actual = basketService.calculateBasketFreeVolume(basket);
        assertNotEquals(actual, expected, 0.001);
    }

    @DataProvider(name = "basketPayloadDataPositive")
    public Object[][] createBasketPayloadDataPositive() {
        return new Object[][]{
                {null, -1},
                {checkingBasket1, 19},
                {checkingBasket2, 0},
                {checkingBasket3, 40.5},
                {checkingBasket4, 50}
        };
    }

    @Test(dataProvider = "basketPayloadDataPositive")
    public void calculateBasketPayloadTestPositive(Basket basket, double expected) {
        double actual = basketService.calculateBasketFreePayload(basket);
        assertEquals(actual, expected, 0.001);
    }

    @DataProvider(name = "basketPayloadDataNegative")
    public Object[][] createBasketPayloadDataNegative() {
        return new Object[][]{
                {null, 0},
                {checkingBasket1, 30},
                {checkingBasket2, -1},
                {checkingBasket3, 42},
                {checkingBasket4, 0}
        };
    }

    @Test(dataProvider = "basketPayloadDataNegative")
    public void calculateBasketPayloadTestNegative(Basket basket, double expected) {
        double actual = basketService.calculateBasketFreePayload(basket);
        assertNotEquals(actual, expected, 0.001);
    }

    @DataProvider(name = "loadBallsDataPositive")
    public Object[][] createLoadBallsDataPositive() {
        return new Object[][]{
                {null, checkingBalls1, -1},
                {new Basket(600, 5), null, -1},
                {new Basket(500, 40), checkingBalls1, 6},
                {new Basket(52, 40), checkingBalls2, 3},
                {new Basket(600, 5), checkingBalls3, 3},
        };
    }

    @Test(dataProvider = "loadBallsDataPositive")
    public void loadBasketTestPositive(Basket basket, List<Ball> balls, int expected) {
        int actual = basketService.loadBasket(basket, balls);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "loadBallsDataNegative")
    public Object[][] createLoadBallsDataNegative() {
        return new Object[][]{
                {null, checkingBalls1, 0},
                {new Basket(600, 5), null, 0},
                {new Basket(500, 40), checkingBalls1, 5},
                {new Basket(52, 40), checkingBalls2, 2},
                {new Basket(600, 5), checkingBalls3, 4},
        };
    }

    @Test(dataProvider = "loadBallsDataNegative")
    public void loadBasketTestNegative(Basket basket, List<Ball> balls, int expected) {
        int actual = basketService.loadBasket(basket, balls);
        assertNotEquals(actual, expected);
    }
}