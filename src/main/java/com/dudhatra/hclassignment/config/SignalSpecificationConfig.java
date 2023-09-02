package com.dudhatra.hclassignment.config;

import com.dudhatra.hclassignment.commands.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The {@code SignalSpecificationConfig} class provides a configuration mechanism for mapping
 * trading signals to lists of {@link SignalCommand} instances, defining the actions to be taken
 * when each signal is received.
 * <p>
 * It contains methods to load predefined signal specifications and associated commands for
 * signals 1, 2, and 3. When adding new signal specifications, a new method should be added
 * to configure the commands for the new signal.
 *
 * @see SignalCommand
 */
public class SignalSpecificationConfig {

    /**
     * Loads and returns a mapping of trading signals to lists of associated
     * {@code SignalCommand} instances.
     *
     * @return A {@code Map<Integer, List<SignalCommand>>} representing signal specifications.
     */
    public static Map<Integer, List<SignalCommand>> loadSignalSpecifications() {
        Map<Integer, List<SignalCommand>> signalSpecifications = new HashMap<>();

        signalSpecifications.put(1, getSignalCommandsForSignal1());
        signalSpecifications.put(2, getSignalCommandsForSignal2());
        signalSpecifications.put(3, getSignalCommandsForSignal3());

        return signalSpecifications;
    }

    private static List<SignalCommand> getSignalCommandsForSignal1() {
        return Arrays.asList(
                new SetUpCommand(),
                new SetAlgoParamCommand(1, 60),
                new PerformCalcCommand(),
                new SubmitToMarketCommand());
    }

    private static List<SignalCommand> getSignalCommandsForSignal2() {
        return Arrays.asList(
                new ReverseCommand(),
                new SetAlgoParamCommand(1, 80),
                new SubmitToMarketCommand());
    }

    private static List<SignalCommand> getSignalCommandsForSignal3() {
        return Arrays.asList(
                new SetAlgoParamCommand(1, 90),
                new SetAlgoParamCommand(2, 15),
                new PerformCalcCommand(),
                new SubmitToMarketCommand());
    }

    // When adding new signal specifications, please add a new method following the same pattern.

}
