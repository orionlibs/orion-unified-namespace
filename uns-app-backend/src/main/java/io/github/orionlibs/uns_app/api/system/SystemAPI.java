package io.github.orionlibs.uns_app.api.system;

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
        return ResponseEntity.ok("{}");
    }
}
