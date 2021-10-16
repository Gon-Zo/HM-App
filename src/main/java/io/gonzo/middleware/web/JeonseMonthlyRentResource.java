package io.gonzo.middleware.web;

import io.gonzo.middleware.service.JeonseMonthlyRentService;
import io.gonzo.middleware.web.dto.JeonseMonthlyRentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jeonse-monthly-rent")
public class JeonseMonthlyRentResource {

    private final JeonseMonthlyRentService service;

    @GetMapping("")
    public List<JeonseMonthlyRentDTO.Default> showByJeonseMonthly(JeonseMonthlyRentDTO.Store dto) {
        return service.getByJenoseMounthlyRent(dto);
    }

}
