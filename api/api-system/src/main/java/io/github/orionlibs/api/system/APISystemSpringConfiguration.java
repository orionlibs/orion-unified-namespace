package io.github.orionlibs.api.system;

import io.github.orionlibs.core.registry.ModuleRegistry;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APISystemSpringConfiguration
{
    public APISystemSpringConfiguration()
    {
        ModuleRegistry.registerModule("api-system", "0.0.1");
    }
}