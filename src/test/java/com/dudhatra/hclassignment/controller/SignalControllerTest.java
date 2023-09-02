package com.dudhatra.hclassignment.controller;

import com.dudhatra.hclassignment.external.upstream.SignalHandler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class SignalControllerTest {

    @Mock
    private SignalHandler signalHandler;

    @InjectMocks
    private SignalController signalController;

    @Test
    void testProcessSignal_Success() {
        // Arrange
        int signal = 2;

        // Act
        ResponseEntity<String> response = signalController.processSignal(signal);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Signal processed successfully", response.getBody());

        verify(signalHandler, times(1)).handleSignal(signal);
    }

    @Test
    void testProcessSignal_SignalHandlerThrowsAnException() {
        // Arrange
        int signal = 1;
        doThrow(RuntimeException.class).when(signalHandler).handleSignal(signal);

        // Act
        ResponseEntity<String> response = signalController.processSignal(signal);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Error processing signal", response.getBody());

        verify(signalHandler, times(1)).handleSignal(signal);
    }
}
