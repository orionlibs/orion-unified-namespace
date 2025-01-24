package io.github.orionlibs.orion_utilities.file_system.file.tasks;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.exception.Assert;
import java.io.File;
import java.io.IOException;

public class CreateFileTask extends Orion
{
    public static boolean run(File directory) throws IOException
    {
        Assert.notNull(directory, "directory input cannot be null.");
        return directory.createNewFile();
    }


    public static boolean run(String directory) throws IOException
    {
        Assert.notEmpty(directory, "directory input cannot be null/empty.");
        return run(new File(directory));
    }
}