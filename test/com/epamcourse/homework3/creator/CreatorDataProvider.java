package com.epamcourse.homework3.creator;

import com.epamcourse.homework3.entity.Ball;
import com.epamcourse.homework3.entity.BallSize;
import com.epamcourse.homework3.entity.Basket;
import com.epamcourse.homework3.entity.ItemColor;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class CreatorDataProvider {

    @DataProvider(name = "ballPositiveData")
    public static Object[][] createBallPositiveData() {
        List<String> dataLines1 = new ArrayList<>();
        dataLines1.add("ball, GREEN, L, 0.6");
        dataLines1.add("ball, BLUE, M, 0.9");
        dataLines1.add("ball, BLUE, S, 1.5");
        dataLines1.add("ball, BROWN, XL, 2.9");

        List<Ball> expectedBalls1 = new ArrayList<>();
        expectedBalls1.add(new Ball(ItemColor.GREEN, BallSize.L, 0.6));
        expectedBalls1.add(new Ball(ItemColor.BLUE, BallSize.M, 0.9));
        expectedBalls1.add(new Ball(ItemColor.BLUE, BallSize.S, 1.5));
        expectedBalls1.add(new Ball(ItemColor.BROWN, BallSize.XL, 2.9));

        List<String> dataLines2 = new ArrayList<>();
        dataLines2.add("ball, GREEN, L, 0.6");
        dataLines2.add("basket, 150, 30");
        dataLines2.add("ball, BLUE, S, 1.5");
        dataLines2.add("basket, BROWN, XL, 0.1");

        List<Ball> expectedBalls2 = new ArrayList<>();
        expectedBalls2.add(new Ball(ItemColor.GREEN, BallSize.L, 0.6));
        expectedBalls2.add(new Ball(ItemColor.BLUE, BallSize.S, 1.5));

        return new Object[][]{
                {dataLines1, expectedBalls1},
                {dataLines2, expectedBalls2}
        };
    }

    @DataProvider(name = "ballNegativeData")
    public static Object[][] createBallNegativeData() {
        List<String> dataLines1 = new ArrayList<>();
        dataLines1.add("ball, GREEN, L, 0.6");
        dataLines1.add("ball, BLUE, M, 0.9");
        dataLines1.add("ball, BLUE, S, 1.5");
        dataLines1.add("ball, BROWN, XL, 2.9");

        List<Ball> expectedBalls1 = new ArrayList<>();
        expectedBalls1.add(new Ball(ItemColor.BROWN, BallSize.XL, 2.9));
        expectedBalls1.add(new Ball(ItemColor.BLUE, BallSize.S, 1.5));
        expectedBalls1.add(new Ball(ItemColor.BLUE, BallSize.M, 0.9));
        expectedBalls1.add(new Ball(ItemColor.GREEN, BallSize.L, 0.6));

        List<String> dataLines2 = new ArrayList<>();
        dataLines2.add("ball, GREEN, L, 1.6");
        dataLines2.add("ball, GREEN, XL, 2.6");
        dataLines2.add("ball, BROWN, L, 0.6");
        dataLines2.add("basket, 150, 30");
        dataLines2.add("ball, BLUE, S, 1.5");
        dataLines2.add("basket, BROWN, XL, 0.1");

        List<Ball> expectedBalls2 = new ArrayList<>();
        expectedBalls2.add(new Ball(ItemColor.GREEN, BallSize.L, 0.6));
        expectedBalls2.add(new Ball(ItemColor.GREEN, BallSize.XL, 0.6));
        expectedBalls2.add(new Ball(ItemColor.GREEN, BallSize.L, 0.6));
        expectedBalls2.add(new Ball(ItemColor.BLUE, BallSize.S, 1.5));

        return new Object[][]{
                {dataLines1, expectedBalls1},
                {dataLines2, expectedBalls2}
        };
    }

    @DataProvider(name = "ballExceptionData")
    public static Object[][] createBallExceptionData() {
        List<String> dataLines1 = new ArrayList<>();
        dataLines1.add("ball, GREEN, L, 3.6");
        dataLines1.add("ball, BLUE, M, 0.9");

        List<String> dataLines2 = new ArrayList<>();
        dataLines2.add("ball, GREEN, L, 1.6");
        dataLines2.add("ball, GREEN, XL, 0.1");

        List<String> dataLines3 = new ArrayList<>();
        dataLines3.add("ball, GREEN, L, 1.6");
        dataLines3.add("ball, GREEN, XL, 500");

        return new Object[][]{
                {dataLines1},
                {dataLines2},
                {dataLines3}
        };
    }

    @DataProvider(name = "basketPositiveData")
    public static Object[][] createBasketPositiveData() {
        List<String> dataLines1 = new ArrayList<>();
        dataLines1.add("basket, 300, 25");
        dataLines1.add("basket, 50, 3.0");
        dataLines1.add("basket, 700, 50");

        List<Basket> expectedBaskets1 = new ArrayList<>();
        expectedBaskets1.add(new Basket(300, 25));
        expectedBaskets1.add(new Basket(50, 3));
        expectedBaskets1.add(new Basket(700, 50));

        List<String> dataLines2 = new ArrayList<>();
        dataLines2.add("ball, GREEN, L, 0.6");
        dataLines2.add("basket, 150, 30");
        dataLines2.add("ball, 150 , 30");
        dataLines2.add("basket, 500, 40");

        List<Basket> expectedBaskets2 = new ArrayList<>();
        expectedBaskets2.add(new Basket(150, 30));
        expectedBaskets2.add(new Basket(500, 40));

        return new Object[][]{
                {dataLines1, expectedBaskets1},
                {dataLines2, expectedBaskets2}
        };
    }

    @DataProvider(name = "basketNegativeData")
    public static Object[][] createBasketNegativeData() {
        List<String> dataLines1 = new ArrayList<>();
        dataLines1.add("basket, 300, 25");
        dataLines1.add("basket, 50, 3");
        dataLines1.add("basket, 700, 50");

        List<Basket> expectedBaskets1 = new ArrayList<>();
        expectedBaskets1.add(new Basket(700, 50));
        expectedBaskets1.add(new Basket(50, 3));
        expectedBaskets1.add(new Basket(300, 25));

        List<String> dataLines2 = new ArrayList<>();
        dataLines2.add("ball, GREEN, L, 0.6");
        dataLines2.add("basket, 50, 50");
        dataLines2.add("ball, 150 , 30");
        dataLines2.add("basket, 300, 20");

        List<Basket> expectedBaskets2 = new ArrayList<>();
        expectedBaskets2.add(new Basket(5, 5));
        expectedBaskets2.add(new Basket(400, 10));

        return new Object[][]{
                {dataLines1, expectedBaskets1},
                {dataLines2, expectedBaskets2}
        };
    }

    @DataProvider(name = "basketExceptionData")
    public static Object[][] createBasketExceptionData() {
        List<String> dataLines1 = new ArrayList<>();
        dataLines1.add("basket, 50, 2");
        dataLines1.add("basket, 150, 30");

        List<String> dataLines2 = new ArrayList<>();
        dataLines2.add("basket, 49, 10");
        dataLines2.add("basket, 150, 30");

        List<String> dataLines3 = new ArrayList<>();
        dataLines3.add("basket, 701, 5");
        dataLines3.add("basket, 150, 30");

        List<String> dataLines4 = new ArrayList<>();
        dataLines4.add("basket, 150, 51");
        dataLines4.add("basket, 150, 30");

        return new Object[][]{
                {dataLines1},
                {dataLines2},
                {dataLines3},
                {dataLines4}
        };
    }
}