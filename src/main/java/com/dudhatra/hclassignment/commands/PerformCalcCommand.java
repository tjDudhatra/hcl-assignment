package com.dudhatra.hclassignment.commands;

import com.dudhatra.hclassignment.external.library.Algo;

public class PerformCalcCommand implements SignalCommand {

    @Override
    public void execute(Algo algo) {
        algo.performCalc();
    }
}
