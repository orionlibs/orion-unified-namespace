package io.github.orionlibs.utilities.math.tasks;

import io.github.orionlibs.utilities.abstraction.Orion;

public class FormatNumberWithLeftTrailingZerosTask extends Orion
{
    public static String run(long number, int numberOfTrailingZeros)
    {
        return String.format("%0" + numberOfTrailingZeros + "d", number);
    }
}