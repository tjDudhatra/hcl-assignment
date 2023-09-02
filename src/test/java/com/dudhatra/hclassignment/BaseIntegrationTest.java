package com.dudhatra.hclassignment;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * When writing integration test, it is good practice to inherit this class.
 * This class will serve as a base class for all the integration tests so, we don't need to
 * duplicate the integration test configuration.
 */
@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public class BaseIntegrationTest {

    @Test
    void contextLoads() {

    }

}
