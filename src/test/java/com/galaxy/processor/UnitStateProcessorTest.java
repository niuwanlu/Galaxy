package com.galaxy.processor;

import com.galaxy.constant.RomanNum;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Spy;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

public class UnitStateProcessorTest {

    @Spy
    UnitStateProcessor unitStateProcessor;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void shouldReturnUnitName() throws Exception {
        assertEquals("glob", unitStateProcessor.getUnitName("glob is I"));
    }

    @Test
    public void shouldGetRomanNumeral() throws Exception {
        assertEquals(RomanNum.I, unitStateProcessor.getRomanNumeral("glob is I"));
    }

}