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
            String unitName = inputLineContentParser.getUnitNameFromUnitState(input);
            RomanNum romanNum = inputLineContentParser.getRomanNumeralFromUnitState(input);
            unitMapper.putIntoUnitMap(unitName, romanNum);
            return null;
        } else if (type.equals(InputLineType.UNIT_QUESTION)) {
            String unitListInline = inputLineContentParser.getUnitListInlineFromUnitQuestion(input);
            String[] unitList = inputLineContentParser.getUnitListFromUnitListInline(unitListInline);
            int totalValue = unitMapper.getTotalValueOfUnitList(unitList);
            return inputLineContentParser.getUnitListInlineFromUnitQuestion(input) + " is " + String.valueOf(totalValue);
        } else if (type.equals(InputLineType.CREDIT_STATE)) {
            String unitListInline = inputLineContentParser.getUnitListInlineFromCreditState(input);
            String[] unitList = inputLineContentParser.getUnitListFromUnitListInline(unitListInline);
            int totalValueOfUnitList = unitMapper.getTotalValueOfUnitList(unitList);
            int totalCredits = inputLineContentParser.getGoodTotalCreditsFromCreditState(input);
            String goodName = inputLineContentParser.getGoodNameFromCreditState(input);
            double univalence = (double)totalCredits/totalValueOfUnitList;
            goodMapper.putIntoGoodMap(goodName, univalence);
            return null;
        } else if (type.equals(InputLineType.CREDIT_QUESTION)) {
            String unitListInline = inputLineContentParser.getUnitListInlineFromCreditQuestion(input);
            String[] unitList = inputLineContentParser.getUnitListFromUnitListInline(unitListInline);
            int totalValueOfUnitList = unitMapper.getTotalValueOfUnitList(unitList);
            String goodName = inputLineContentParser.getGoodNameFromCreditQuestion(input);
            Double univalence = goodMapper.getUnivalenceByName(goodName);
            int calculatedTotalCredits = (int) (totalValueOfUnitList * univalence);
            return unitListInline + " " + goodName + " is " + String.valueOf(calculatedTotalCredits) + " Credits";
        } else {
            return "I have no idea what you are talking about";
        }

    }

}
