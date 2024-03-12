package com.esewa.restchangerequestapproval.formVerification.repo;

import com.esewa.restchangerequestapproval.formVerification.entity.VerifyForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormVerifyRepo extends JpaRepository<VerifyForm, Integer> {
}
