package com.esewa.restchangerequestapproval.formverification.service;


import com.esewa.restchangerequestapproval.formverification.dto.VerifyRequestDto;
import com.esewa.restchangerequestapproval.formverification.dto.VerifyResponseDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FormVerifyService {
    @Transactional
    void createVerifyForm(VerifyRequestDto verifyRequestDto);
     List<VerifyResponseDto> viewAllVerification();
}
