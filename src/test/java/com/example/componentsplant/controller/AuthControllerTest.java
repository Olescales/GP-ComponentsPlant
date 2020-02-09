package com.example.componentsplant.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class AuthControllerTest extends AbstractControllerTest{

    @Test
    public void testClientSignInIsOk() throws Exception {
        // given
        // when
        mockMvc.perform(post("/client/sign-up")
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
    }
}
