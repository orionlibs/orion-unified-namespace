package io.github.orionlibs.utilities.file_system.file.tasks;

import io.github.orionlibs.utilities.abstraction.Orion;
import io.github.orionlibs.utilities.exception.Assert;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class DeleteFileTask extends Orion
{
    public static void run(File filePathToDelete) throws IOException
    {
        Assert.notNull(filePathToDelete, "filePathToDelete input cannot be null.");

        try
        {
            FileUtils.forceDelete(filePathToDelete);
        }
        catch(Exception e)
        {
        }

    }


    public static void run(String filePathToDelete) throws IOException
    {
        Assert.notEmpty(filePathToDelete, "filePathToDelete input cannot be null/empty.");
        run(new File(filePathToDelete));
    }
}