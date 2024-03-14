package com.esewa.restchangerequestapproval.security.service;

import com.esewa.restchangerequestapproval.security.auth.AuthenticationRequestDto;
import com.esewa.restchangerequestapproval.security.auth.AuthenticationResponseDto;
import com.esewa.restchangerequestapproval.security.auth.RegisterRequestDto;
import com.esewa.restchangerequestapproval.security.entity.User;
import com.esewa.restchangerequestapproval.security.repo.UserRepository;
import com.esewa.restchangerequestapproval.shared.MailService;
import com.esewa.restchangerequestapproval.shared.MessageConstant;
import com.esewa.restchangerequestapproval.shared.UserResponse;
import com.esewa.restchangerequestapproval.shared.exception.UserAlreadyExistException;
import com.esewa.restchangerequestapproval.shared.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final MailService mailService;

    public UserResponse register(RegisterRequestDto request) {
            Optional<User> optionalUser = repository.findByEmail(request.getEmail());
            if (optionalUser.isPresent()) {
                log.info("user registered already");
                throw new UserAlreadyExistException(MessageConstant.ALREADY_REGISTER_USER);
            }
                log.info("NoDuplicateEmail");
                var user = User.builder()
                        .firstname(request.getFirstname())
                        .lastname(request.getLastname())
                        .email(request.getEmail())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .department(request.getDepartment())
                        .location(request.getLocation())
                        .role(request.getRole())
//                        .supervisor(request.getSupervisor())
//                        .supelrvisor(repository.getById(request.getSupervisor()))
//                        .supervisor(new ArrayList<>(Arrays.asList(User.builder().id(request.getSupervisor()).build())))
                        .build();
                repository.save(user);
                var jwtToken = jwtService.generateToken(user);
                AuthenticationResponseDto jwt = new AuthenticationResponseDto(jwtToken);
                mailService.sendEmail(user.getEmail(), MessageConstant.ACCOUNT_CREATION_SUCCESSFUL, MessageConstant.ACCOUNT_CREATE_BODY);
                return new UserResponse(MessageConstant.SAVED_SUCCESSFULLY);
    }
    public AuthenticationResponseDto authenticate(AuthenticationRequestDto request) {
        log.info("login or authenticating");
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(), request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow(()->{
                    log.error("User Not Found");
                    throw new UserNotFoundException("User Not Found!! Create user first");
                            }
                        );
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseDto.builder()
                .token(jwtToken)
                .build();
    }
}
