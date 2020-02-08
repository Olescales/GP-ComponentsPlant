package com.example.componentsplant.controller;

import com.example.componentsplant.dto.ClientDTO;
import com.example.componentsplant.service.AuthService;
import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Log
@Data
@RestController
@RequestMapping(value = "/client", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "/sign-up")
    public String register(@RequestBody ClientDTO request) {
        log.info(request.toString());
        return "{\n" +
                "  \"id\" : 1\n" +
                "}";
    }
}
