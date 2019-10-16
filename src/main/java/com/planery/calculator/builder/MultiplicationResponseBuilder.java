package com.planery.calculator.builder;

import com.planery.calculator.dto.MultiplicationResponse;

public final class MultiplicationResponseBuilder {

    private int number;
    private int multiplier;

    public static MultiplicationResponseBuilder builder() {
        return new MultiplicationResponseBuilder();
    }

    public MultiplicationResponseBuilder multiply(int number) {
        this.number = number;
        return this;
    }

    public MultiplicationResponseBuilder by(int multiplier) {
        this.multiplier = multiplier;
        return this;
    }

    public MultiplicationResponse build() {
        MultiplicationResponse response = new MultiplicationResponse();
        response.setNumber(this.number);
        response.setMultiplier(this.multiplier);
        response.setMultiplicationResult(doMultiplication());
        return response;
    }

    private int doMultiplication() {
        return this.number * this.multiplier;
    }

}
