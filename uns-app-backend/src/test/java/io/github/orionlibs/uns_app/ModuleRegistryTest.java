package io.github.orionlibs.uns_app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.orionlibs.core.registry.ModuleData;
import io.github.orionlibs.core.registry.ModuleRegistry;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(classes = SpringBootApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ModuleRegistryTest extends ATest
{
    @LocalServerPort
    private int port;


    @Test
    void testModuleRegistry()
    {
        List<ModuleData> modules = new ArrayList<>();
        modules.add(new ModuleData("core", "0.0.1"));
        modules.add(new ModuleData("utilities", "0.0.1"));
        modules.add(new ModuleData("api-system", "0.0.1"));
        for(ModuleData module : ModuleRegistry.getModules())
        {
            assertTrue(modules.contains(module));
        }
    }
}
