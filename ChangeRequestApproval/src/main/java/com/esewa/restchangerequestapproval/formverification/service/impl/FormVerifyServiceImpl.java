package com.esewa.restchangerequestapproval.formverification.service.impl;

import com.esewa.restchangerequestapproval.formverification.dto.VerifyRequestDto;
import com.esewa.restchangerequestapproval.formverification.dto.VerifyResponseDto;
import com.esewa.restchangerequestapproval.formverification.entity.VerifyForm;
import com.esewa.restchangerequestapproval.formverification.repo.FormVerifyRepo;
import com.esewa.restchangerequestapproval.formverification.service.VerifyModelMapperService;
import com.esewa.restchangerequestapproval.shared.ChangeFormStatus;
import com.esewa.restchangerequestapproval.formverification.service.FormVerifyService;
import com.esewa.restchangerequestapproval.requestChange.repo.RequestRepo;
import com.esewa.restchangerequestapproval.security.repo.UserRepository;
import com.esewa.restchangerequestapproval.shared.MessageConstant;
import com.esewa.restchangerequestapproval.shared.exception.ResourceNotFoundException;
import com.esewa.restchangerequestapproval.shared.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FormVerifyServiceImpl implements FormVerifyService {
    private final FormVerifyRepo formVerifyRepo;
    private final RequestRepo requestRepo;
    private final UserRepository userRepository;
    private final ChangeFormStatus changeFormStatus;
    private final VerifyModelMapperService modelMapper;
    @Override

    public void createVerifyForm(VerifyRequestDto verifyRequestDto) {
        VerifyForm verifyForm = new VerifyForm();
        verifyForm.setComment(verifyRequestDto.getComment());
        verifyForm.setForm(requestRepo.findById(verifyRequestDto.getFormId()).orElseThrow(()-> new ResourceNotFoundException(MessageConstant.PRODUCT_NOT_FOUND)));
        verifyForm.setUser(userRepository.findById(verifyRequestDto.getUserId()).orElseThrow(()->new UserNotFoundException(MessageConstant.USER_NOT_FOUND)));
        changeFormStatus.changeStatusToProcessing(verifyRequestDto.getFormId());
        formVerifyRepo.save(verifyForm);
    }

    @Override
    public List<VerifyResponseDto> viewAllVerification(){
        return modelMapper.verifyFormToListDto(formVerifyRepo.findAll());
    }


}
