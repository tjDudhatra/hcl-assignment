package com.dudhatra.hclassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The {@code HclAssignmentApplication} class serves as the entry point for the HCL Interview
 * Assignment application.
 * It uses Spring Boot to initialize and run the application, allowing it to handle trading
 * signals as per the specified requirements.
 */
@SpringBootApplication
public class HclAssignmentApplication {

    /**
     * The main method that starts the HCL Interview Assignment application.
     *
     * @param args Command-line arguments (if any) passed to the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(HclAssignmentApplication.class, args);
    }

}
