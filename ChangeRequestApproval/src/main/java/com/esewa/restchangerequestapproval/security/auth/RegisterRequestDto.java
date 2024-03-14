package com.esewa.restchangerequestapproval.security.auth;

import com.esewa.restchangerequestapproval.security.entity.Role;
import com.esewa.restchangerequestapproval.shared.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDto {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Role role;
    private Integer supervisor;
    private Department department;
    private String location;

}
