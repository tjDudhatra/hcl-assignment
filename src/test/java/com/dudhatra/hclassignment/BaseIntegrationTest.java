package com.dudhatra.hclassignment;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * The {@code BaseIntegrationTest} class is a base class for integration tests within the HCL
 * Interview Assignment application.
 * It provides a common configuration for integration tests to avoid duplication of setup.
 * When writing integration tests, it is good practice to inherit from this class.
 *
 * @see ActiveProfiles
 * @see SpringBootTest
 * @see AutoConfigureMockMvc
 */
@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public class BaseIntegrationTest {

    /**
     * A placeholder test method to ensure the Spring context loads successfully in integration
     * tests.
     * Subclasses may override or add additional test methods as needed.
     */
    @Test
    void contextLoads() {

    }

}
