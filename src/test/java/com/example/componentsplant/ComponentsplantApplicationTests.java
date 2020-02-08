package com.example.componentsplant;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ComponentsplantApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

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
