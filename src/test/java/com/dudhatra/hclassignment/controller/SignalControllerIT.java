package com.dudhatra.hclassignment.controller;

import com.dudhatra.hclassignment.BaseIntegrationTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * The {@code SignalControllerIT} class represents an integration test for the
 * {@link SignalController} endpoint.
 * This test ensures that the endpoint is accessible and functions as expected in an end-to-end
 * scenario.
 * While integration tests are valuable, it's recommended to write fewer of them and focus more
 * on unit tests to maintain efficient testing practices.
 *
 * @see BaseIntegrationTest
 * @see ObjectMapper
 * @see MockMvc
 */
public class SignalControllerIT extends BaseIntegrationTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    /**
     * A test method to verify the successful processing of a trading signal through the
     * {@link SignalController} endpoint.
     *
     * @throws Exception If an exception occurs during the test execution.
     */
    @Test
    void testProcessSignal_Success() throws Exception {
        // Act
        MvcResult result = mockMvc.perform(post("/signals/process")
                        .content("1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Access-Control-Request-Method", "POST"))
                .andExpect(status().isOk()).andReturn();
        String responseStr = result.getResponse().getContentAsString();

        // Assert
        assertNotNull(responseStr);
        assertEquals("Signal processed successfully", responseStr);
    }
}
