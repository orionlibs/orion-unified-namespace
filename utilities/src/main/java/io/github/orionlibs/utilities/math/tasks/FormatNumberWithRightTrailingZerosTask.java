package io.github.orionlibs.utilities.math.tasks;

import io.github.orionlibs.utilities.abstraction.Orion;
import org.apache.commons.lang3.StringUtils;

public class FormatNumberWithRightTrailingZerosTask extends Orion
{
    public static String run(long number, int numberOfTrailingZeros)
    {
        String numberString = Long.toString(number);

        if(numberString.length() < numberOfTrailingZeros)
        {
            return StringUtils.rightPad(numberString, numberOfTrailingZeros, "0");
        }
        else
        {
            return numberString;
        }

    }
}