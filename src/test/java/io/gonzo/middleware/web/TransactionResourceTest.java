package io.gonzo.middleware.web;

import io.gonzo.middleware.service.TransactionService;
import io.gonzo.middleware.web.dto.TransactionDTO;
import io.gonzo.middleware.web.dto.TransactionStoreDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@ExtendWith(SpringExtension.class)
@ExtendWith(SpringExtension.class)
@WebAppConfiguration()
@AutoConfigureMockMvc
@WebMvcTest(TransactionResource.class)
class TransactionResourceTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    private TransactionService transactionService;

    @Test
    @DisplayName("파트매매 실거래 상세 [월기준]")
    public void showByTransaction() throws Exception {

        // param
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

        params.add("pickDate", "2020-01");

        params.add("regionName", "서울특별시종로구");

        params.add("pageNum", "100");

        params.add("localCode" , "11000");

        TransactionStoreDTO dto = TransactionStoreDTO.builder()
                .pageNum(100)
                .regionName("서울특별시종로구")
                .pickDate("2020-01")
                .localCode("11000")
                .build();

        List<TransactionDTO> transactionList = new ArrayList<>();

        // given
        given(transactionService.getByTransaction(dto)).willReturn(transactionList);

        //when
        final ResultActions actions = mvc.perform(get("/api/middleware/transaction")
                .params(params)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print());

        //then
        actions.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect((ResultMatcher) jsonPath("$.courtBuilding", is("갓대희")))
                .andDo(print());
    }

}
