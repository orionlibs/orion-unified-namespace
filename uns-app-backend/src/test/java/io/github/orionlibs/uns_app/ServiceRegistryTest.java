package io.github.orionlibs.uns_app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.orionlibs.core.configuration.Config;
import io.github.orionlibs.core.configuration.ConfigurationDAO;
import io.github.orionlibs.core.registry.ServiceRegistry;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(classes = SpringBootApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServiceRegistryTest extends ATest
{
    @LocalServerPort
    private int port;


    @Test
    void testServiceRegistry()
    {
        ServiceRegistry.registerService(ConfigurationDAO.class, new MyConfigDAO());
        assertEquals("OrionUNS", Config.getProp("system.name"));
        assertEquals("test name", Config.getProp("system.wrong.name"));
    }
}
