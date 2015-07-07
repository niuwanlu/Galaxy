package com.galaxy;

import com.galaxy.constant.InputLineType;
import com.galaxy.constant.RomanNum;
import com.galaxy.mapper.GoodMapper;
import com.galaxy.mapper.UnitMapper;
import com.galaxy.parser.InputLineParser;
import com.galaxy.parser.InputLineTypeHelper;

/**
 * Created by wlniu on 04/07/15.
 */
public class GalaxyManager {

    private InputLineParser inputLineParser;
    private UnitMapper unitMapper;
    private GoodMapper goodMapper;

    public GalaxyManager() {
        this.inputLineParser = new InputLineParser();
        this.unitMapper = new UnitMapper();
        this.goodMapper = new GoodMapper();
    }

    public GalaxyManager(InputLineParser inputLineParser, UnitMapper unitMapper, GoodMapper goodMapper) {
        this.inputLineParser = inputLineParser;
        this.unitMapper = unitMapper;
        this.goodMapper = goodMapper;
    }

    public String processInput(String input) {

        String type = InputLineTypeHelper.getInputType(input);

        if (type.equals(InputLineType.UNIT_STATE)) {
            String unitName = inputLineParser.getUnitNameFromUnitState(input);
            RomanNum romanNum = inputLineParser.getRomanNumeralFromUnitState(input);
            unitMapper.putIntoUnitMap(unitName, romanNum);
            return null;
        } else if (type.equals(InputLineType.UNIT_QUESTION)) {
            String unitListInline = inputLineParser.getUnitListInlineFromUnitQuestion(input);
            String[] unitList = inputLineParser.getUnitListFromUnitListInline(unitListInline);
            int totalValue = unitMapper.getTotalValueOfUnitList(unitList);
            return inputLineParser.getUnitListInlineFromUnitQuestion(input) + " is " + String.valueOf(totalValue);
        } else if (type.equals(InputLineType.CREDIT_STATE)) {
            String unitListInline = inputLineParser.getUnitListInlineFromCreditState(input);
            String[] unitList = inputLineParser.getUnitListFromUnitListInline(unitListInline);
            int totalValueOfUnitList = unitMapper.getTotalValueOfUnitList(unitList);
            int totalCredits = inputLineParser.getGoodTotalCreditsFromCreditState(input);
            String goodName = inputLineParser.getGoodNameFromCreditState(input);
            double univalence = (double)totalCredits/totalValueOfUnitList;
            goodMapper.putIntoGoodMap(goodName, univalence);
            return null;
        } else if (type.equals(InputLineType.CREDIT_QUESTION)) {
            String unitListInline = inputLineParser.getUnitListInlineFromCreditQuestion(input);
            String[] unitList = inputLineParser.getUnitListFromUnitListInline(unitListInline);
            int totalValueOfUnitList = unitMapper.getTotalValueOfUnitList(unitList);
            String goodName = inputLineParser.getGoodNameFromCreditQuestion(input);
            Double univalence = goodMapper.getUnivalenceByName(goodName);
            int calculatedTotalCredits = (int) (totalValueOfUnitList * univalence);
            return unitListInline + " " + goodName + " is " + String.valueOf(calculatedTotalCredits) + " Credits";
        } else {
            return "I have no idea what you are talking about";
        }

    }

}
