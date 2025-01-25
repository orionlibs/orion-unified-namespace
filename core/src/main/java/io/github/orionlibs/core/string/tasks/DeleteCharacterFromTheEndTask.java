package io.github.orionlibs.core.string.tasks;

import io.github.orionlibs.core.exception.Assert;

public class DeleteCharacterFromTheEndTask
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