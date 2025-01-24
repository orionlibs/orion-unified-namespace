package io.github.orionlibs.orion_utilities.math.tasks;

import io.github.orionlibs.orion_utilities.abstraction.Orion;

public class FormatNumberWithLeftTrailingZerosTask extends Orion
{
    public static String run(long number, int numberOfTrailingZeros)
    {
        return String.format("%0" + numberOfTrailingZeros + "d", number);
    }
}