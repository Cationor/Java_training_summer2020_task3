package com.epamcourse.homework3.validator;

import com.epamcourse.homework3.entity.Ball;
import com.epamcourse.homework3.entity.Basket;

public class EntityValidator {

    public boolean validateBall(Ball ball) {
        boolean isValid = true;

        if (Ball.MIN_WEIGHT > ball.getWeight() || ball.getWeight() > Ball.MAX_WEIGHT) {
            isValid = false;
        }
        if (ball.getSize() == null || ball.getColor() == null) {
            isValid = false;
        }

        return isValid;
    }

    public boolean validateBasket(Basket basket) {
        boolean isValid = true;

        if (Basket.MIN_PAYLOAD > basket.getPayload() || basket.getPayload() > Basket.MAX_PAYLOAD){
            isValid = false;
        }
        if (Basket.MIN_VOLUME > basket.getVolume() || basket.getVolume() > Basket.MAX_VOLUME){
            isValid = false;
        }

        return isValid;
    }
}