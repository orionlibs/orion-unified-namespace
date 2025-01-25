package io.github.orionlibs.core.math.tasks;

public class FormatNumberWithLeftTrailingZerosTask
{
    public static String run(long number, int numberOfTrailingZeros)
    {
        return String.format("%0" + numberOfTrailingZeros + "d", number);
    }
}