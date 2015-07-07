package com.galaxy.mapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wlniu on 06/07/15.
 */
public class GoodMapper {

    Map<String, Double> goodMap;

    public GoodMapper() {
        this.goodMap = new HashMap<String, Double>();
    }

    public GoodMapper(Map<String, Double> goodMap) {
        this.goodMap = goodMap;
    }

    public void putIntoGoodMap(String goodName, double univalence) {
        goodMap.put(goodName, univalence);
    }

    public Double getUnivalenceByName(String goodName) {
        return goodMap.get(goodName);
    }
}
