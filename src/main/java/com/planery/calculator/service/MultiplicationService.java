package com.planery.calculator.service;

import com.planery.calculator.dto.MultiplicationRequest;
import com.planery.calculator.dto.MultiplicationResponse;

public interface MultiplicationService {

    MultiplicationResponse multiply(MultiplicationRequest request);
}
