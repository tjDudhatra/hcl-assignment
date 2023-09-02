package com.dudhatra.hclassignment.service;

import com.dudhatra.hclassignment.external.library.Algo;
import org.springframework.stereotype.Service;

/**
 * The {@code AlgoInstanceGenerationService} class provides a service for generating new instances
 * of the {@link Algo} class. It is responsible for creating and returning fresh instances of the
 * trading algorithm to be used in signal processing.
 *
 * @see Algo
 */
@Service
public class AlgoInstanceGenerationService {

    /**
     * Generates a new instance of the {@link Algo} class.
     *
     * @return A new {@code Algo} instance.
     */
    public Algo generateNewAlgoInstance() {
        return new Algo();
    }

}
