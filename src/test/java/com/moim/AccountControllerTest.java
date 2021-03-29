package com.moim;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


// 실제 서블릿 컨테이너가 뜨지 않음. mock객체 생성하여 테스트
@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTest {

    @Autowired private MockMvc mockMvc;

    @DisplayName("회원가입화면")
    @Test
    void signUpForm() throws Exception {
        mockMvc.perform(get("/sign-up"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(view().name("account/sign-up"))
                .andExpect(model().attributeExists("signUpForm "));

    }
}