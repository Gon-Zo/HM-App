package io.gonzo.middleware.web;

import io.gonzo.middleware.service.NationalStatisticsService;
import io.gonzo.middleware.web.dto.BaseDTO;
import io.gonzo.middleware.web.dto.TransactionsDTO;
import io.gonzo.middleware.web.dto.TransactionsStoreDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/national-statistics")
public class NationalStatisticsResource {

    private final NationalStatisticsService service;

    // 전구 부동산 거래 건수
    @GetMapping("/nationwide/number-transactions")
    public List<TransactionsDTO> showTransactionsByNationwide(BaseDTO dto) {
        return service.getNumberOfTransactionsByNationwide(dto);
    }

    // 부동산 거래 건수
    @GetMapping("/number-transactions")
    public List<TransactionsDTO> showTransactions(TransactionsStoreDTO dto) {
        return service.getNumberOfTransactions(dto);
    }

}
