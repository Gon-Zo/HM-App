package io.gonzo.middleware.web;

import io.gonzo.middleware.service.RowHouseRentService;
import io.gonzo.middleware.web.dto.RowHouseRentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/row-house-rent")
public class RowHouseRentResource {

    private final RowHouseRentService service;

    @GetMapping("")
    public List<RowHouseRentDTO.Default> showByRowHouseRent() {
        return service.getByRowHouseRent();
    }

}
