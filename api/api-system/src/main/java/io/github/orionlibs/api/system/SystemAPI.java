package io.github.orionlibs.api.system;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/system")
public class SystemAPI
{
    @GetMapping(value = "/version")
    public ResponseEntity<String> getSystemVersion()
    {
        return ResponseEntity.ok("{\"version\":\"0.0.1\"}");
    }
}