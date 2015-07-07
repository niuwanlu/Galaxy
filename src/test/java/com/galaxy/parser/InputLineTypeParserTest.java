package com.galaxy.parser;

import org.junit.Before;
import org.junit.Test;

import static com.galaxy.constant.InputLineType.*;
import static org.junit.Assert.assertEquals;

public class InputLineTypeParserTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void shouldReturnCorrectType() throws Exception {
        assertEquals(UNIT_STATE, InputLineTypeParser.getInputType("glob is I"));
        assertEquals(CREDIT_STATE, InputLineTypeParser.getInputType("glob glob Silver is 34 Credits"));
        assertEquals(UNIT_QUESTION, InputLineTypeParser.getInputType("how much is pish tegj glob glob?"));
        assertEquals(CREDIT_QUESTION, InputLineTypeParser.getInputType("how many Credits is glob prok Silver?"));
        assertEquals(WHAT_ARE_YOU_TALKING, InputLineTypeParser.getInputType("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
    }
}