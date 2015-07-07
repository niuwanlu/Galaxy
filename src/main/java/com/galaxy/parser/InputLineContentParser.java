package com.galaxy.parser;

import com.galaxy.constant.RomanNum;

/**
 * Created by wlniu on 04/07/15.
 */
public class InputLineContentParser {

    public String getUnitNameFromUnitState(String input) {
        String[] words = input.split(" ", 2);
        return words[0];
    }

    public RomanNum getRomanNumeralFromUnitState(String input) {
        String[] words = input.split(" is ", 2);
        return RomanNum.valueOf(words[1]);
    }

    public String[] getUnitListFromUnitListInline(String input) {
        return input.split(" ");
    }

    public String getUnitListInlineFromUnitQuestion(String input) {
        String listStrWithQuestionMark = input.split(" is ")[1];
        return listStrWithQuestionMark.substring(0, listStrWithQuestionMark.length()-1);
    }

    public String getUnitListInlineFromCreditState(String input) {
        String stringBeforeIs = getStringBeforeIs(input);
        return stringBeforeIs.substring(0, stringBeforeIs.lastIndexOf(" "));
    }

    public String getGoodNameFromCreditState(String input) {
        String stringBeforeIs = getStringBeforeIs(input);
        return stringBeforeIs.substring(stringBeforeIs.lastIndexOf(" ") + 1);
    }

    public int getGoodTotalCreditsFromCreditState(String input) {
        String[] words = input.split(" ");
        return Integer.parseInt(words[words.length-2]);
    }

    public String getUnitListInlineFromCreditQuestion(String input) {
        String stringAfterIsWithoutMark = getStringAfterIsWithoutMark(input);
        return stringAfterIsWithoutMark.substring(0, stringAfterIsWithoutMark.lastIndexOf(" "));
    }

    private String getStringAfterIsWithoutMark(String input) {
        String stringAfterIs = getStringAfterIs(input);
        return stringAfterIs.substring(0, stringAfterIs.lastIndexOf(" "));
    }

    public String getGoodNameFromCreditQuestion(String input) {
        String stringAfterIsWithoutMark = getStringAfterIsWithoutMark(input);
        return stringAfterIsWithoutMark.substring(stringAfterIsWithoutMark.lastIndexOf(" ") + 1);
    }

    private String getStringBeforeIs(String str) {
        return str.split(" is ")[0];
    }

    private String getStringAfterIs(String str) {
        return str.split(" is ")[1];
    }
}
