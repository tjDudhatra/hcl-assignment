package com.dudhatra.hclassignment.commands;

import com.dudhatra.hclassignment.external.library.Algo;

public class DoAlgoCommand implements SignalCommand {

    @Override
    public void execute(Algo algo) {
        algo.doAlgo();
    }
}