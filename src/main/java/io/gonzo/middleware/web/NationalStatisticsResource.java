package io.gonzo.middleware.web;

import io.gonzo.middleware.service.NationalStatisticsService;
import io.gonzo.middleware.web.dto.TransactionsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static io.gonzo.middleware.utils.ApiUtils.setYearYn;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/national-statistics")
public class NationalStatisticsResource {

    private final NationalStatisticsService service;

    /**
     * 전국 부동산 통계 API
     *
     * @param dto
     * @return
     */
    @GetMapping("/nationwide/number-transactions")
    public List showTransactionsByNationwide(TransactionsDTO.NationwideStore dto) {
        return service.getNumberOfTransactionsByNationwide(dto);
    }

    /**
     * 지역별 부동산 거래 건수
     *
     * @param dto
     * @returgt
     */
    @GetMapping("/number-transactions")
    public List showTransactions(TransactionsDTO.DefaultStore dto) {
        return service.getNumberOfTransactions(dto, setYearYn(dto.getApiCode().name()));
    }

}
