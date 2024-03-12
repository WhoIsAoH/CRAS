package com.esewa.restchangerequestapproval.formverification.repo;

import com.esewa.restchangerequestapproval.formverification.entity.VerifyForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormVerifyRepo extends JpaRepository<VerifyForm, Integer> {
}
