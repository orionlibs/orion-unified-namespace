package io.github.orionlibs.orion_utilities.string.tasks;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.string.StringsService;

public class IsLastCharacterAWhitespaceTask extends Orion
{
    public static boolean run(String aString)
    {
        boolean isLastCharacterAWhitespace = false;
        String lastCharacter = StringsService.getLastCharacterAsString(aString);

        if(StringsService.isWhitespace(lastCharacter))
        {
            isLastCharacterAWhitespace = true;
        }

        return isLastCharacterAWhitespace;
    }
}