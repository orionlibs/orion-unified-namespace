package io.github.orionlibs.utilities.string.tasks;

import io.github.orionlibs.utilities.abstraction.Orion;
import io.github.orionlibs.utilities.exception.Assert;

public class CopyStringTask extends Orion
{
    public static String run(String stringToCopy)
    {
        return new String(stringToCopy);
    }


    public static String run(String stringToCopyFrom, int indexToCopyFrom)
    {
        Assert.notEmpty(stringToCopyFrom, "The stringToCopyFrom input cannot be null/empty.");

        if(indexToCopyFrom < stringToCopyFrom.length())
        {
            return new String(stringToCopyFrom.substring(indexToCopyFrom));
        }
        else
        {
            return "";
        }

    }


    public static String run(String stringToCopyFrom, int indexToCopyFrom, int indexToCopyTo)
    {
        Assert.notEmpty(stringToCopyFrom, "The stringToCopyFrom input cannot be null/empty.");

        if(indexToCopyFrom < stringToCopyFrom.length() && (indexToCopyTo + 1) < stringToCopyFrom.length())
        {
            return new String(stringToCopyFrom.substring(indexToCopyFrom, indexToCopyTo + 1));
        }
        else
        {
            return "";
        }

    }
}