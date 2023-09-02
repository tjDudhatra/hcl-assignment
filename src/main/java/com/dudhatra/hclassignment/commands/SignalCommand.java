package com.dudhatra.hclassignment.commands;

import com.dudhatra.hclassignment.external.library.Algo;

/**
 * The {@code SignalCommand} interface represents a command that encapsulates
 * a specific action to be executed based on a trading signal.
 * <p>
 * Implementations of this interface define the behavior for processing
 * different trading signals by providing concrete implementations of the
 * {@link #execute(Algo)} method.
 *
 * @see Algo
 */
public interface SignalCommand {

    /**
     * Execute the trading action associated with this command on the provided
     * {@link Algo} instance.
     *
     * @param algo The {@code Algo} instance on which the trading action will be performed.
     */
    void execute(Algo algo);
}
