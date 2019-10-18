package com.planery.calculator.controller;


import com.planery.calculator.dto.MultiplicationRequest;
import com.planery.calculator.dto.MultiplicationResponse;
import com.planery.calculator.exception.InvalidRequestDataException;
import com.planery.calculator.exception.MultiplicationException;
import com.planery.calculator.service.MultiplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "multiplication")
@Slf4j
public class MultiplicationController {

    private MultiplicationService multiplicationService;


    public MultiplicationController(MultiplicationService multiplicationService) {
        this.multiplicationService = multiplicationService;
    }

    @PostMapping(value = "/multiply", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MultiplicationResponse> multiply(@RequestBody MultiplicationRequest request) {

        if (request == null)
            throw new InvalidRequestDataException(" Multiplication data is required ");

        log.info("Multiplication request: {} ", request);
        MultiplicationResponse response = multiplicationService.multiply(request);

        if (response == null)
            throw new MultiplicationException(" An error has been occurred while multiplying ");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}