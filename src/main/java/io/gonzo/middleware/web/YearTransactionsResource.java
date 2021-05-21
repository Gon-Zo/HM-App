package io.gonzo.middleware.web;

import io.gonzo.middleware.service.YearTransactionsService;
import io.gonzo.middleware.web.dto.YearTransactionsDTO;
import io.gonzo.middleware.web.dto.YearTransactionsStoreDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/middleware/year-transactions")
public class YearTransactionsResource {

    private final YearTransactionsService service;

    @GetMapping("")
    public ResponseEntity<List<YearTransactionsDTO>> showByYearTransactions(YearTransactionsStoreDTO dto) {
        List<YearTransactionsDTO> data = service.getByYearTransactions(dto);
        return ResponseEntity.ok().body(data);
    }

}
