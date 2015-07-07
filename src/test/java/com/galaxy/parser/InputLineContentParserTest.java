package com.galaxy.parser;

import com.galaxy.constant.RomanNum;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Spy;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

public class InputLineContentParserTest {

    @Spy
    InputLineContentParser inputLineContentParser;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void shouldReturnUnitName() throws Exception {
        assertEquals("glob", inputLineContentParser.getUnitNameFromUnitState("glob is I"));
    }

    @Test
    public void shouldGetRomanNumeral() throws Exception {
        assertEquals(RomanNum.I, inputLineContentParser.getRomanNumeralFromUnitState("glob is I"));
    }

    @Test
    public void shouldGetUnitList() throws Exception {
        String[] unitList = inputLineContentParser.getUnitListFromUnitListInline("pish tegj glob glob");
        assertEquals(4, unitList.length);
        assertEquals("pish", unitList[0]);
        assertEquals("tegj", unitList[1]);
        assertEquals("glob", unitList[2]);
        assertEquals("glob", unitList[3]);
    }

    @Test
    public void shouldGetUnitInlineFromCreditState() throws Exception {
        assertEquals("glob glob", inputLineContentParser.getUnitListInlineFromCreditState("glob glob Silver is 34 Credits"));
    }

    @Test
    public void shouldGetGoodNameFromCreditState() throws Exception {
        assertEquals("Silver", inputLineContentParser.getGoodNameFromCreditState("glob glob Silver is 34 Credits"));
    }

    @Test
    public void shouldGetGoodTotalCredits() throws Exception {
        assertEquals(34, inputLineContentParser.getGoodTotalCreditsFromCreditState("glob glob Silver is 34 Credits"));
    }

    @Test
    public void shouldGetUnitListInlineFromCreditQuestion() throws Exception {
        assertEquals("glob prok", inputLineContentParser.getUnitListInlineFromCreditQuestion("how many Credits is glob prok Silver ?"));
    }

    @Test
    public void shouldGetGoodNameFromCreditQuestion() throws Exception {
        assertEquals("Silver", inputLineContentParser.getGoodNameFromCreditQuestion("how many Credits is glob prok Silver ?"));
    }
}