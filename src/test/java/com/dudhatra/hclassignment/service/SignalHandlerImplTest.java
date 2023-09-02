package com.dudhatra.hclassignment.service;

import com.dudhatra.hclassignment.external.library.Algo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class SignalHandlerImplTest {

    @Mock
    private AlgoInstanceGenerationService algoInstanceGenerationService;

    @InjectMocks
    private SignalHandlerImpl signalHandlerImpl;

    @Test
    public void testHandleSignal_WithValidSignal_1() {
        // Arrange
        int validSignal = 1;
        Algo algo = mock(Algo.class);
        when(algoInstanceGenerationService.generateNewAlgoInstance()).thenReturn(algo);

        // Act
        signalHandlerImpl.handleSignal(validSignal);

        // Assert
        // For signal 1, we need to make sure these four commands are executed:
        //  new SetUpCommand(),
        //  new SetAlgoParamCommand(1, 60),
        //  new PerformCalcCommand(),
        //  new SubmitToMarketCommand() and doAlgo() is for all the signals
        // Also make sure that the commands are executed in expected orders.
        InOrder inOrder = Mockito.inOrder(algo);
        inOrder.verify(algo, times(1)).setUp();
        inOrder.verify(algo, times(1)).setAlgoParam(1, 60);
        inOrder.verify(algo, times(1)).performCalc();
        inOrder.verify(algo, times(1)).submitToMarket();
        inOrder.verify(algo, times(1)).doAlgo();
    }

    @Test
    public void testHandleSignal_WithValidSignal_2() {
        // Arrange
        int validSignal = 2;
        Algo algo = mock(Algo.class);
        when(algoInstanceGenerationService.generateNewAlgoInstance()).thenReturn(algo);

        // Act
        signalHandlerImpl.handleSignal(validSignal);

        // Assert
        // For signal 2, we need to make sure these three commands are executed:
        //  new ReverseCommand(),
        //  new SetAlgoParamCommand(1, 80),
        //  new SubmitToMarketCommand() and doAlgo() is for all the signals
        // Also make sure that the commands are executed in expected orders.
        InOrder inOrder = Mockito.inOrder(algo);
        inOrder.verify(algo, times(1)).reverse();
        inOrder.verify(algo, times(1)).setAlgoParam(1, 80);
        inOrder.verify(algo, times(1)).submitToMarket();
        inOrder.verify(algo, times(1)).doAlgo();
    }

    @Test
    public void testHandleSignal_WithValidSignal_3() {
        // Arrange
        int validSignal = 3;
        Algo algo = mock(Algo.class);
        when(algoInstanceGenerationService.generateNewAlgoInstance()).thenReturn(algo);

        // Act
        signalHandlerImpl.handleSignal(validSignal);

        // Assert
        // For signal 3, we need to make sure these four commands are executed:
        //  new SetAlgoParamCommand(1, 90),
        //  new SetAlgoParamCommand(2, 15),
        //  new PerformCalcCommand(),
        //  new SubmitToMarketCommand() and doAlgo() is for all the signals
        // Also make sure that the commands are executed in expected orders.
        InOrder inOrder = Mockito.inOrder(algo);
        inOrder.verify(algo, times(1)).setAlgoParam(1, 90);
        inOrder.verify(algo, times(1)).setAlgoParam(2, 15);
        inOrder.verify(algo, times(1)).performCalc();
        inOrder.verify(algo, times(1)).submitToMarket();
        inOrder.verify(algo, times(1)).doAlgo();
    }

    @Test
    public void testHandleSignal_InvalidSignal() {
        // Arrange
        int invalidSignal = -1;
        Algo algo = mock(Algo.class);
        when(algoInstanceGenerationService.generateNewAlgoInstance()).thenReturn(algo);

        // Act
        signalHandlerImpl.handleSignal(invalidSignal);

        // Assert
        // For invalid signal, we need to make sure only one command is executed:
        //  new CancelTradesCommand() and doAlgo() is for all the signals
        // Also make sure that the commands are executed in expected orders.
        InOrder inOrder = Mockito.inOrder(algo);
        inOrder.verify(algo, times(1)).cancelTrades();
        inOrder.verify(algo, times(1)).doAlgo();
    }

    @Test
    void testHandleSignal_WhenAlgoInstanceIsNull() {
        // Arrange
        int validSignal = 1;
        when(algoInstanceGenerationService.generateNewAlgoInstance()).thenReturn(null);

        // Act
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> signalHandlerImpl.handleSignal(validSignal));

        // Assert
        assertNotNull(exception);
        assertEquals("Can not connect with Algo library.", exception.getMessage());
    }
}
