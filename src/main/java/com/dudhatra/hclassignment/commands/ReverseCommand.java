package com.dudhatra.hclassignment.commands;

import com.dudhatra.hclassignment.external.library.Algo;

public class ReverseCommand implements SignalCommand {

    @Override
    public void execute(Algo algo) {
        algo.reverse();
    }
}
