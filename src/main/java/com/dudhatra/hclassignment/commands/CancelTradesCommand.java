package com.dudhatra.hclassignment.commands;

import com.dudhatra.hclassignment.external.library.Algo;

/**
 * The {@code CancelTradesCommand} class implements the {@link SignalCommand} interface
 * to cancel trading transactions on the {@link Algo} instance.
 * <p>
 * When executed, this command calls the {@link Algo#cancelTrades()} method to cancel
 * any ongoing or pending trading transactions.
 *
 * @see SignalCommand
 * @see Algo
 */
public class CancelTradesCommand implements SignalCommand {

    /**
     * Execute the cancel trades action to terminate ongoing or pending trading transactions
     * on the provided {@link Algo} instance.
     *
     * @param algo The {@code Algo} instance on which trading transactions will be canceled.
     */
    @Override
    public void execute(Algo algo) {
        algo.cancelTrades();
    }
}
