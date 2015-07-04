package com.galaxy;

import org.junit.Before;
import org.junit.Test;

import static com.galaxy.Constants.*;
import static org.junit.Assert.assertEquals;

public class InputLineTypeManagerTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void shouldReturnCorrectType() throws Exception {
        assertEquals(UNIT_STATE, InputLineTypeManager.getInputType("glob is I"));
        assertEquals(CREDIT_STATE, InputLineTypeManager.getInputType("glob glob Silver is 34 Credits"));
        assertEquals(PRICE_QUESTION, InputLineTypeManager.getInputType("how much is pish tegj glob glob?"));
        assertEquals(CREDIT_QUESTION, InputLineTypeManager.getInputType("how many Credits is glob prok Silver?"));
        assertEquals(WHAT_ARE_YOU_TALKING, InputLineTypeManager.getInputType("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
    }
}