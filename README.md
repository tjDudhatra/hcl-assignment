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