package com.epamcourse.homework3.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Basket {
    public static final double MIN_VOLUME = 50;
    public static final double MAX_VOLUME = 700;
    public static final double MIN_PAYLOAD = 3;
    public static final double MAX_PAYLOAD = 50;

    private final double volume;
    private final double payload;
    private List<Ball> balls;

    public Basket(double volume, double payload) {
        this.volume = volume;
        this.payload = payload;
        balls = new ArrayList<>();
    }

    public double getVolume() {
        return volume;
    }

    public double getPayload() {
        return payload;
    }

    public List<Ball> getBalls() {
        return Collections.unmodifiableList(balls);
    }

    public void addBall(Ball ball) {
        this.balls.add(ball);
    }

    public void removeBall(Ball ball) {
        this.balls.remove(ball);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Basket basket = (Basket) o;
        return Double.compare(basket.volume, volume) == 0 &&
                Double.compare(basket.payload, payload) == 0 &&
                balls.equals(basket.balls);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 17 * result + (int) volume;
        result = 17 * result + (int) payload;
        result = 17 * result + (balls == null ? 0 : balls.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return String.format("Basket volume: %.2f, payload: %.2f", volume, payload);
    }
}