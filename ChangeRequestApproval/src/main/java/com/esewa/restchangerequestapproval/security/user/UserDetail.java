package com.esewa.restchangerequestapproval.security.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetail extends UserDetails {
    String getFirstName();

}
