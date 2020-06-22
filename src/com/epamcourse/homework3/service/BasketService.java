package com.epamcourse.homework3.service;


import com.epamcourse.homework3.entity.Ball;
import com.epamcourse.homework3.entity.Basket;
import com.epamcourse.homework3.entity.ItemColor;

import java.util.List;

public class BasketService {

    public double calculateBallsWeight(Basket basket) {
        double weight = 0;

        if (basket != null) {
            List<Ball> balls = basket.getBalls();

            for (Ball ball : balls) {
                if (ball != null) {
                    weight += ball.getWeight();
                }
            }
        } else {
            weight = -1;
        }

        return weight;
    }

    public int calculateSameColorBalls(Basket basket, ItemColor ballColor) {
        int count = 0;

        if (basket != null) {
            List<Ball> balls = basket.getBalls();

            for (Ball ball : balls) {
                if (ball != null) {
                    if (ball.getColor() == ballColor) {
                        count++;
                    }
                }
            }
        } else {
            count = -1;
        }

        return count;
    }

    public double calculateBasketFreeVolume(Basket basket) {
        double availableVolume = 0;

        if (basket != null) {
            availableVolume = basket.getVolume();
            List<Ball> balls = basket.getBalls();

            if (balls != null) {
                for (Ball lyingBall : balls) {
                    if (lyingBall != null) {
                        availableVolume -= lyingBall.getSize().getVolume();
                    }
                }
            }
        } else {
            availableVolume = -1;
        }

        return availableVolume;
    }

    public double calculateBasketFreePayload(Basket basket) {
        double availablePayload = 0;

        if (basket != null) {
            availablePayload = basket.getPayload();
            List<Ball> balls = basket.getBalls();

            if (balls != null) {
                for (Ball lyingBall : balls) {
                    if (lyingBall != null) {
                        availablePayload -= lyingBall.getWeight();
                    }
                }
            }
        } else {
            availablePayload = -1;
        }

        return availablePayload;
    }

    public int loadBasket(Basket basket, List<Ball> ballsArray) {
        int numberPlacedBalls = 0;
        double availableVolume;
        double availablePayload;

        if (basket != null && ballsArray != null) {
            availableVolume = calculateBasketFreeVolume(basket);
            availablePayload = calculateBasketFreePayload(basket);

            for (Ball ball : ballsArray) {
                if (ball != null) {

                    if (ball.getWeight() <= availablePayload) {
                        if (ball.getSize().getVolume() <= availableVolume) {
                            basket.addBall(ball);
                            availablePayload -= ball.getWeight();
                            availableVolume -= ball.getSize().getVolume();
                            numberPlacedBalls++;
                        }
                    }
                }
            }
        } else {
            numberPlacedBalls = -1;
        }

        return numberPlacedBalls;
    }
}