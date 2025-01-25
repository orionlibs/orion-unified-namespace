package io.github.orionlibs.utilities.string.tasks;

import io.github.orionlibs.utilities.abstraction.Orion;
import io.github.orionlibs.utilities.string.StringsService;

public class FormatWith2CharactersTask extends Orion
{
    public static String run(long value)
    {
        String valueString = Long.toString(value);

        if(value < 10)
        {
            return StringsService.prefixString(valueString, "0");
        }
        else
        {
            return valueString;
        }

    }


    public static String run(int value)
    {
        return run((long)value);
    }
}