package com.dudhatra.hclassignment.commands;

import com.dudhatra.hclassignment.external.library.Algo;

/**
 * The {@code PerformCalcCommand} class implements the {@link SignalCommand} interface
 * to perform calculations and computations using the {@link Algo} instance.
 * <p>
 * When executed, this command calls the {@link Algo#performCalc()} method to initiate
 * calculations associated with trading operations.
 *
 * @see SignalCommand
 * @see Algo
 */
public class PerformCalcCommand implements SignalCommand {

    /**
     * Execute the calculation action on the provided {@link Algo} instance.
     *
     * @param algo The {@code Algo} instance on which calculations will be performed.
     */
    @Override
    public void execute(Algo algo) {
        algo.performCalc();
    }
}
