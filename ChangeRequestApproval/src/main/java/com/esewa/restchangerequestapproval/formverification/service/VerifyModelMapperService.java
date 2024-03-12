package com.esewa.restchangerequestapproval.formverification.service;

import com.esewa.restchangerequestapproval.formverification.dto.VerifyRequestDto;
import com.esewa.restchangerequestapproval.formverification.dto.VerifyResponseDto;
import com.esewa.restchangerequestapproval.formverification.entity.VerifyForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class VerifyModelMapperService {
    private final ModelMapper modelMapper;
    public VerifyForm requestDtoToVerifyForm(VerifyRequestDto verifyRequestDto){
        return modelMapper.map(verifyRequestDto, VerifyForm.class);
    }
    public VerifyResponseDto verifyFormToResponseDto(VerifyForm verifyForm){
        return modelMapper.map(verifyForm, VerifyResponseDto.class);
    }

    public List<VerifyResponseDto> verifyFormToListDto(List<VerifyForm> verifyForms){
        return verifyForms.stream().map(this::verifyFormToResponseDto).collect(Collectors.toList());
    }

}
