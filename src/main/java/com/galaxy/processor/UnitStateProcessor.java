package com.galaxy.processor;

import com.galaxy.UnitMapper;
import com.galaxy.constant.RomanNum;

/**
 * Created by wlniu on 04/07/15.
 */
public class UnitStateProcessor {

    private UnitMapper unitMapper;

    public UnitStateProcessor() {
        unitMapper = new UnitMapper();
    }

    public UnitStateProcessor(UnitMapper unitMapper) {
        this.unitMapper = unitMapper;
    }

    public void process(String input) {
        String unitName = getUnitName(input);
        RomanNum romanNum = getRomanNumeral(input);
        unitMapper.putIntoUnitMap(unitName, romanNum);
    }

    protected String getUnitName(String input) {
        String[] words = input.split(" ", 2);
        return words[0];
    }

    public RomanNum getRomanNumeral(String input) {
        String[] words = input.split(" is ", 2);
        return RomanNum.valueOf(words[1]);
    }
}
