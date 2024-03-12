package com.esewa.restchangerequestapproval.formVerification.service.impl;

import com.esewa.restchangerequestapproval.formVerification.dto.VerifyRequestDto;
import com.esewa.restchangerequestapproval.formVerification.dto.VerifyResponseDto;
import com.esewa.restchangerequestapproval.formVerification.entity.VerifyForm;
import com.esewa.restchangerequestapproval.formVerification.repo.FormVerifyRepo;
import com.esewa.restchangerequestapproval.formVerification.service.VerifyModelMapperService;
import com.esewa.restchangerequestapproval.shared.ChangeFormStatus;
import com.esewa.restchangerequestapproval.formVerification.service.FormVerifyService;
import com.esewa.restchangerequestapproval.requestChange.repo.RequestRepo;
import com.esewa.restchangerequestapproval.security.repo.UserRepository;
import com.esewa.restchangerequestapproval.shared.MessageConstant;
import com.esewa.restchangerequestapproval.shared.exception.ResourceNotFoundException;
import com.esewa.restchangerequestapproval.shared.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
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
