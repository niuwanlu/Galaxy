package com.galaxy;

import com.galaxy.constant.RomanNum;
import com.galaxy.processor.InputLineParser;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class GalaxyManagerTest {

    private GalaxyManager galaxyManager;

    @Mock
    InputLineParser inputLineParser;

    @Mock
    UnitMapper unitMapper;

    @Before
    public void setUp() {
        initMocks(this);
        galaxyManager = new GalaxyManager(inputLineParser, unitMapper);
    }

    @Test
    public void shouldPutUnitNameAndRomanNumIntoMapWhenUnitState() throws Exception {
        when(inputLineParser.getUnitName("glob is I")).thenReturn("glob");
        when(inputLineParser.getRomanNumeral("glob is I")).thenReturn(RomanNum.I);
        galaxyManager.processInput("glob is I");
        verify(inputLineParser).getUnitName("glob is I");
        verify(inputLineParser).getRomanNumeral("glob is I");
        verify(unitMapper).putIntoUnitMap("glob", RomanNum.I);
    }

    @Test
    public void shouldInvokeUnitTotalCalculatorWhenPriceQuestion() throws Exception {
        galaxyManager.processInput("how much is pish tegj?");
        verify(inputLineParser).getUnitList("how much is pish tegj?");
        verify(unitMapper).getTotalValueOfUnitList(any(String[].class));
    }

}