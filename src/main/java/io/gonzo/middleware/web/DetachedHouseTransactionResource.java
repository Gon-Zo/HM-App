package io.gonzo.middleware.web;

import io.gonzo.middleware.service.DetachedHouseTransactionService;
import io.gonzo.middleware.web.dto.DetachedHouseTransactionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/detached-house-transaction")
public class DetachedHouseTransactionResource {

    private final DetachedHouseTransactionService service;

    @GetMapping("")
    public List<DetachedHouseTransactionDTO.Default> showByDetachedHouseTransaction() {
        return service.getByDetachedHouseTransaction();
    }

}
