package com.esewa.restchangerequestapproval;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestChangeRequestApprovalApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestChangeRequestApprovalApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
