package com.epamcourse.homework3.entity;

public class Ball {
    public static final double MIN_WEIGHT = 0.5;
    public static final double MAX_WEIGHT = 3;

    private ItemColor color;
    private BallSize size;
    private double weight;

    public Ball(ItemColor color, BallSize size, double weight) {
        this.color = color;
        this.size = size;
        this.weight = weight;
    }

    public ItemColor getColor() {
        return color;
    }

    public void setColor(ItemColor color) {
        this.color = color;
    }

    public BallSize getSize() {
        return size;
    }

    public void setSize(BallSize size) {
        this.size = size;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        return Double.compare(ball.weight, weight) == 0 &&
                color == ball.color &&
                size == ball.size;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 17 * result + (color == null ? 0 : color.hashCode());
        result = 17 * result + (size == null ? 0 : size.hashCode());
        result = 17 * result + (int) weight;
        return result;
    }

    @Override
    public String toString() {
        return String.format("Ball color: %s, size: %s, weight: %.2f;",
                color.getColorName(), size.name(), weight);
    }
}