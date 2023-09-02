package com.dudhatra.hclassignment.service;

import com.dudhatra.hclassignment.external.library.Algo;
import com.dudhatra.hclassignment.external.upstream.SignalHandler;

/**
 * This is your team’s code and should be changed as you see fit.
 */
public class Application implements SignalHandler {

    public void handleSignal(int signal) {
        Algo algo = new Algo();
        switch (signal) {
            case 1:
                algo.setUp();
                algo.setAlgoParam(1, 60);
                algo.performCalc();
                algo.submitToMarket();
                break;
            case 2:
                algo.reverse();
                algo.setAlgoParam(1, 80);
                algo.submitToMarket();
                break;
            case 3:
                algo.setAlgoParam(1, 90);
                algo.setAlgoParam(2, 15);
                algo.performCalc();
                algo.submitToMarket();
                break;
            default:
                algo.cancelTrades();
                break;
        }
        algo.doAlgo();
    }

}
