package com.esewa.restchangerequestapproval.security.entity;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetail extends UserDetails  {

    String getRole();


}
