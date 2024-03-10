package com.esewa.restchangerequestapproval.userdetails.service;

import com.esewa.restchangerequestapproval.security.user.User;
import com.esewa.restchangerequestapproval.userdetails.userDto.UserResponseDto;

public interface UserService {
    UserResponseDto getUserById(long userId);
}
