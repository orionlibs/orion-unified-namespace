package io.github.orionlibs.uns_app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(classes = SpringBootApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebsocketConnectionTest extends ATest
{
    @LocalServerPort
    private int port;


    @Test
    void testWebSocketConnectionWithSockJS()
    {
        //assertTrue(session.isConnected());
    }
}
