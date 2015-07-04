package com.galaxy;

import com.galaxy.constant.RomanNum;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class UnitMapperTest {

    Map<String, RomanNum> unitMap;

    private UnitMapper unitMapper;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        unitMap = spy(new HashMap<String, RomanNum>());
        unitMapper = spy(new UnitMapper(unitMap));
    }

    @Test
    public void shouldPutIntoMap() throws Exception {
        unitMapper.putIntoUnitMap("glob", RomanNum.I);
        verify(unitMap).put("glob", RomanNum.I);
        assertEquals(1, unitMap.size());
    }

    @Test
    public void shouldGetValueByKey() throws Exception {
        unitMapper.putIntoUnitMap("glob", RomanNum.I);
        assertEquals(RomanNum.I, unitMapper.getValeByUnit("glob"));
    }
}