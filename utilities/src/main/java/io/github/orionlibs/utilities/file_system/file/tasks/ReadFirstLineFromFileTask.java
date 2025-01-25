package io.github.orionlibs.utilities.file_system.file.tasks;

import io.github.orionlibs.utilities.abstraction.Orion;
import io.github.orionlibs.utilities.exception.Assert;
import io.github.orionlibs.utilities.utility.OrionUtils;
import java.io.BufferedReader;
import java.io.IOException;

public class ReadFirstLineFromFileTask extends Orion
{
    public static String run(BufferedReader input) throws IOException
    {
        Assert.notNull(input, "BufferedReader input cannot be null.");

        try
        {
            return input.readLine();
        }
        finally
        {
            OrionUtils.closeResource(input);
        }

    }
}