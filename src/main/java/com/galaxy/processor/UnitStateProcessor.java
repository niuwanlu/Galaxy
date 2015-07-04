package com.galaxy.processor;

import com.galaxy.constant.RomanNum;

/**
 * Created by wlniu on 04/07/15.
 */
public class UnitStateProcessor {

    public void process(String input) {
        String unitName = getUnitName(input);
        RomanNum romanNum = getRomanNumeral(input);
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
