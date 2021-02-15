package io.gonzo.middleware.web;

import io.gonzo.middleware.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/middleware")
public class TransactionResource {

    private final TransactionService service;

    @GetMapping("/transaction")
    public void showByTransaction() {
        service.getByTransaction();
    }

}
