package com.dudhatra.hclassignment.commands;

import com.dudhatra.hclassignment.external.library.Algo;

/**
 * The {@code SetUpCommand} class implements the {@link SignalCommand} interface
 * to configure trading parameters and prepare the {@link Algo} instance for trading.
 * <p>
 * When executed, this command calls the {@link Algo#setUp()} method to set up
 * specific trading parameters on the provided {@code Algo} instance.
 *
 * @see SignalCommand
 * @see Algo
 */
public class SetUpCommand implements SignalCommand {

    /**
     * Execute the setup action by configuring trading parameters on the provided {@link Algo}
     * instance.
     *
     * @param algo The {@code Algo} instance on which trading parameters will be configured.
     */
    @Override
    public void execute(Algo algo) {
        algo.setUp();
    }
}
