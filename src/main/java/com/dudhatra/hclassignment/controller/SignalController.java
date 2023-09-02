package com.dudhatra.hclassignment.controller;

import com.dudhatra.hclassignment.external.upstream.SignalHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The {@code SignalController} class defines a RESTful controller for processing trading signals.
 * It provides an HTTP POST endpoint for receiving and handling trading signals using the
 * configured {@link SignalHandler}.
 *
 * @see SignalHandler
 */
@RestController
@RequestMapping("/signals")
@RequiredArgsConstructor
public class SignalController {

    private final SignalHandler signalHandler;

    /**
     * Handles incoming trading signals by delegating the signal processing to the
     * {@link SignalHandler}.
     * Returns a response indicating the success or failure of signal processing.
     *
     * @param signal The trading signal to be processed.
     * @return A {@code ResponseEntity<String>} with a success or error message.
     */
    @PostMapping("/process")
    public ResponseEntity<String> processSignal(@RequestBody int signal) {
        try {
            signalHandler.handleSignal(signal);
            return ResponseEntity.ok("Signal processed successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing signal");
        }
    }

}
