package io.gonzo.middleware.web;

import io.gonzo.middleware.service.RegionService;
import io.gonzo.middleware.service.TransactionService;
import io.gonzo.middleware.web.dto.TransactionStoreDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TransactionResource.class)
class TransactionResourceTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    private TransactionService transactionService;

    @MockBean
    private RegionService regionService;

    @Test
    @DisplayName("파트매매 실거래 상세 [월기준]")
    public void showByTransaction() throws Exception {

        // dto
        TransactionStoreDTO dto = TransactionStoreDTO.builder()
                .pickDate("2020-01")
                .regionName("서울특별시종로구")
                .pageNum(100)
                .build();

        String localCode = regionService.getByRegionCode(dto.getRegionName());

        dto.setLocalCode(localCode);

        //when
//        final ResultActions actions = mvc.perform(get("/api/middleware/transaction")
        final ResultActions actions = mvc.perform(get("/api/middleware/transaction?pickDate=2020-01&regionName=서울특별시종로구&pageNum=100")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print());

        //then
        actions.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect((ResultMatcher) jsonPath("$.courtBuilding", is("갓대희")))
                .andDo(print());
    }

}
