package com.galaxy;

import com.galaxy.constant.RomanNum;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UnitMapperTest {

    Map<String, RomanNum> unitMap;

    private UnitMapper unitMapper;

    @Before
    public void setUp() throws Exception {
        unitMap = spy(new HashMap<String, RomanNum>());
        unitMapper = spy(new UnitMapper(unitMap));
    }

    @Test
    public void shouldPutIntoMap() throws Exception {
        unitMapper.putIntoUnitMap("glob", RomanNum.I);
        unitMapper.putIntoUnitMap("pork", RomanNum.V);
        verify(unitMap).put("glob", RomanNum.I);
        assertEquals(RomanNum.I, unitMap.get("glob"));
        assertEquals(RomanNum.V, unitMap.get("pork"));
    }

    @Test
    public void shouldGetValueByKey() throws Exception {
        unitMapper.putIntoUnitMap("glob", RomanNum.I);
        unitMapper.putIntoUnitMap("pork", RomanNum.V);
        assertEquals(RomanNum.I, unitMapper.getValeByUnit("glob"));
        assertEquals(RomanNum.V, unitMapper.getValeByUnit("pork"));
    }

    @Test
    public void shouldCheckValueWhenGetTotalValue() throws Exception {
        String[] unitList = {"glob", "glob"};
        unitMapper.getTotalValueOfUnitList(unitList);
        verify(unitMapper, times(2)).getValeByUnit("glob");
    }

    @Test
    public void shouldReturnSumWhenUnitListContainsTwoRepeat() throws Exception {
        String[] unitList = {"glob", "glob"};
        unitMapper.putIntoUnitMap("glob", RomanNum.I);
        assertEquals(2, unitMapper.getTotalValueOfUnitList(unitList));
    }

    @Test
    public void shouldReturnDifferenceWhenFirstOneLessThanSecondOne() throws Exception {
        String[] unitList = {"glob", "pork"};
        unitMapper.putIntoUnitMap("glob", RomanNum.I);
        unitMapper.putIntoUnitMap("pork", RomanNum.V);
        assertEquals(RomanNum.I, unitMapper.getValeByUnit("glob"));
        assertEquals(RomanNum.V, unitMapper.getValeByUnit("pork"));
        assertEquals(4, unitMapper.getTotalValueOfUnitList(unitList));
    }
}