package com.dudhatra.hclassignment.service;

import com.dudhatra.hclassignment.external.library.Algo;
import org.springframework.stereotype.Service;

@Service
public class AlgoInstanceGenerationService {

    public Algo generateNewAlgoInstance() {
        return new Algo();
    }

}
