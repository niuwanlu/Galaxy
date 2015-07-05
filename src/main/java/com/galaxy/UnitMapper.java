package com.galaxy;

import com.galaxy.constant.RomanNum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wlniu on 04/07/15.
 */
public class UnitMapper {

    private Map<String,RomanNum> unitMap;

    public UnitMapper() {
        unitMap = new HashMap<String, RomanNum>();
    }

    public UnitMapper(Map<String, RomanNum> unitMap) {
        this.unitMap = unitMap;
    }

    public void putIntoUnitMap(String unitName, RomanNum romanNum) {
        unitMap.put(unitName, romanNum);
    }

    public RomanNum getValeByUnit(String unit) {
        return unitMap.get(unit);
    }

    public int getTotalValueOfUnitList(String[] unitList) {
        int totalValue = 0;
        int currValue = 0;
        int nextValue = 0;
        for (int i = 0; i < unitList.length - 1; i++) {
            currValue = getValeByUnit(unitList[i]).getValue();
            nextValue = getValeByUnit(unitList[i+1]).getValue();
            if (currValue < nextValue) {
                totalValue -= currValue;
            } else {
                totalValue += currValue;
            }
            totalValue += nextValue;
        }
        return totalValue;
    }
}
