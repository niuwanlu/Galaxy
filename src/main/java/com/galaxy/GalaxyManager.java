package com.galaxy;

import com.galaxy.calculator.UnitTotalCalculator;
import com.galaxy.constant.Constants;
import com.galaxy.processor.UnitStateProcessor;

/**
 * Created by wlniu on 04/07/15.
 */
public class GalaxyManager {

    private UnitStateProcessor unitStateProcessor;
    private UnitTotalCalculator unitTotalCalculator;

    public GalaxyManager() {
        unitStateProcessor = new UnitStateProcessor();
        unitTotalCalculator = new UnitTotalCalculator();
    }

    public GalaxyManager(UnitStateProcessor unitStateProcessor, UnitTotalCalculator unitTotalCalculator) {
        this.unitStateProcessor = unitStateProcessor;
        this.unitTotalCalculator = unitTotalCalculator;
    }

    public void processInput(String input) {

        String type = InputLineTypeHelper.getInputType(input);

        if (type.equals(Constants.UNIT_STATE)) {
            unitStateProcessor.process(input);
        } else if (type.equals(Constants.UNIT_QUESTION)) {
            unitTotalCalculator.process(input);
        }

    }

}
