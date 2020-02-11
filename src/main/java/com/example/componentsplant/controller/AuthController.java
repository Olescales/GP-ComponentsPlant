package com.example.componentsplant.controller;

import com.example.componentsplant.dto.AuthClientResponse;
import com.example.componentsplant.dto.ClientDTO;
import com.example.componentsplant.service.AuthService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@Data
@RestController
@RequestMapping(value = "/clients", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "/sign-up", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public AuthClientResponse register(@RequestBody ClientDTO request) {
        return authService.signIn(request);
    }
}
