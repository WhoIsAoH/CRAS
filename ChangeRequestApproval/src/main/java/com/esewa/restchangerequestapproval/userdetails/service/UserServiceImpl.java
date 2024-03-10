package com.esewa.restchangerequestapproval.userdetails.service;

import com.esewa.restchangerequestapproval.security.user.User;
import com.esewa.restchangerequestapproval.security.user.UserRepository;
import com.esewa.restchangerequestapproval.userdetails.userDto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserResponseDto getUserById(long userId) {
        User user=userRepository.findById(userId).get();
        UserResponseDto userResponseDtoFromUser=modelMapper.map(user,UserResponseDto.class);
        return userResponseDtoFromUser;
    }
}