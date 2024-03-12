package com.esewa.restchangerequestapproval.security.controller;


import com.esewa.restchangerequestapproval.security.auth.AuthenticationRequest;
import com.esewa.restchangerequestapproval.security.auth.AuthenticationResponse;
import com.esewa.restchangerequestapproval.security.auth.RegisterRequest;
import com.esewa.restchangerequestapproval.security.service.AuthenticationService;
import com.esewa.restchangerequestapproval.shared.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    @PostMapping("/register")
    public UserResponse register(@RequestBody @Validated RegisterRequest request){
        return service.register(request);
    }

    @PostMapping("/authenticate")
    public AuthenticationResponse authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return service.authenticate(request);

    }

}
