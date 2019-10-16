package com.planery.calculator.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.planery.calculator.builder.MultiplicationResponseBuilder;
import com.planery.calculator.dto.MultiplicationRequest;
import com.planery.calculator.dto.MultiplicationResponse;
import com.planery.calculator.service.MultiplicationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import sun.plugin2.util.PojoUtil;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.Matchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(MultiplicationController.class)
public class MultiplicationControllerTest {

    private static final int NUMBER = 10;
    private static final int MULTIPLIER = 100;
    private static final String API = "http://localhost:8080";
    @Autowired
    private MockMvc mvc;

    @MockBean
    private MultiplicationService multiplicationService;

    @Test
    public void multiply() throws Exception {

        MultiplicationResponse response = MultiplicationResponseBuilder
                .builder()
                .multiply(NUMBER)
                .by(MULTIPLIER)
                .build();

        given(multiplicationService.multiply(ArgumentMatchers.any())).willReturn(response);
        mvc.perform(post(API + "/multiply")
                .content(asJsonString(new MultiplicationRequest()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.multiplicationResult", is(NUMBER * MULTIPLIER)));

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}