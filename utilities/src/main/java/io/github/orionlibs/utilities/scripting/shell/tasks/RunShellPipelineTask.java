package io.github.orionlibs.utilities.scripting.shell.tasks;

import io.github.orionlibs.core.exception.Assert;
import io.github.orionlibs.core.utility.OrionUtils;
import io.github.orionlibs.utilities.scripting.shell.ShellCommandResult;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class RunShellPipelineTask
{
    public static ShellCommandResult run(List<ProcessBuilder> processBuilders) throws InterruptedException
    {
        Assert.notEmpty(processBuilders, "The processBuilders input cannot be null/empty.");
        InputStream finalInputStream = null;
        Reader inputStreamReader = null;
        BufferedReader reader = null;
        ShellCommandResult result = null;
        try
        {
            List<Process> processes = ProcessBuilder.startPipeline(processBuilders);
            Process last = processes.get(processes.size() - 1);
            finalInputStream = last.getInputStream();
            inputStreamReader = new InputStreamReader(finalInputStream);
            reader = new BufferedReader(inputStreamReader);
            String line = null;
            StringBuilder sb = new StringBuilder();
            while((line = reader.readLine()) != null)
            {
                sb.append(line);
                sb.append(System.getProperty("line.separator"));
            }
            result = new ShellCommandResult(sb.toString());
        }
        catch(IOException e)
        {
            result = new ShellCommandResult(true, e.getMessage());
        }
        finally
        {
            OrionUtils.closeResource(finalInputStream);
            OrionUtils.closeResource(inputStreamReader);
            OrionUtils.closeResource(reader);
        }
        return result;
    }
}