package com.galaxy;

import com.galaxy.constant.RomanNum;
import com.galaxy.mapper.GoodMapper;
import com.galaxy.mapper.UnitMapper;
import com.galaxy.parser.InputLineContentParser;
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
    InputLineContentParser inputLineContentParser;

    @Mock
    UnitMapper unitMapper;

    @Mock
    GoodMapper goodMapper;

    @Before
    public void setUp() {
        initMocks(this);
        galaxyManager = new GalaxyManager(inputLineContentParser, unitMapper, goodMapper);
    }

    @Test
    public void shouldPutUnitNameAndRomanNumIntoMapWhenUnitState() throws Exception {
        when(inputLineContentParser.getUnitNameFromUnitState("glob is I")).thenReturn("glob");
        when(inputLineContentParser.getRomanNumeralFromUnitState("glob is I")).thenReturn(RomanNum.I);
        galaxyManager.processInput("glob is I");
        verify(inputLineContentParser).getUnitNameFromUnitState("glob is I");
        verify(inputLineContentParser).getRomanNumeralFromUnitState("glob is I");
        verify(unitMapper).putIntoUnitMap("glob", RomanNum.I);
    }

    @Test
    public void shouldCalculateUnitTotalWhenUnitQuestion() throws Exception {
        when(inputLineContentParser.getUnitListInlineFromUnitQuestion("how much is pish tegj?")).thenReturn("pish tegj");
        galaxyManager.processInput("how much is pish tegj?");
        verify(inputLineContentParser, atLeast(1)).getUnitListInlineFromUnitQuestion("how much is pish tegj?");
        verify(inputLineContentParser).getUnitListFromUnitListInline("pish tegj");
        verify(unitMapper).getTotalValueOfUnitList(any(String[].class));
    }

    @Test
    public void shouldPutGoodNameAndUnivalenceIntoMapWhenCreditState() throws Exception {
        String[] strList = {"glob", "glob"};
        when(inputLineContentParser.getUnitListInlineFromCreditState("glob glob Silver is 34 Credits")).thenReturn("glob glob");
        when(inputLineContentParser.getUnitListFromUnitListInline("glob glob")).thenReturn(strList);
        when(inputLineContentParser.getGoodTotalCreditsFromCreditState("glob glob Silver is 34 Credits")).thenReturn(34);
        when(inputLineContentParser.getGoodNameFromCreditState("glob glob Silver is 34 Credits")).thenReturn("Silver");
        when(unitMapper.getTotalValueOfUnitList(strList)).thenReturn(2);
        galaxyManager.processInput("glob glob Silver is 34 Credits");
        verify(inputLineContentParser).getUnitListInlineFromCreditState("glob glob Silver is 34 Credits");
        verify(inputLineContentParser).getUnitListFromUnitListInline(any(String.class));
        verify(unitMapper).getTotalValueOfUnitList(any(String[].class));
        verify(inputLineContentParser).getGoodTotalCreditsFromCreditState(any(String.class));
        verify(inputLineContentParser).getGoodNameFromCreditState("glob glob Silver is 34 Credits");
        verify(goodMapper).putIntoGoodMap("Silver", 17);
    }

    @Test
    public void shouldInvokeWhenCreditQuestion() throws Exception {
        String[] strList = {"glob", "prok"};
        when(inputLineContentParser.getUnitListInlineFromCreditQuestion("how many Credits is glob prok Silver ?")).thenReturn("glob prok");
        when(inputLineContentParser.getUnitListFromUnitListInline("glob prok")).thenReturn(strList);
        when(inputLineContentParser.getGoodNameFromCreditQuestion("how many Credits is glob prok Silver ?")).thenReturn("Silver");
        galaxyManager.processInput("how many Credits is glob prok Silver ?");
        verify(inputLineContentParser).getUnitListInlineFromCreditQuestion("how many Credits is glob prok Silver ?");
        verify(inputLineContentParser).getUnitListFromUnitListInline("glob prok");
        verify(unitMapper).getTotalValueOfUnitList(strList);
        verify(inputLineContentParser).getGoodNameFromCreditQuestion("how many Credits is glob prok Silver ?");
        verify(goodMapper).getUnivalenceByName("Silver");
    }

    @Test
    public void shouldReturnNoIdeaWhenElse() throws Exception {
        assertEquals("I have no idea what you are talking about", galaxyManager.processInput("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
    }
}