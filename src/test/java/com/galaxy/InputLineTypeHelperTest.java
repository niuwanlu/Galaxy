package com.galaxy;

import com.galaxy.parser.InputLineTypeHelper;
import org.junit.Before;
import org.junit.Test;

import static com.galaxy.constant.Constants.*;
import static org.junit.Assert.assertEquals;

public class InputLineTypeHelperTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void shouldReturnCorrectType() throws Exception {
        assertEquals(UNIT_STATE, InputLineTypeHelper.getInputType("glob is I"));
        assertEquals(CREDIT_STATE, InputLineTypeHelper.getInputType("glob glob Silver is 34 Credits"));
        assertEquals(UNIT_QUESTION, InputLineTypeHelper.getInputType("how much is pish tegj glob glob?"));
        assertEquals(CREDIT_QUESTION, InputLineTypeHelper.getInputType("how many Credits is glob prok Silver?"));
        assertEquals(WHAT_ARE_YOU_TALKING, InputLineTypeHelper.getInputType("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
    }
}