package com.planery.calculator.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class MultiplicationRequest implements Serializable {

    private static final long SerialVersionUID = 10L;
    private int number;
    private int multiplier;
}
