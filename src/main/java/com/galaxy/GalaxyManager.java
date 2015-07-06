package com.galaxy;

import com.galaxy.constant.Constants;
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

        if (type.equals(Constants.UNIT_STATE)) {
            String unitName = inputLineParser.getUnitName(input);
            RomanNum romanNum = inputLineParser.getRomanNumeral(input);
            unitMapper.putIntoUnitMap(unitName, romanNum);
            return null;
        } else if (type.equals(Constants.UNIT_QUESTION)) {
            String[] unitList = inputLineParser.getUnitList(input);
            int totalValue = unitMapper.getTotalValueOfUnitList(unitList);
            return inputLineParser.getListString(input) + " is " + String.valueOf(totalValue);
        } else if (type.equals(Constants.CREDIT_STATE)) {
            String unitListInline = inputLineParser.getUnitListInlineFromCreditState(input);
            String[] unitList = inputLineParser.getUnitList(unitListInline);
            int totalValueOfUnitList = unitMapper.getTotalValueOfUnitList(unitList);
            int totalCredits = inputLineParser.getGoodTotalCreditsFromCreditState(input);
            String goodName = inputLineParser.getGoodNameFromCreditState(input);
            double univalence = totalCredits/totalValueOfUnitList;
            goodMapper.putIntoMap(goodName, univalence);
            return null;
        } else if (type.equals(Constants.CREDIT_QUESTION)) {
            String unitListInline = inputLineParser.getUnitListInlineFromCreditQuestion(input);
            String[] unitList = inputLineParser.getUnitList(unitListInline);
            int totalValueOfUnitList = unitMapper.getTotalValueOfUnitList(unitList);
            String goodName = inputLineParser.getGoodNameFromCreditQuestion(input);
            Double univalence = goodMapper.getUnivalenceByName(goodName);
            return null;
        } else {
            return "I have no idea what you are talking about";
        }

    }

}
