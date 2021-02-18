package io.gonzo.middleware.web;

import io.gonzo.middleware.service.TransactionService;
import io.gonzo.middleware.web.dto.TransactionDTO;
import io.gonzo.middleware.web.dto.TransactionStoreDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/middleware")
public class TransactionResource {

    private final TransactionService service;

    @GetMapping("/transaction")
    public List<TransactionDTO> showByTransaction(TransactionStoreDTO dto) {
        return service.getByTransaction(dto);
    }

}
