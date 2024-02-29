package com.esewa.restchangerequestapproval.security.user;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetail extends UserDetails {
    String getFirstName();

}
