package io.gonzo.middleware.web;

import io.gonzo.middleware.domain.AreaCode;
import io.gonzo.middleware.service.AreaCodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/area-code")
public class AreaCodeResource {

    private final AreaCodeService service;

    @GetMapping("")
    public List<AreaCode> showByAreaCodes() {
        return service.getByAreaCodes();
    }

}
