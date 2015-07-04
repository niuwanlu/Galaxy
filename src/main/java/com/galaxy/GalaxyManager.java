package com.galaxy;

import com.galaxy.constant.Constants;
import com.galaxy.processor.UnitStateProcessor;

/**
 * Created by wlniu on 04/07/15.
 */
public class GalaxyManager {

    private UnitStateProcessor unitStateProcessor = new UnitStateProcessor();

    public GalaxyManager() {
        unitStateProcessor = new UnitStateProcessor();
    }

    public GalaxyManager(UnitStateProcessor unitStateProcessor) {
        this.unitStateProcessor = unitStateProcessor;
    }

    public void processInput(String input) {

        String type = InputLineTypeHelper.getInputType(input);

        if (type.equals(Constants.UNIT_STATE)) {
            unitStateProcessor.process(input);
        }

    }

}
