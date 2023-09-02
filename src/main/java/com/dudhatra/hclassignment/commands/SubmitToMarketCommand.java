package com.dudhatra.hclassignment.commands;

import com.dudhatra.hclassignment.external.library.Algo;

/**
 * The {@code SubmitToMarketCommand} class implements the {@link SignalCommand} interface
 * to submit trading orders to the market using the {@link Algo} instance.
 * <p>
 * When executed, this command calls the {@link Algo#submitToMarket()} method to initiate
 * the submission of trading orders to the market.
 *
 * @see SignalCommand
 * @see Algo
 */
public class SubmitToMarketCommand implements SignalCommand {

    @Override
    public void execute(Algo algo) {
        algo.submitToMarket();
    }
}
