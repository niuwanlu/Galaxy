package com.galaxy;

import com.galaxy.constant.RomanNum;
import com.galaxy.parser.InputLineParser;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
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
    public void shouldCalculateUnitTotalWhenPriceQuestion() throws Exception {
        galaxyManager.processInput("how much is pish tegj?");
        verify(inputLineParser).getUnitList("how much is pish tegj?");
        verify(unitMapper).getTotalValueOfUnitList(any(String[].class));
    }

    @Test
    public void shouldInvokeGetTotalValueOfUnitListWhenCreditState() throws Exception {
        galaxyManager.processInput("glob glob Silver is 34 Credits");
        verify(inputLineParser).getUnitListInlineFromCreditState("glob glob Silver is 34 Credits");
        verify(inputLineParser).getUnitList(any(String.class));
        verify(unitMapper).getTotalValueOfUnitList(any(String[].class));
        verify(inputLineParser).getGoodTotalCreditsFromCreditState(any(String.class));
    }

    @Test
    public void shouldReturnNoIdeaWhenElse() throws Exception {
        assertEquals("I have no idea what you are talking about", galaxyManager.processInput("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
    }
}