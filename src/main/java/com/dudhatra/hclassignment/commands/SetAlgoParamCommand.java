package com.dudhatra.hclassignment.commands;

import com.dudhatra.hclassignment.external.library.Algo;

/**
 * The {@code SetAlgoParamCommand} class implements the {@link SignalCommand} interface
 * to set specific trading algorithm parameters using the {@link Algo} instance.
 * <p>
 * When executed, this command calls the {@link Algo#setAlgoParam(int, int)} method to configure
 * a trading algorithm parameter with the specified parameter value.
 *
 * @see SignalCommand
 * @see Algo
 */
public class SetAlgoParamCommand implements SignalCommand {

    private final int param;
    private final int value;

    /**
     * Constructs a new {@code SetAlgoParamCommand} with the specified parameter and value.
     *
     * @param param The parameter to set on the trading algorithm.
     * @param value The value to assign to the specified parameter.
     */
    public SetAlgoParamCommand(int param, int value) {
        this.param = param;
        this.value = value;
    }

    /**
     * Execute the action to set a trading algorithm parameter with the specified value on the
     * provided {@link Algo} instance.
     *
     * @param algo The {@code Algo} instance on which the parameter will be set.
     */
    @Override
    public void execute(Algo algo) {
        algo.setAlgoParam(this.param, this.value);
    }
}
