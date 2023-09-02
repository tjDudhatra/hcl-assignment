package com.dudhatra.hclassignment.commands;

import com.dudhatra.hclassignment.external.library.Algo;

public class SetAlgoParamCommand implements SignalCommand {

    private final int param;
    private final int value;

    public SetAlgoParamCommand(int param, int value) {
        this.param = param;
        this.value = value;
    }

    @Override
    public void execute(Algo algo) {
        algo.setAlgoParam(this.param, this.value);
    }
}
