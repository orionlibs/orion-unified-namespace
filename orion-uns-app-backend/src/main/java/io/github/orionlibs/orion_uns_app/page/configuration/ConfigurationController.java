package io.github.orionlibs.orion_uns_app.page.configuration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/wapi/v1/configurations")
public class ConfigurationController
{
    @GetMapping(value = "/simulators")
    public ResponseEntity<String> testURL1()
    {
        return ResponseEntity.ok("{}");
    }
}