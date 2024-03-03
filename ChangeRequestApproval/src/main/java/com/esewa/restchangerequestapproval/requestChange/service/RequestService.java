package com.esewa.restchangerequestapproval.requestChange.service;

import com.esewa.restchangerequestapproval.requestChange.model.CRFRequestDto;
import com.esewa.restchangerequestapproval.requestChange.model.CRFResponseDto;

import java.util.List;

public interface RequestService {
    void createChange(CRFRequestDto crfRequestDto);

    List<CRFResponseDto> getChangeRequest();

    CRFResponseDto getRequestById(Long id);

    CRFResponseDto updateRequestForm(Long id, CRFRequestDto crfRequestDto);


}
