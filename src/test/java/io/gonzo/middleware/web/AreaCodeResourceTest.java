package io.gonzo.middleware.web;

import io.gonzo.middleware.service.AreaCodeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AreaCodeResource.class)
@DisplayName("지역 코드 컨트롤러 테스트")
class AreaCodeResourceTest {

    private MockMvc mvc;

    @MockBean
    private AreaCodeService areaCodeService;

    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(new AreaCodeResource(areaCodeService))
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .build();
    }

    @Test
    @DisplayName("지역 코드 컨트롤러 api")
    void getAreaList() throws Exception {

        // when
        final ResultActions actions = mvc.perform(
                get("/api/area-code")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
        );

//        actions
//                .andExpect(status().isCreated())

    }

}
