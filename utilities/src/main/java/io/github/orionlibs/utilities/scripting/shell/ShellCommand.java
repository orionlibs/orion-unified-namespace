package io.github.orionlibs.utilities.scripting.shell;

import io.github.orionlibs.core.operating_system.OperatingSystemType;

public class ShellCommand
{
    private OperatingSystemType operatingSystemType;
    private String[] commandParameters;


    public ShellCommand(OperatingSystemType operatingSystemType, String[] commandParameters)
    {
        this.operatingSystemType = operatingSystemType;
        this.commandParameters = commandParameters;
    }


    public String[] getCommandParameters()
    {
        return this.commandParameters;
    }


    public OperatingSystemType getOperatingSystemType()
    {
        return this.operatingSystemType;
    }
}