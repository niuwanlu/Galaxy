package com.galaxy.parser;

import com.galaxy.constant.RomanNum;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Spy;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

public class InputLineParserTest {

    @Spy
    InputLineParser inputLineParser;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void shouldReturnUnitName() throws Exception {
        assertEquals("glob", inputLineParser.getUnitNameFromUnitState("glob is I"));
    }

    @Test
    public void shouldGetRomanNumeral() throws Exception {
        assertEquals(RomanNum.I, inputLineParser.getRomanNumeralFromUnitState("glob is I"));
    }

    @Test
    public void shouldGetUnitList() throws Exception {
        String[] unitList = inputLineParser.getUnitListFromUnitListInline("pish tegj glob glob");
        assertEquals(4, unitList.length);
        assertEquals("pish", unitList[0]);
        assertEquals("tegj", unitList[1]);
        assertEquals("glob", unitList[2]);
        assertEquals("glob", unitList[3]);
    }

    @Test
    public void shouldGetUnitInlineFromCreditState() throws Exception {
        assertEquals("glob glob", inputLineParser.getUnitListInlineFromCreditState("glob glob Silver is 34 Credits"));
    }

    @Test
    public void shouldGetGoodNameFromCreditState() throws Exception {
        assertEquals("Silver", inputLineParser.getGoodNameFromCreditState("glob glob Silver is 34 Credits"));
    }

    @Test
    public void shouldGetGoodTotalCredits() throws Exception {
        assertEquals(34, inputLineParser.getGoodTotalCreditsFromCreditState("glob glob Silver is 34 Credits"));
    }

    @Test
    public void shouldGetUnitListInlineFromCreditQuestion() throws Exception {
        assertEquals("glob prok", inputLineParser.getUnitListInlineFromCreditQuestion("how many Credits is glob prok Silver ?"));
    }

    @Test
    public void shouldGetGoodNameFromCreditQuestion() throws Exception {
        assertEquals("Silver", inputLineParser.getGoodNameFromCreditQuestion("how many Credits is glob prok Silver ?"));
    }
}