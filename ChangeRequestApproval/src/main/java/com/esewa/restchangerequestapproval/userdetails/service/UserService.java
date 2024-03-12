package com.esewa.restchangerequestapproval.userdetails.service;

import com.esewa.restchangerequestapproval.userdetails.userDto.UserResponseDto;

public interface UserService {
    UserResponseDto getUserById(Integer userId);

    int getUserIdByEmail(String email);
}
