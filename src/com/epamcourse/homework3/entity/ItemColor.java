package com.epamcourse.homework3.entity;

public enum ItemColor {
    RED("Red"),
    ORANGE("Orange"),
    YELLOW("Yellow"),
    GREEN("Green"),
    BLUE("Blue"),
    PURPLE("Purple"),
    WHITE("White"),
    BLACK("Black"),
    GRAY("Gray"),
    BROWN("Brown");

    private final String colorName;

    ItemColor(String colorName) {
        this.colorName = colorName;
    }

    public String getColorName() {
        return colorName;
    }
}