package io.gonzo.middleware.web;

import io.gonzo.middleware.service.NationalStatisticsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(NationalStatisticsResource.class)
@DisplayName("부동산 건수 api")
class NationalStatisticsResourceTest {

    private MockMvc mvc;

    @MockBean
    private NationalStatisticsService service;

    @BeforeEach
    void setUp(){
        mvc = MockMvcBuilders.standaloneSetup(new NationalStatisticsResource(service))
                .addFilter(new CharacterEncodingFilter("UTF-8" ,  true))
                .build();
    }

    @Test
    @DisplayName("전구 부동산 거래 건수 API")
    void showTransactionsByNationwide () throws Exception{

        // when
        final ResultActions action = mvc.perform(
                get("/api/national-statistics/nationwide/number-transactions")
                //.contentType(MediaType.APPLICATION_JSON)
                .param("startDate" , "202010")
                .param("endDate" , "202010")
                .param("region" , "11000")
                .param("isYear" , "false")
        );

         // action
        String test1 ="";
    }

}
