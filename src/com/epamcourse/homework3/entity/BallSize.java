package com.epamcourse.homework3.entity;

public enum BallSize {
    S(5),
    M(7),
    L(12),
    XL(16),
    XXL(20);

    private final int volume;

    BallSize(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }
}