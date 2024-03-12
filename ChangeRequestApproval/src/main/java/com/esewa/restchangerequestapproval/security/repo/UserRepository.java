package com.esewa.restchangerequestapproval.security.repo;

import com.esewa.restchangerequestapproval.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findById (Integer id);
}
