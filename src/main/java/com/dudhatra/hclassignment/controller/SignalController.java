package com.dudhatra.hclassignment.controller;

import com.dudhatra.hclassignment.external.upstream.SignalHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signals")
@RequiredArgsConstructor
public class SignalController {

    private final SignalHandler signalHandler;

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
