package io.github.orionlibs.core.registry;

public class ModuleData
{
    private String name;
    private String version;


    public ModuleData(String name, String version)
    {
        this.name = name;
        this.version = version;
    }


    public String getVersion()
    {
        return version;
    }


    public String getName()
    {
        return name;
    }
}
