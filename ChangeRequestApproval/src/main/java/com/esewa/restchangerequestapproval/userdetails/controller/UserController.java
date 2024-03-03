package com.esewa.restchangerequestapproval.userdetails.controller;

import com.esewa.restchangerequestapproval.security.user.User;
import com.esewa.restchangerequestapproval.security.user.UserRepository;
import com.esewa.restchangerequestapproval.userdetails.service.UserService;
import com.esewa.restchangerequestapproval.userdetails.userDto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class UserController {
    private final UserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable("id") @RequestBody long userId) {
        UserResponseDto userResponseDto=userService.getUserById(userId);
        return new ResponseEntity<UserResponseDto>(userResponseDto,HttpStatus.OK);
    }
}
