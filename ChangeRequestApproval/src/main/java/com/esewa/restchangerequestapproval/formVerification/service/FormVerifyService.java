package com.esewa.restchangerequestapproval.formVerification.service;


import com.esewa.restchangerequestapproval.formVerification.dto.VerifyRequestDto;
import com.esewa.restchangerequestapproval.formVerification.dto.VerifyResponseDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FormVerifyService {
    @Transactional
    void createVerifyForm(VerifyRequestDto verifyRequestDto);
     List<VerifyResponseDto> viewAllVerification();
}
