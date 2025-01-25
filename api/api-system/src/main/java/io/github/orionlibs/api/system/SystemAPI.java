package io.github.orionlibs.api.system;

import io.github.orionlibs.core.configuration.ConfigurationService;
import io.github.orionlibs.core.web.service.OrionWebService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/system")
public class SystemAPI extends OrionWebService
{
    @GetMapping(value = "/name")
    public ResponseEntity<String> getSystemName()
    {
        return ResponseEntity.ok("{\"name\":\"" + ConfigurationService.getProp("system.name") + "\"}");
    }


    @GetMapping(value = "/version")
    public ResponseEntity<String> getSystemVersion()
    {
        return ResponseEntity.ok("{\"version\":\"" + ConfigurationService.getProp("system.version") + "\"}");
    }
}
