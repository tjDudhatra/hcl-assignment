# HCL Interview Assignment

## Overview

This repository contains the code for the HCL Interview Assignment, a Java-based trading application built with Spring Boot 3.1.3. This document provides instructions on how to build and run the service, along with a brief introduction to the tech stack and tools used.

### Tech Stack

- Java 17
- Spring Boot 3.1.3

### Tools & Libraries

- Lombok
- Apache Commons Lang3

## Getting Started

Follow these simple steps to build and run the trading application on your local environment.

### Prerequisites

- Java Development Kit (JDK) 17
- Apache Maven

### Build and Run

1. **Compile and Package**: Open your terminal and navigate to the project's root directory. Run the following command to compile and package the service:

   ```
   mvn clean install
   ```

   This command will generate a runnable JAR file in the `target` folder.

2. **Locate the JAR File**: After the build process is complete, find the generated JAR file within the `target` directory. It will be named something like `hcl-assignment-{VERSION_NAME}.jar`.

3. **Run the Service**: Start the Spring Boot service by executing the following command:

   ```
   java -jar hcl-assignment-{VERSION_NAME}.jar
   ```

   This command will launch the service on a Tomcat server, listening on port 8080.

4. **Check the Logs**: As the service starts, you will see log messages indicating its progress. Look for a success message similar to the following:

   ```
   ...Tomcat started on port(s): 8080 (http) with context path ''
   ...Started HclAssignmentApplication...
   ```

   This confirms that the service is up and running.

5. **Access the Health Check Endpoint**: Open your web browser or API client and navigate to the health check endpoint:

   ```
   http://localhost:8080/actuator/health
   ```

   You should receive a response with a status code of 200 and a JSON body like this:

   ```
   {"status":"UP"}
   ```

   This confirms that the service is healthy and operational.

## System Design

### Signal Handling Mechanism

The system is designed to handle trading signals dynamically using a flexible and maintainable approach. The core components of the design include:

1. **SignalHandlerImpl**: This class implements the `SignalHandler` interface and is responsible for processing signals. It leverages a configuration-driven approach to determine the actions associated with each signal.

2. **SignalSpecificationConfig**: The signal specifications are loaded from a configuration source (e.g., JSON or YAML file - currently hardcoded) during the initialization of the `SignalHandlerImpl`. Each signal is mapped to a list of `SignalCommand` instances, which define the actions to be executed when the signal is received.

3. **SignalCommand**: Command classes encapsulate the logic for executing specific actions on the `Algo` class. These commands are configurable and can be extended to accommodate new signal specifications.

### Adding New Signal Specifications

To add a new signal specification in the future, follow these steps:

1. **Create a Signal Specification Configuration**:
   - Define the new signal in the signal specification configuration source. Map the signal to a list of `SignalCommand` instances, specifying the actions to be executed for the new signal.

2. **Implement Signal Commands**:
   - Create new `SignalCommand` classes or modify existing ones to encapsulate the logic for the actions associated with the new signal.

3. **Update Unit Tests**:
   - Write unit tests to verify that the new signal is correctly processed, similar to the existing tests for signals 1, 2, and 3. Ensure that the associated commands are executed as expected.

### Notes

1. **Test Naming Conventions**:
   - Integration test file names should end with 'IT.java,' e.g., `SignalControllerIT.java`.
   - Unit test file names should end with 'Test.java,' e.g., `SignalHandlerImplTest.java`.
   - When registering a new signal, make sure to write unit tests to verify that all associated commands are executed correctly, following the pattern used for signals 1, 2, and 3 in `SignalHandlerImplTest`.