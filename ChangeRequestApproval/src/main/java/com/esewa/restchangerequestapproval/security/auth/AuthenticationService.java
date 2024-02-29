package com.esewa.restchangerequestapproval.security.auth;

import com.esewa.restchangerequestapproval.security.config.JwtService;
import com.esewa.restchangerequestapproval.security.user.User;
import com.esewa.restchangerequestapproval.security.user.UserRepository;
import com.esewa.restchangerequestapproval.shared.MessageConstant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.bridge.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public ResponseEntity<?> register(RegisterRequest request) {

            Optional<User> optionalUser = repository.findByEmail(request.getEmail());
            if (optionalUser.isPresent()) {
                log.info("user registered already");
                return ResponseEntity.badRequest().body(MessageConstant.alreadyRegisterUser);
            }
                log.info("NoDuplicateEmail");
                var user = User.builder()
                        .firstname(request.getFirstname())
                        .lastname(request.getLastname())
                        .email(request.getEmail())
                        .password(passwordEncoder.encode(request.getPassword()))

//                .role(Role.ADMIN)
                        .role(request.getRole())
                        .build();
                repository.save(user);
                var jwtToken = jwtService.generateToken(user);
                AuthenticationResponse jwt = new AuthenticationResponse(jwtToken);
                return ResponseEntity.ok(jwtToken);


    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        log.info("login or authenticating");
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(), request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
