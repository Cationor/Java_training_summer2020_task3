package com.epamcourse.homework3.parser;

import com.epamcourse.homework3.entity.Ball;
import com.epamcourse.homework3.entity.BallSize;
import com.epamcourse.homework3.entity.Basket;
import com.epamcourse.homework3.entity.ItemColor;

public class EntityParser {
    private static final String REGEX_SPLITTER = ",";
    private static final int BALL_COLOR_INDEX = 1;
    private static final int BALL_SIZE_INDEX = 2;
    private static final int BALL_WEIGHT_INDEX = 3;
    private static final int BASKET_VOLUME_INDEX = 1;
    private static final int BASKET_PAYLOAD_INDEX = 2;

    public Ball parseBall(String ballData) {
        String[] elements = ballData.split(REGEX_SPLITTER);

        ItemColor ballColor = ItemColor.valueOf(elements[BALL_COLOR_INDEX].trim());
        BallSize ballSize = BallSize.valueOf(elements[BALL_SIZE_INDEX].trim());
        double ballWeight = Double.parseDouble(elements[BALL_WEIGHT_INDEX].trim());

        return new Ball(ballColor, ballSize, ballWeight);
    }

    public Basket parseBasket(String basketData) {
        String[] elements = basketData.split(REGEX_SPLITTER);

        double basketVolume = Double.parseDouble(elements[BASKET_VOLUME_INDEX]);
        double basketPayload = Double.parseDouble(elements[BASKET_PAYLOAD_INDEX]);

        return new Basket(basketVolume, basketPayload);
    }
}