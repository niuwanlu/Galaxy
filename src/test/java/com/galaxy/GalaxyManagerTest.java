package com.galaxy;

import com.galaxy.calculator.UnitTotalCalculator;
import com.galaxy.constant.RomanNum;
import com.galaxy.processor.UnitStateProcessor;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class GalaxyManagerTest {

    private GalaxyManager galaxyManager;

    @Mock
    UnitStateProcessor unitStateProcessor;

    @Mock
    UnitTotalCalculator unitTotalCalculator;

    @Mock
    UnitMapper unitMapper;

    @Before
    public void setUp() {
        initMocks(this);
        galaxyManager = new GalaxyManager(unitStateProcessor, unitTotalCalculator, unitMapper);
    }

    @Test
    public void shouldGetUnitNameAndRomanNumWhenUnitState() throws Exception {
        when(unitStateProcessor.getUnitName("glob is I")).thenReturn("glob");
        when(unitStateProcessor.getRomanNumeral("glob is I")).thenReturn(RomanNum.I);
        galaxyManager.processInput("glob is I");
        verify(unitStateProcessor).getUnitName("glob is I");
        verify(unitStateProcessor).getRomanNumeral("glob is I");
        verify(unitMapper).putIntoUnitMap("glob", RomanNum.I);
    }

    @Test
    public void shouldInvokeUnitTotalCalculatorWhenPriceQuestion() throws Exception {
        galaxyManager.processInput("how much is pish tegj?");
        verify(unitTotalCalculator).process("how much is pish tegj?");
    }
}