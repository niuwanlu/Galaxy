package com.galaxy;

import static com.galaxy.Constants.*;

/**
 * Created by wlniu on 04/07/15.
 */
public class InputLineTypeManager {
    public static String getInputType(String inputLine) {
        if (inputLine.contains("how many")) {
            return CREDIT_QUESTION;
        }

        if (inputLine.contains("Credits")) {
            return CREDIT_STATE;
        }

        if (inputLine.contains("how much is")) {
            return PRICE_QUESTION;
        }

        if (inputLine.contains("is")) {
            return UNIT_STATE;
        }

        return WHAT_ARE_YOU_TALKING;
    }
}
