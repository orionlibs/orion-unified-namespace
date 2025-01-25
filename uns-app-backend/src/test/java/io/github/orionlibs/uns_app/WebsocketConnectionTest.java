package io.github.orionlibs.uns_app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.orionlibs.core.configuration.ConfigurationDAO;
import io.github.orionlibs.core.configuration.ConfigurationService;
import io.github.orionlibs.core.registry.ModuleRegistry;
import io.github.orionlibs.core.registry.ServiceRegistry;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(classes = SpringBootApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebsocketConnectionTest extends ATest
{
    @LocalServerPort
    private int port;


    @Test
    void testServiceRegistry()
    {
        ServiceRegistry.registerService(ConfigurationDAO.class, new MyConfigDAO());
        assertEquals("OrionUNS", ConfigurationService.getProp("system.name"));
        assertEquals("test name", ConfigurationService.getProp("system.wrong.name"));
        ModuleRegistry.getModules().forEach(m -> System.out.println(m.getName() + "--" + m.getVersion()));
    }


    @Test
    void testModuleRegistry()
    {
        ModuleRegistry.getModules().forEach(m -> System.out.println(m.getName() + "--" + m.getVersion()));
    }
}
