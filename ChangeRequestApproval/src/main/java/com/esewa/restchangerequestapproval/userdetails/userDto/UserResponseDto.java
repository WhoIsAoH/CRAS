package com.esewa.restchangerequestapproval.userdetails.userDto;

import com.esewa.restchangerequestapproval.security.user.Role;
import com.esewa.restchangerequestapproval.shared.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private long id;
    private String firstname;
    private String location;
    private String email;
    private Role role;
    private Department department;
}
