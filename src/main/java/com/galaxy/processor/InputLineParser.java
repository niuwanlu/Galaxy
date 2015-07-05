package com.galaxy.processor;

import com.galaxy.constant.RomanNum;

/**
 * Created by wlniu on 04/07/15.
 */
public class InputLineParser {

    public String getUnitName(String input) {
        String[] words = input.split(" ", 2);
        return words[0];
    }

    public RomanNum getRomanNumeral(String input) {
        String[] words = input.split(" is ", 2);
        return RomanNum.valueOf(words[1]);
    }

    public String[] getUnitList(String input) {
        String listStrWithQuestionMark = input.split(" is ")[1];
        String listStr = listStrWithQuestionMark.substring(0, listStrWithQuestionMark.length()-1);
        return listStr.split(" ");
    }

}