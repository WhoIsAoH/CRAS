package com.esewa.restchangerequestapproval;

import com.esewa.restchangerequestapproval.security.auth.RegisterRequestDto;
import com.esewa.restchangerequestapproval.security.entity.Role;
import com.esewa.restchangerequestapproval.security.repo.UserRepository;
import com.esewa.restchangerequestapproval.security.service.AuthenticationService;
import com.esewa.restchangerequestapproval.shared.Department;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;




@SpringBootApplication
@RequiredArgsConstructor
public class RestChangeRequestApprovalApplication implements CommandLineRunner {

    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(RestChangeRequestApprovalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if(userRepository.findAll().isEmpty()) {
//            RegisterRequestDto dto = RegisterRequestDto.builder()
//                    .id(0)
//                    .build();


            RegisterRequestDto registerRequestDto = RegisterRequestDto.builder()
                    .firstname("Admin")
                    .lastname("admin")
                    .email("admin@aoh.aoh")
                    .password("admin")
                    .role(Role.ADMIN)
                    .supervisor(1)
                    .department(Department.CYBERSECURITY)
                    .location("esewa")
                    .build();
            authenticationService.register(registerRequestDto);

            //can be removed
            registerRequestDto = RegisterRequestDto.builder()
                    .firstname("sup")
                    .lastname("sup")
                    .email("sup@aoh.aoh")
                    .password("sup")
                    .role(Role.SUPERVISOR)
                    .supervisor(1)
                    .department(Department.CYBERSECURITY)
                    .location("esewa")
                    .build();
            authenticationService.register(registerRequestDto);

            registerRequestDto = RegisterRequestDto.builder()
                    .firstname("dev")
                    .lastname("dev")
                    .email("dev@aoh.aoh")
                    .password("dev")
                    .role(Role.DEVELOPER)
                    .supervisor(2)
                    .department(Department.CYBERSECURITY)
                    .location("esewa")
                    .build();
            authenticationService.register(registerRequestDto);

            registerRequestDto = RegisterRequestDto.builder()
                    .firstname("dev2")
                    .lastname("dev2")
                    .email("dev2@aoh.aoh")
                    .password("dev2")
                    .role(Role.DEVELOPER)
                    .supervisor(2)
                    .department(Department.CYBERSECURITY)
                    .location("esewa")
                    .build();
            authenticationService.register(registerRequestDto);
        }
    }
}

