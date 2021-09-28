package io.gonzo.middleware.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/api/check")
public class CheckResource {

    @GetMapping("/state")
    public Instant checkByState() {
        return Instant.now();
    }

}
