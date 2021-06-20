package io.gonzo.middleware.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest
@DisplayName("월간 데이터")
class CharterMonthlyResourceTest {

    private MockMvc mvc;

//    @MockBean
//    private MemberService memberService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    @DisplayName("api_테스트")
    public void testByCharterMonthly() throws Exception{

//        given(memberService.detail(any())).willReturn(mockMember);
        System.out.println(">>>>>>>>>>>>>> suceess");

        // when
        final ResultActions actions = mvc.perform(get("/v1/members/1"));

    }

}
