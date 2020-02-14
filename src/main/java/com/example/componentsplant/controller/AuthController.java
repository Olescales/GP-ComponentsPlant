package com.example.componentsplant.controller;

import com.example.componentsplant.dto.EmployeeSignInRequest;
import com.example.componentsplant.dto.EmployeeSignInResponse;
import com.example.componentsplant.dto.EmployeeSignUpRequest;
import com.example.componentsplant.exception.SuchClientAlreadyExistsException;
import com.example.componentsplant.security.JwtUtil;
import com.example.componentsplant.security.UserRole;
import com.example.componentsplant.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    private final AuthService authService;

    @PostMapping(value = "/clients/sign-up", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeSignInResponse signUp (@RequestBody final EmployeeSignUpRequest request) throws SuchClientAlreadyExistsException {
        authService.signUp(request);
        return signIn(new EmployeeSignInRequest(request.getLogin(), request.getPassword()));
    }

    @PostMapping(value = "/clients/sign-in", consumes = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeSignInResponse signIn(@RequestBody final EmployeeSignInRequest request) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword()));

        return new EmployeeSignInResponse(
                jwtUtil.generateToken(
                        new User(request.getLogin(), request.getPassword(),
                                List.of(new SimpleGrantedAuthority(UserRole.CLIENT.name())))));
    }
}
