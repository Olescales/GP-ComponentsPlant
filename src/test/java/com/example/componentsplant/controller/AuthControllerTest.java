package com.example.componentsplant.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.util.Optional;

import static org.hamcrest.Matchers.hasLength;
import static org.mockito.BDDMockito.willReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AuthControllerTest extends AbstractControllerTest{

    @Test
    public void testClientsEmployeeSignUpIsOk() throws Exception {
        // given
       // given(authInfoRepository.findByLogin("empl@goodCompany.com")).willReturn(Optional.empty());
        willReturn(Optional.empty(), Optional.of(createAuthInfo())).given(authInfoRepository)
                .findByLogin("empl@goodCompany.com");
        // when
        mockMvc.perform(post("/clients/sign-up")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"companyName\" : \"goodCompany\",\n" +
                        "  \"fio\" : \"Ivanov Ivan Ivanovich\",\n" +
                        "  \"email\" : \"empl@goodCompany.com\",\n" +
                        "  \"password\" : \"qwerty\",\n" +
                        "  \"birthDate\" : \"15.05.1994\"\n" +
                        "}"))
                // then
                .andExpect(status().isCreated())
                .andExpect(jsonPath("token", hasLength(151)));
    }


    @Test
    public void testClientsEmployeeSignUpWhenUserAlreadyExisted() throws Exception {
        // given
        signInAsClientEmployee();
        // when
        mockMvc.perform(post("/clients/sign-up")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"companyName\" : \"goodCompany\",\n" +
                        "  \"fio\" : \"Ivanov Ivan Ivanovich\",\n" +
                        "  \"email\" : \"empl@goodCompany.com\",\n" +
                        "  \"password\" : \"qwerty\",\n" +
                        "  \"birthDate\" : \"15.05.1994\"\n" +
                        "}"))
                // then
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testClientsEmployeeSignInIsOk() throws Exception {
        // given
        signInAsClientEmployee();
        // when
        mockMvc.perform(post("/clients/sign-in")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"email\" : \"empl@goodCompany.com\",\n" +
                        "  \"password\" : \"qwerty\"\n" +
                        "}"))
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("token", hasLength(151)));
    }

    @Test
    public void testClientsEmployeeSignInWithWrongPassword() throws Exception {
        // given
        signInAsClientEmployee();
        // when
        mockMvc.perform(post("/clients/sign-in")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"email\" : \"empl@goodCompany.com\",\n" +
                        "  \"password\" : \"wrongPassword\"\n" +
                        "}"))
                // then
                .andExpect(status().isForbidden());
    }

    @Test
    public void testClientsEmployeeSignInWithWrongLogin() throws Exception {
        // given
        signInAsClientEmployee();
        // when
        mockMvc.perform(post("/clients/sign-in")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"email\" : \"noSuchempl@goodCompany.com\",\n" +
                        "  \"password\" : \"wrongPassword\"\n" +
                        "}"))
                // then
                .andExpect(status().isForbidden());
    }
}
