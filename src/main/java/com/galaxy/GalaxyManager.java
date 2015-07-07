package com.galaxy;

import com.galaxy.constant.InputLineType;
import com.galaxy.constant.RomanNum;
import com.galaxy.mapper.GoodMapper;
import com.galaxy.mapper.UnitMapper;
import com.galaxy.parser.InputLineContentParser;
import com.galaxy.parser.InputLineTypeParser;

/**
 * Created by wlniu on 04/07/15.
 */
public class GalaxyManager {

    private InputLineContentParser inputLineContentParser;
    private UnitMapper unitMapper;
    private GoodMapper goodMapper;

    public GalaxyManager() {
        this.inputLineContentParser = new InputLineContentParser();
        this.unitMapper = new UnitMapper();
        this.goodMapper = new GoodMapper();
    }

    public GalaxyManager(InputLineContentParser inputLineContentParser, UnitMapper unitMapper, GoodMapper goodMapper) {
        this.inputLineContentParser = inputLineContentParser;
        this.unitMapper = unitMapper;
        this.goodMapper = goodMapper;
    }

    public String processInput(String input) {

        String type = InputLineTypeParser.getInputType(input);

        if (type.equals(InputLineType.UNIT_STATE)) {
            return processUnitState(input);
        } else if (type.equals(InputLineType.UNIT_QUESTION)) {
            return processUnitQuestion(input);
        } else if (type.equals(InputLineType.CREDIT_STATE)) {
            return processCreditState(input);
        } else if (type.equals(InputLineType.CREDIT_QUESTION)) {
            return processCreditQuestion(input);
        } else {
            return InputLineType.WHAT_ARE_YOU_TALKING;
        }

    }

    private String processUnitState(String input) {
        String unitName = inputLineContentParser.getUnitNameFromUnitState(input);
        RomanNum romanNum = inputLineContentParser.getRomanNumeralFromUnitState(input);
        unitMapper.putIntoUnitMap(unitName, romanNum);
        return "";
    }

    private String processUnitQuestion(String input) {
        String unitListInline = inputLineContentParser.getUnitListInlineFromUnitQuestion(input);
        int totalValue = getTotalValueOfUnitList(unitListInline);
        return unitListInline + " is " + String.valueOf(totalValue);
    }

    private String processCreditState(String input) {
        String unitListInline = inputLineContentParser.getUnitListInlineFromCreditState(input);
        double univalence = getGoodUnivalence(input, unitListInline);
        String goodName = inputLineContentParser.getGoodNameFromCreditState(input);
        goodMapper.putIntoGoodMap(goodName, univalence);
        return "";
    }

    private String processCreditQuestion(String input) {
        String unitListInline = inputLineContentParser.getUnitListInlineFromCreditQuestion(input);
        String goodName = inputLineContentParser.getGoodNameFromCreditQuestion(input);
        int calculatedTotalCredits = getCalculatedTotalCredits(unitListInline, goodName);
        return unitListInline + " " + goodName + " is " + String.valueOf(calculatedTotalCredits) + " Credits";
    }

    private int getTotalValueOfUnitList(String unitListInline) {
        String[] unitList = inputLineContentParser.getUnitListFromUnitListInline(unitListInline);
        return unitMapper.getTotalValueOfUnitList(unitList);
    }

    private double getGoodUnivalence(String input, String unitListInline) {
        int totalValueOfUnitList = getTotalValueOfUnitList(unitListInline);
        int totalCredits = inputLineContentParser.getGoodTotalCreditsFromCreditState(input);
        return (double)totalCredits/totalValueOfUnitList;
    }

    private int getCalculatedTotalCredits(String unitListInline, String goodName) {
        int totalValueOfUnitList = getTotalValueOfUnitList(unitListInline);
        Double univalence = goodMapper.getUnivalenceByName(goodName);
        return (int) (totalValueOfUnitList * univalence);
    }

}
