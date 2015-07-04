package com.galaxy;

import com.galaxy.constant.RomanNum;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Map;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class UnitMapperTest {

    @Mock
    Map<String, RomanNum> unitMap;

    private UnitMapper unitMapper;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        unitMapper = spy(new UnitMapper(unitMap));
    }

    @Test
    public void shouldPutIntoMap() throws Exception {
        unitMapper.putIntoUnitMap("glob", RomanNum.I);
        verify(unitMap).put("glob", RomanNum.I);
    }
}