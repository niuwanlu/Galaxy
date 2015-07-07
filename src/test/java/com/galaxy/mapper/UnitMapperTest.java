package com.galaxy.mapper;

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
        unitMap = new HashMap<String, RomanNum>();
        unitMapper = spy(new UnitMapper(unitMap));
        unitMapper.putIntoUnitMap("glob", RomanNum.I);
        unitMapper.putIntoUnitMap("pork", RomanNum.V);
        unitMapper.putIntoUnitMap("pish", RomanNum.X);
        unitMapper.putIntoUnitMap("tegj", RomanNum.L);
    }

    @Test
    public void shouldPutIntoMap() throws Exception {
        unitMapper.putIntoUnitMap("glob", RomanNum.I);
        assertEquals(RomanNum.I, unitMap.get("glob"));
    }

    @Test
    public void shouldGetValueByKey() throws Exception {
        assertEquals(RomanNum.I, unitMapper.getValeByUnit("glob"));
        assertEquals(RomanNum.V, unitMapper.getValeByUnit("pork"));
    }

    @Test
    public void shouldCheckValueWhenGetTotalValue() throws Exception {
        String[] unitList = {"glob", "glob"};
        unitMapper.getTotalValueOfUnitList(unitList);
        verify(unitMapper, atLeast(2)).getValeByUnit("glob");
    }

    @Test
    public void shouldReturnSumWhenUnitListContainsTwoRepeat() throws Exception {
        String[] unitList = {"glob", "glob"};
        assertEquals(2, unitMapper.getTotalValueOfUnitList(unitList));
    }

    @Test
    public void shouldReturnDifferenceWhenFirstOneLessThanSecondOne() throws Exception {
        String[] unitList = {"glob", "pork"};
        assertEquals(4, unitMapper.getTotalValueOfUnitList(unitList));
    }

    @Test
    public void shouldReturnDifferenceAndSumWhenFirstOneLessThanSecondOneOfLength3() throws Exception {
        String[] unitList = {"pish", "tegj", "glob"};
        assertEquals(41, unitMapper.getTotalValueOfUnitList(unitList));
    }

    @Test
    public void shouldReturnDifferenceAndSumWhenFirstOneLessThanSecondOneOfLength4() throws Exception {
        String[] unitList = {"pish", "tegj", "glob", "glob"};
        assertEquals(42, unitMapper.getTotalValueOfUnitList(unitList));
    }

}