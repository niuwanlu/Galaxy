package com.galaxy.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnitTotalCalculatorTest {

    private UnitTotalCalculator unitTotalCalculator;

    @Before
    public void setUp() throws Exception {
        unitTotalCalculator = new UnitTotalCalculator();
    }

    @Test
    public void shouldGetUnitList() throws Exception {
        String[] unitList = unitTotalCalculator.getUnitList("how much is pish tegj glob glob ?");
        assertEquals(4, unitList.length);
        assertEquals("pish", unitList[0]);
        assertEquals("tegj", unitList[1]);
        assertEquals("glob", unitList[2]);
        assertEquals("glob", unitList[3]);
    }
}