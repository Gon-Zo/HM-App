package io.gonzo.middleware.web;

import io.gonzo.middleware.service.AllianceAmountService;
import io.gonzo.middleware.service.RegionService;
import io.gonzo.middleware.web.dto.AllianceAmountDTO;
import io.gonzo.middleware.web.dto.AllianceAmountStoreDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/middleware/alliance-amount")
public class AllianceAmountResource {

    private final AllianceAmountService service;

    private final RegionService regionService;

    @GetMapping("")
    public ResponseEntity<List<AllianceAmountDTO>> showByAllianceAmount(AllianceAmountStoreDTO dto) {
        dto.setLocalCode(regionService.getByRegionCode(dto.getRegionName()));
        List<AllianceAmountDTO> result = service.getByAllianceAmountList(dto);
        return ResponseEntity.ok().body(result);
    }

}
