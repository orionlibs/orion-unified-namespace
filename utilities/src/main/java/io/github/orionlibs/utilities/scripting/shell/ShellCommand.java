package io.github.orionlibs.utilities.scripting.shell;

import io.github.orionlibs.utilities.abstraction.Orion;
import io.github.orionlibs.utilities.operating_system.OperatingSystemType;

public class ShellCommand extends Orion
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