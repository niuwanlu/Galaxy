package com.galaxy.mapper;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;

public class GoodMapperTest {

    private Map<String, Double> goodMap;

    private GoodMapper goodMapper;

    @Before
    public void setUp() throws Exception {
        goodMap = new HashMap<String, Double>();
        goodMapper = spy(new GoodMapper(goodMap));
    }

    @Test
    public void shouldPutIntoMap() throws Exception {
        goodMapper.putIntoMap("Silver", 17);
        assertEquals(new Double(17), goodMap.get("Silver"));

    }

    @Test
    public void shouldGetUnivalenceByName() throws Exception {
        goodMapper.putIntoMap("Silver", 17);
        assertEquals(new Double(17), goodMapper.getUnivalenceByName("Silver"));
    }
}