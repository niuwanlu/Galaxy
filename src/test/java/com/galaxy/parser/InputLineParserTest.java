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
        assertEquals("glob", inputLineParser.getUnitName("glob is I"));
    }

    @Test
    public void shouldGetRomanNumeral() throws Exception {
        assertEquals(RomanNum.I, inputLineParser.getRomanNumeral("glob is I"));
    }

    @Test
    public void shouldGetUnitList() throws Exception {
        String[] unitList = inputLineParser.getUnitList("how much is pish tegj glob glob ?");
        assertEquals(4, unitList.length);
        assertEquals("pish", unitList[0]);
        assertEquals("tegj", unitList[1]);
        assertEquals("glob", unitList[2]);
        assertEquals("glob", unitList[3]);
    }

}