package io.github.orionlibs.orion_utilities.string.tasks;

import io.github.orionlibs.orion_utilities.abstraction.Orion;

public class ConvertFirstCharacterToUppercaseTask extends Orion
{
    public static String run(String aString)
    {

        if(aString != null && !aString.isEmpty())
        {
            char[] stringCharactersArray = aString.trim().toCharArray();
            stringCharactersArray[0] = Character.toUpperCase(stringCharactersArray[0]);
            return String.copyValueOf(stringCharactersArray);
        }
        else
        {
            return "";
        }

    }
}