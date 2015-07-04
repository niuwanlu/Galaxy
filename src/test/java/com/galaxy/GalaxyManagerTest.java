package com.galaxy;

import com.galaxy.calculator.UnitTotalCalculator;
import com.galaxy.processor.UnitStateProcessor;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class GalaxyManagerTest {

    private GalaxyManager galaxyManager;

    @Mock
    UnitStateProcessor unitStateProcessor;

    @Mock
    UnitTotalCalculator unitTotalCalculator;

    @Before
    public void setUp() {
        initMocks(this);
        galaxyManager = new GalaxyManager(unitStateProcessor, unitTotalCalculator);
    }

    @Test
    public void shouldCheckInputType() throws Exception {
        galaxyManager.processInput("glob is I");
        verify(unitStateProcessor).process("glob is I");
    }

    @Test
    public void shouldInvokeUnitTotalCalculatorWhenPriceQuestion() throws Exception {
        galaxyManager.processInput("how much is pish tegj?");
        verify(unitTotalCalculator).process("how much is pish tegj?");
    }
}