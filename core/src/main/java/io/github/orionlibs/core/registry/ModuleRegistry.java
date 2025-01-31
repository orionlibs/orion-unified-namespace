package io.github.orionlibs.core.registry;

import io.github.orionlibs.core.abstraction.OrionRegistry;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ModuleRegistry implements OrionRegistry
{
    private static final CopyOnWriteArrayList<ModuleData> modules;

    static
    {
        modules = new CopyOnWriteArrayList<>();
        register("core", "0.0.1");
    }

    public static void register(ModuleData moduleData)
    {
        modules.add(moduleData);
    }


    public static void register(String name, String version)
    {
        modules.add(new ModuleData(name, version));
    }


    public static List<ModuleData> getModules()
    {
        return Collections.unmodifiableList(modules);
    }
}
