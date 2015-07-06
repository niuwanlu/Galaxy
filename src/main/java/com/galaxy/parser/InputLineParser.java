package com.galaxy.parser;

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
        String listStr = getListString(input);
        return listStr.split(" ");
    }

    public String getListString(String input) {
        String listStrWithQuestionMark = input.split(" is ")[1];
        return listStrWithQuestionMark.substring(0, listStrWithQuestionMark.length()-1);
    }

    public String getUnitListInlineFromCreditState(String input) {
        String stringBeforeIs = getStringBeforeIs(input);
        String unitListInline = stringBeforeIs.substring(0, stringBeforeIs.lastIndexOf(" "));
        return unitListInline;
    }

    public String getGoodNameFromCreditState(String input) {
        String stringBeforeIs = getStringBeforeIs(input);
        String goodName = stringBeforeIs.substring(stringBeforeIs.lastIndexOf(" ") + 1);
        return goodName;
    }

    private String getStringBeforeIs(String str) {
        return str.split(" is ")[0];
    }

    public int getGoodTotalCreditsFromCreditState(String input) {
        String[] words = input.split(" ");
        return Integer.parseInt(words[words.length-2]);
    }

}
