package com.galaxy.calculator;

/**
 * Created by wlniu on 04/07/15.
 */
public class UnitTotalCalculator {

    public String[] getUnitList(String input) {
        String listStrWithQuestionMark = input.split(" is ")[1];
        String listStr = listStrWithQuestionMark.substring(0, listStrWithQuestionMark.length()-1);
        return listStr.split(" ");
    }
}
