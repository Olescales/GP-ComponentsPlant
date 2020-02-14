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

    /*@Test
    public void testClientEmployeeSignUpIsOk() throws Exception {
        // given

        // when
        mockMvc.perform(post("/clients/sign-up")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"name\" : \"helg\",\n" +
                        "  \"legalAddress\" : \"bagrationa street\",\n" +
                        "  \"accountNumberOfTheTaxpayer\" : \"987654321\",\n" +
                        "  \"country\" : \"belarus\",\n" +
                        "  \"bankAccount\" : \"12345678901234567890\",\n" +
                        "  \"email\" : \"me@client.com\",\n" +
                        "  \"password\" : \"goodpassword\"\n" +
                        "}"))
                // then
                .andExpect(status().isCreated())
                .andExpect(content().json("{\n" +
                        "  \"id\" : 1\n" +
                        "}"));
    }*/

    @Test
    public void testClientsEmployeeSignUpIsOk() throws Exception {
        // given
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
                .andExpect(jsonPath("token", hasLength(144)));
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
                .andExpect(jsonPath("token", hasLength(144)));
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
    public void testClientsEmployeeSignInWithWrongEmail() throws Exception {
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
