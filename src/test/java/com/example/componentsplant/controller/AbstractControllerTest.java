package com.example.componentsplant.controller;


import com.example.componentsplant.dto.EmployeeSignInResponse;
import com.example.componentsplant.entity.AuthInfoEntity;
import com.example.componentsplant.entity.UserEntity;
import com.example.componentsplant.repository.AuthInfoRepository;
import com.example.componentsplant.repository.BookingRepository;
import com.example.componentsplant.repository.GoodsRepository;
import com.example.componentsplant.repository.UserRepository;
import com.example.componentsplant.security.UserRole;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.Matchers.hasLength;
import static org.mockito.BDDMockito.willReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-test.properties")
@AutoConfigureMockMvc
public abstract class AbstractControllerTest {

    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected ObjectMapper objectMapper;
    @Autowired
    protected PasswordEncoder passwordEncoder;

    @MockBean
    protected AuthInfoRepository authInfoRepository;
    @MockBean
    protected UserRepository userRepository;
    /*@MockBean*/
    protected BookingRepository bookingRepository;
    /*@MockBean*/
    protected GoodsRepository goodsRepository;


    protected String signInAsClientEmployee() throws Exception {
        final AuthInfoEntity authInfo = createAuthInfo();
        willReturn(Optional.of(authInfo)).given(authInfoRepository).findByEmail("empl@goodCompany.com");

        final String response = mockMvc.perform(post("/clients/sign-in")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"email\" : \"empl@goodCompany.com\",\n" +
                        "  \"password\" : \"qwerty\"\n" +
                        "}"))
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("token", hasLength(151)))
                .andReturn().getResponse().getContentAsString();
        return "Bearer " + objectMapper.readValue(response, EmployeeSignInResponse.class).getToken();
    }

    protected AuthInfoEntity createAuthInfo() {
        final UserEntity user = new UserEntity();
        user.setUserRole(UserRole.CLIENT);
        user.setEmail("empl@goodCompany.com");

        final AuthInfoEntity authInfo = new AuthInfoEntity();
        authInfo.setEmail(user.getEmail());
        authInfo.setPassword(passwordEncoder.encode("qwerty"));
        authInfo.setUserEntity(user);
        return authInfo;
    }

}
