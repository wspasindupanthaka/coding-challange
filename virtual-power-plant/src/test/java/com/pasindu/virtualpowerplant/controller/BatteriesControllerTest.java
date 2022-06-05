package com.pasindu.virtualpowerplant.controller;

import com.pasindu.virtualpowerplant.entity.Battery;
import com.pasindu.virtualpowerplant.repository.BatteriesRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc

public class BatteriesControllerTest {

@Autowired
    private MockMvc mvc;

    @Mock
    BatteriesRepository batteriesRepository;


    @Test
    public void testGetBatteriesInAPostCodeRange_StatusIsSuccessful() throws Exception {
        given(batteriesRepository.findByPostCodeBetween(2000,6000)).willReturn(
                Arrays.asList(new Battery(1, "Test 1", 2001, 2000)),
                Arrays.asList(new Battery(2, "Test 2", 3001, 3000)),
                Arrays.asList(new Battery(3, "Test 3", 4001, 4000)),
                Arrays.asList(new Battery(4, "Test 4", 5001, 5000))
        );

        MockHttpServletResponse response = mvc.perform(
                        get("/batteries/in-a-post-code-range?lowerRange=2000&upperRange=6000")
                                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        Assert.isTrue(response.getStatus()== HttpStatus.OK.value(), "Status Code is Not OK");
    }

}
