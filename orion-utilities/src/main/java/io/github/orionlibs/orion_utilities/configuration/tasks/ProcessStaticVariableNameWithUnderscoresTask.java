package io.github.orionlibs.orion_utilities.configuration.tasks;

import io.github.orionlibs.orion_utilities.abstraction.Orion;

public class ProcessStaticVariableNameWithUnderscoresTask extends Orion
{
    public static void run(String variableName, StringBuilder key)
    {
        String[] tokens = variableName.split("_");

        for(int i = 0; i < tokens.length; i++)
        {
            key.append(tokens[i].toLowerCase());

            if(i < tokens.length - 1)
            {
                key.append(".");
            }

        }

    }
}