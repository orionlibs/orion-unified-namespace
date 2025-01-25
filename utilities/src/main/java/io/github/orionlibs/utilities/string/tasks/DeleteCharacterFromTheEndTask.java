package io.github.orionlibs.utilities.string.tasks;

import io.github.orionlibs.utilities.abstraction.Orion;
import io.github.orionlibs.utilities.exception.Assert;

public class DeleteCharacterFromTheEndTask extends Orion
{
    public static String run(String aString, String characterToDelete)
    {
        Assert.notEmpty(aString, "The aString input cannot be null/empty.");

        if(aString.endsWith(characterToDelete))
        {
            return aString.substring(0, aString.length() - characterToDelete.length());
        }

        return aString;
    }
}