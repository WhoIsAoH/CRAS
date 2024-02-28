package com.esewa.restchangerequestapproval.requestChange.service;

import com.esewa.restchangerequestapproval.requestChange.entity.ChangeRequest;
import com.esewa.restchangerequestapproval.requestChange.model.RequestDto;

import java.util.List;

public interface RequestService {
     List<RequestDto> getChangeRequest();
      void createRequest(ChangeRequest change);

}
