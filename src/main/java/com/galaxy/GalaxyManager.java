package com.galaxy;

import com.galaxy.constant.Constants;
import com.galaxy.constant.RomanNum;
import com.galaxy.processor.InputLineParser;

/**
 * Created by wlniu on 04/07/15.
 */
public class GalaxyManager {

    private InputLineParser inputLineParser;
    private UnitMapper unitMapper;

    public GalaxyManager() {
        inputLineParser = new InputLineParser();
        unitMapper = new UnitMapper();
    }

    public GalaxyManager(InputLineParser inputLineParser, UnitMapper unitMapper) {
        this.inputLineParser = inputLineParser;
        this.unitMapper = unitMapper;
    }

    public void processInput(String input) {

        String type = InputLineTypeHelper.getInputType(input);

        if (type.equals(Constants.UNIT_STATE)) {
            String unitName = inputLineParser.getUnitName(input);
            RomanNum romanNum = inputLineParser.getRomanNumeral(input);
            unitMapper.putIntoUnitMap(unitName, romanNum);
        } else if (type.equals(Constants.UNIT_QUESTION)) {
            String[] unitList = inputLineParser.getUnitList(input);
            int totalValue = unitMapper.getTotalValueOfUnitList(unitList);
        }

    }

}
