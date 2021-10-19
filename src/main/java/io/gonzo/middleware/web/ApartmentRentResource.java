package io.gonzo.middleware.web;

import io.gonzo.middleware.service.ApartmentRentService;
import io.gonzo.middleware.web.dto.ApartmentRentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/apartment-rent")
public class ApartmentRentResource {

    private final ApartmentRentService service;

    @GetMapping("")
    public List<ApartmentRentDTO.Default> showByApartmentRent(ApartmentRentDTO.Store dto) {
        return service.getByApartmentRent(dto);
    }

}
