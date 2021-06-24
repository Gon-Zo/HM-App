package io.gonzo.middleware.web;

import io.gonzo.middleware.service.TransactionService;
import io.gonzo.middleware.web.dto.TransactionDTO;
import io.gonzo.middleware.web.dto.TransactionStoreDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/middleware/transaction")
public class TransactionResource {

    private final TransactionService service;

    @GetMapping("")
    public ResponseEntity<List<TransactionDTO>> showByTransaction(TransactionStoreDTO dto) {
        List<TransactionDTO> data = service.getByTransaction(dto);
        return ResponseEntity.ok().body(data);
    }

    @GetMapping("/trend")
    public ResponseEntity<List<TransactionDTO>> showByTrend(TransactionStoreDTO dto) {
        List<TransactionDTO> data = service.getByTransactionTrend(dto);
        return ResponseEntity.ok().body(data);
    }

}
