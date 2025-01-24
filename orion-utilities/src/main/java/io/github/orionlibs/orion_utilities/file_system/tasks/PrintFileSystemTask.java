package io.github.orionlibs.orion_utilities.file_system.tasks;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.exception.Assert;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class PrintFileSystemTask extends Orion
{
    public static BufferedWriter run(String directoryPathToTraverse, String filePathToSaveIn) throws FileNotFoundException, IOException
    {
        Assert.notEmpty(directoryPathToTraverse, "directoryPathToTraverse input cannot be null/empty.");
        Assert.notEmpty(filePathToSaveIn, "filePathToSaveIn input cannot be null/empty.");
        BufferedWriter output = new BufferedWriter(new FileWriter(filePathToSaveIn));
        File file = new File(directoryPathToTraverse);
        PrintFilesAndDirectoriesTask.run(file, output);
        return output;
    }
}