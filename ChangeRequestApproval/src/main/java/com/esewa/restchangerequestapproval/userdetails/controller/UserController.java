package com.esewa.restchangerequestapproval.userdetails.controller;

import com.esewa.restchangerequestapproval.userdetails.service.UserService;
import com.esewa.restchangerequestapproval.userdetails.userDto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/user/{id}")
    public UserResponseDto getUser(@PathVariable Integer id) {
        UserResponseDto userResponseDto=userService.getUserById(id);
        return userResponseDto;
    }
    @GetMapping("/getUserByEmail")
    public int getUserByEmail(@RequestParam String email) {
        int userId=userService.getUserIdByEmail(email);
        return userId;
    }
}
