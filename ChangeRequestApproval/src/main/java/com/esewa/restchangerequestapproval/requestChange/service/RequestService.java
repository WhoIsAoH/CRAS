package com.esewa.restchangerequestapproval.requestChange.service;

import com.esewa.restchangerequestapproval.requestChange.entity.ChangeRequest;
import com.esewa.restchangerequestapproval.requestChange.model.RequestDto;
import com.esewa.restchangerequestapproval.requestChange.model.ResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RequestService {
     void createChange(RequestDto requestDto);
     List<ResponseDto> getChangeRequest();
     ResponseDto getRequestById(Long id);
     ResponseDto updateRequestForm(Long id, RequestDto requestDto);


}
