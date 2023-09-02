package com.dudhatra.hclassignment.controller;

import com.dudhatra.hclassignment.BaseIntegrationTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Aim of this integration test is just to make sure that the endpoint is accessible and, it is
 * working as expected end to end.
 * Integration tests takes longer to run, so it is best practice to write less integration tests
 * but write more and more unit tests.
 */
public class SignalControllerIT extends BaseIntegrationTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testProcessSignal_Success() throws Exception {
        // Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/signals/process")
                        .content("1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Access-Control-Request-Method", "POST"))
                .andExpect(status().isOk())
                .andReturn();
        String responseStr = result.getResponse().getContentAsString();

        // Assert
        assertNotNull(responseStr);
        assertEquals("Signal processed successfully", responseStr);
    }
}
