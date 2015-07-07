package com.galaxy.constant;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanNumTest {

    @Test
    public void shouldReturnValue() throws Exception {
        RomanNum romanNum = RomanNum.I;
        assertEquals(1, romanNum.getValue());
    }
}