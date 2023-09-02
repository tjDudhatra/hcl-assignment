package com.dudhatra.hclassignment.commands;

import com.dudhatra.hclassignment.external.library.Algo;

public class CancelTradesCommand implements SignalCommand {

    @Override
    public void execute(Algo algo) {
        algo.cancelTrades();
    }
}
