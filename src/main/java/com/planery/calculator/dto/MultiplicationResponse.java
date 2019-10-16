package com.planery.calculator.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class MultiplicationResponse implements Serializable {

    private static final long SerialVersionUID = 1L;
    private int number;
    private int multiplier;
    private int multiplicationResult;

}
