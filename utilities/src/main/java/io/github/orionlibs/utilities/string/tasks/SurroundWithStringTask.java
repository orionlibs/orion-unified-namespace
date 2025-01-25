package io.github.orionlibs.utilities.string.tasks;

import io.github.orionlibs.utilities.abstraction.Orion;

public class SurroundWithStringTask extends Orion
{
    public static String run(String aString, String stringToSurroundInputWith)
    {
        return run(aString, stringToSurroundInputWith, stringToSurroundInputWith);
    }


    public static String run(String aString, String stringPrefix, String stringSuffix)
    {
        StringBuilder stringSurroundedWithSingleQuote = new StringBuilder(stringPrefix);
        stringSurroundedWithSingleQuote.append(aString);
        stringSurroundedWithSingleQuote.append(stringSuffix);
        return stringSurroundedWithSingleQuote.toString();
    }
}