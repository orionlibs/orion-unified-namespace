package io.github.orionlibs.core.file_system.tasks;

import io.github.orionlibs.core.exception.Assert;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class PrintFileSystemTask
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