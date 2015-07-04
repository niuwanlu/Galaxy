package com.galaxy;

import com.galaxy.calculator.UnitTotalCalculator;
import com.galaxy.constant.Constants;
import com.galaxy.constant.RomanNum;
import com.galaxy.processor.UnitStateProcessor;

/**
 * Created by wlniu on 04/07/15.
 */
public class GalaxyManager {

    private UnitStateProcessor unitStateProcessor;
    private UnitTotalCalculator unitTotalCalculator;
    private UnitMapper unitMapper;

    public GalaxyManager() {
        unitStateProcessor = new UnitStateProcessor();
        unitTotalCalculator = new UnitTotalCalculator();
        unitMapper = new UnitMapper();
    }

    public GalaxyManager(UnitStateProcessor unitStateProcessor, UnitTotalCalculator unitTotalCalculator, UnitMapper unitMapper) {
        this.unitStateProcessor = unitStateProcessor;
        this.unitTotalCalculator = unitTotalCalculator;
        this.unitMapper = unitMapper;
    }

    public void processInput(String input) {

        String type = InputLineTypeHelper.getInputType(input);

        if (type.equals(Constants.UNIT_STATE)) {
            String unitName = unitStateProcessor.getUnitName(input);
            RomanNum romanNum = unitStateProcessor.getRomanNumeral(input);
            unitMapper.putIntoUnitMap(unitName, romanNum);
        } else if (type.equals(Constants.UNIT_QUESTION)) {
            String[] unitList = unitTotalCalculator.getUnitList(input);
            int totalValue = unitMapper.getTotalValueOfUnitList(unitList);
        }

    }

}
