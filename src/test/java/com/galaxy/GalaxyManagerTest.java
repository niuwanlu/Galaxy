package com.galaxy;

import com.galaxy.constant.RomanNum;
import com.galaxy.mapper.GoodMapper;
import com.galaxy.mapper.UnitMapper;
import com.galaxy.parser.InputLineParser;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class GalaxyManagerTest {

    private GalaxyManager galaxyManager;

    @Mock
    InputLineParser inputLineParser;

    @Mock
    UnitMapper unitMapper;

    @Mock
    GoodMapper goodMapper;

    @Before
    public void setUp() {
        initMocks(this);
        galaxyManager = new GalaxyManager(inputLineParser, unitMapper, goodMapper);
    }

    @Test
    public void shouldPutUnitNameAndRomanNumIntoMapWhenUnitState() throws Exception {
        when(inputLineParser.getUnitNameFromUnitState("glob is I")).thenReturn("glob");
        when(inputLineParser.getRomanNumeralFromUnitState("glob is I")).thenReturn(RomanNum.I);
        galaxyManager.processInput("glob is I");
        verify(inputLineParser).getUnitNameFromUnitState("glob is I");
        verify(inputLineParser).getRomanNumeralFromUnitState("glob is I");
        verify(unitMapper).putIntoUnitMap("glob", RomanNum.I);
    }

    @Test
    public void shouldCalculateUnitTotalWhenUnitQuestion() throws Exception {
        when(inputLineParser.getUnitListInlineFromUnitQuestion("how much is pish tegj?")).thenReturn("pish tegj");
        galaxyManager.processInput("how much is pish tegj?");
        verify(inputLineParser, atLeast(1)).getUnitListInlineFromUnitQuestion("how much is pish tegj?");
        verify(inputLineParser).getUnitListFromUnitListInline("pish tegj");
        verify(unitMapper).getTotalValueOfUnitList(any(String[].class));
    }

    @Test
    public void shouldInvokeGetTotalValueOfUnitListWhenCreditState() throws Exception {
        String[] strList = {"glob", "glob"};
        when(inputLineParser.getUnitListInlineFromCreditState("glob glob Silver is 34 Credits")).thenReturn("glob glob");
        when(inputLineParser.getUnitListFromUnitListInline("glob glob")).thenReturn(strList);
        when(inputLineParser.getGoodTotalCreditsFromCreditState("glob glob Silver is 34 Credits")).thenReturn(34);
        when(inputLineParser.getGoodNameFromCreditState("glob glob Silver is 34 Credits")).thenReturn("Silver");
        when(unitMapper.getTotalValueOfUnitList(strList)).thenReturn(2);
        galaxyManager.processInput("glob glob Silver is 34 Credits");
        verify(inputLineParser).getUnitListInlineFromCreditState("glob glob Silver is 34 Credits");
        verify(inputLineParser).getUnitListFromUnitListInline(any(String.class));
        verify(unitMapper).getTotalValueOfUnitList(any(String[].class));
        verify(inputLineParser).getGoodTotalCreditsFromCreditState(any(String.class));
        verify(inputLineParser).getGoodNameFromCreditState("glob glob Silver is 34 Credits");
    }

    @Test
    public void shouldPutGoodNameAndUnivalenceIntoMapWhenCreditState() throws Exception {
        String[] strList = {"glob", "glob"};
        when(inputLineParser.getUnitListInlineFromCreditState("glob glob Silver is 34 Credits")).thenReturn("glob glob");
        when(inputLineParser.getUnitListFromUnitListInline("glob glob")).thenReturn(strList);
        when(inputLineParser.getGoodTotalCreditsFromCreditState("glob glob Silver is 34 Credits")).thenReturn(34);
        when(inputLineParser.getGoodNameFromCreditState("glob glob Silver is 34 Credits")).thenReturn("Silver");
        when(unitMapper.getTotalValueOfUnitList(strList)).thenReturn(2);
        galaxyManager.processInput("glob glob Silver is 34 Credits");
        verify(goodMapper).putIntoGoodMap("Silver", 17);
    }

    @Test
    public void shouldInvokeWhenCreditQuestion() throws Exception {
        String[] strList = {"glob", "prok"};
        when(inputLineParser.getUnitListInlineFromCreditQuestion("how many Credits is glob prok Silver ?")).thenReturn("glob prok");
        when(inputLineParser.getUnitListFromUnitListInline("glob prok")).thenReturn(strList);
        when(inputLineParser.getGoodNameFromCreditQuestion("how many Credits is glob prok Silver ?")).thenReturn("Silver");
        galaxyManager.processInput("how many Credits is glob prok Silver ?");
        verify(inputLineParser).getUnitListInlineFromCreditQuestion("how many Credits is glob prok Silver ?");
        verify(inputLineParser).getUnitListFromUnitListInline("glob prok");
        verify(unitMapper).getTotalValueOfUnitList(strList);
        verify(inputLineParser).getGoodNameFromCreditQuestion("how many Credits is glob prok Silver ?");
        verify(goodMapper).getUnivalenceByName("Silver");

    }

    @Test
    public void shouldReturnNoIdeaWhenElse() throws Exception {
        assertEquals("I have no idea what you are talking about", galaxyManager.processInput("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
    }
}