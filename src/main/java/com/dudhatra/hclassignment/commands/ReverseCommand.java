package com.dudhatra.hclassignment.commands;

import com.dudhatra.hclassignment.external.library.Algo;

/**
 * The {@code ReverseCommand} class implements the {@link SignalCommand} interface
 * to perform a trading operation for reversing positions using the {@link Algo} instance.
 * <p>
 * When executed, this command calls the {@link Algo#reverse()} method to initiate
 * the reversal of trading positions.
 *
 * @see SignalCommand
 * @see Algo
 */
public class ReverseCommand implements SignalCommand {

    /**
     * Execute the reversal action on the provided {@link Algo} instance to reverse trading
     * positions.
     *
     * @param algo The {@code Algo} instance on which the reversal of positions will be performed.
     */
    @Override
    public void execute(Algo algo) {
        algo.reverse();
    }
}
