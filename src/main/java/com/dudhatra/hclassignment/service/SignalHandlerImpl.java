package com.dudhatra.hclassignment.service;

import com.dudhatra.hclassignment.commands.SignalCommand;
import com.dudhatra.hclassignment.config.SignalSpecificationConfig;
import com.dudhatra.hclassignment.external.library.Algo;
import com.dudhatra.hclassignment.external.upstream.SignalHandler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * This is a service, which implements {@link SignalHandler} interface.
 * {@link SignalHandlerImpl#handleSignal(int)} method is responsible for processing signals based
 * on their predefined implementation.
 */
@Service
public class SignalHandlerImpl implements SignalHandler {

    private final Map<Integer, List<SignalCommand>> signalSpecifications;

    public SignalHandlerImpl() {
        this.signalSpecifications = SignalSpecificationConfig.loadSignalSpecifications();
    }

    @Override
    public void handleSignal(int signal) {
        Algo algo = new Algo();
        List<SignalCommand> commands = signalSpecifications.get(signal);
        if (commands != null) {
            executeCommands(algo, commands);
        } else {
            defaultHandler(algo);
        }
        algo.doAlgo();
    }

    private void executeCommands(Algo algo, List<SignalCommand> commands) {
        for (SignalCommand command : commands) {
            command.execute(algo);
        }
    }

    private void defaultHandler(Algo algo) {
        algo.cancelTrades();
    }

}
