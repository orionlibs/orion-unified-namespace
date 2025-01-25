package io.github.orionlibs.utilities;

import io.github.orionlibs.core.registry.ModuleRegistry;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UtilitiesSpringConfiguration
{
    public UtilitiesSpringConfiguration()
    {
        ModuleRegistry.registerModule("utilities", "0.0.1");
    }
}