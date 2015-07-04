package com.galaxy.processor;

import com.galaxy.UnitMapper;
import com.galaxy.constant.RomanNum;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class UnitStateProcessorTest {

    @Mock
    UnitMapper unitMapper;

    private UnitStateProcessor unitStateProcessor;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        unitStateProcessor = spy(new UnitStateProcessor(unitMapper));
    }

    @Test
    public void shouldInvokeGetUnitNameWhenProcess() throws Exception {
        unitStateProcessor.process("glob is I");
        verify(unitStateProcessor).getUnitName("glob is I");
    }

    @Test
    public void shouldReturnUnitName() throws Exception {
        assertEquals("glob", unitStateProcessor.getUnitName("glob is I"));
    }

    @Test
    public void shouldInvokeGetRomanNumWhenProcess() throws Exception {
        unitStateProcessor.process("glob is I");
        verify(unitStateProcessor).getRomanNumeral("glob is I");
    }

    @Test
    public void shouldGetRomanNumeral() throws Exception {
        assertEquals(RomanNum.I, unitStateProcessor.getRomanNumeral("glob is I"));
    }

    @Test
    public void shouldInvokePutIntoUnitMapWhenProcess() throws Exception {
        unitStateProcessor.process("glob is I");
        verify(unitMapper).putIntoUnitMap("glob", RomanNum.I);
    }

}