package io.github.orionlibs.orion_utilities.cryptology.encoding.ascii.tasks;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.exception.Assert;

public class DecodeASCIITask extends Orion
{
    public static String run(String data)
    {
        Assert.notEmpty(data, "The given data is null/empty.");
        String original = "";
        String[] dataWithoutUnderscores = null;

        if(data.indexOf("_") == -1)
        {
            dataWithoutUnderscores = new String[1];
            dataWithoutUnderscores[0] = data;
        }
        else
        {
            dataWithoutUnderscores = data.split("_");
        }

        for(int i = 0; i < dataWithoutUnderscores.length; i++)
        {

            if(Character.isWhitespace(dataWithoutUnderscores[i].charAt(0)))
            {
                original += " ";
            }
            else
            {
                original += (char)Integer.parseInt(dataWithoutUnderscores[i]);
            }

        }

        return original;
    }
}