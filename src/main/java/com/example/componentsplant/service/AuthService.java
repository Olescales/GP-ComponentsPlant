package com.example.componentsplant.service;

import com.example.componentsplant.dto.AuthClientResponse;
import com.example.componentsplant.dto.ClientDTO;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public AuthClientResponse signIn (ClientDTO clientDTO) {
        return AuthClientResponse.builder().id(1L).build();
    }
}
