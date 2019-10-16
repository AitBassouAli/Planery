package com.planery.calculator.service.implementation;

import com.planery.calculator.builder.MultiplicationResponseBuilder;
import com.planery.calculator.dto.MultiplicationRequest;
import com.planery.calculator.dto.MultiplicationResponse;
import com.planery.calculator.service.MultiplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DefaultMultiplicationService implements MultiplicationService {

    @Override
    public MultiplicationResponse multiply(MultiplicationRequest request) {

        MultiplicationResponse response = MultiplicationResponseBuilder
                .builder()
                .multiply(request.getNumber())
                .by(request.getMultiplier())
                .build();

        log.info("Multiplication response: {} ", response);
        return response;
    }
}
