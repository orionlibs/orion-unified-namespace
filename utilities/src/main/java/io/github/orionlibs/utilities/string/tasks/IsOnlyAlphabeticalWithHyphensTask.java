package io.github.orionlibs.utilities.string.tasks;

import io.github.orionlibs.utilities.abstraction.Orion;
import io.github.orionlibs.utilities.exception.Assert;

public class IsOnlyAlphabeticalWithHyphensTask extends Orion
{
    public static boolean run(String s)
    {
        Assert.notNull(s, "The string input cannot be null.");

        if(!s.isEmpty())
        {
            int numberOfLetters = 0;
            int numberOfHyphens = 0;

            for(int i = 0; i < s.length(); i++)
            {

                if(Character.isLetter(s.charAt(i)))
                {
                    ++numberOfLetters;
                }
                else if('-' == s.charAt(i))
                {
                    ++numberOfHyphens;
                }

            }

            return numberOfLetters + numberOfHyphens == s.length();
        }
        else
        {
            return false;
        }

    }
}