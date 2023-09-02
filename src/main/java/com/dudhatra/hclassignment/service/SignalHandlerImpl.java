package com.dudhatra.hclassignment.service;

import com.dudhatra.hclassignment.external.library.Algo;
import com.dudhatra.hclassignment.external.upstream.SignalHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * This is a trading service responsible for processing signals.
 * This service implements {@link SignalHandler} and processes signals.
 */
public class TradingService implements SignalHandler {

    private Map<Integer, Consumer<Algo>> signalHandlers;

    public TradingService() {
        this.initialiseSignalHandlers();
    }

    private void initialiseSignalHandlers() {
        signalHandlers = new HashMap<>();
        signalHandlers.put(1, this::handleSignal1);
        signalHandlers.put(2, this::handleSignal2);
        signalHandlers.put(3, this::handleSignal3);
    }

    public void handleSignal(int signal) {
        Algo algo = new Algo();
        Consumer<Algo> signalHandler = signalHandlers.getOrDefault(signal, this::defaultHandler);
        signalHandler.accept(algo);
        algo.doAlgo();
    }

    private void handleSignal1(Algo algo) {
        algo.setUp();
        algo.setAlgoParam(1, 60);
        algo.performCalc();
        algo.submitToMarket();
    }

    private void handleSignal2(Algo algo) {
        algo.reverse();
        algo.setAlgoParam(1, 80);
        algo.submitToMarket();
    }

    private void handleSignal3(Algo algo) {
        algo.setAlgoParam(1, 90);
        algo.setAlgoParam(2, 15);
        algo.performCalc();
        algo.submitToMarket();
    }

    private void defaultHandler(Algo algo) {
        algo.cancelTrades();
    }

}
