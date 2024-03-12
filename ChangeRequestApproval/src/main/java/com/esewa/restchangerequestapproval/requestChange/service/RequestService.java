package com.esewa.restchangerequestapproval.requestChange.service;

import com.esewa.restchangerequestapproval.requestChange.dto.CRFRequestDto;
import com.esewa.restchangerequestapproval.requestChange.dto.CRFResponseDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface RequestService {
    void createChange(CRFRequestDto crfRequestDto);

    List<CRFResponseDto> getChangeRequest();

    CRFResponseDto getRequestById(Integer id);

    void updateRequestForm(Integer id, CRFRequestDto crfRequestDto);
    List<CRFResponseDto> getChangeRequestWithSortSevirity(@PathVariable String field);


}
