package com.esewa.restchangerequestapproval.userdetails.userDto;

import com.esewa.restchangerequestapproval.security.entity.Role;
import com.esewa.restchangerequestapproval.shared.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private Integer id;
    private String firstname;
    private String location;
    private String email;
    private Role role;
    private Department department;
}
