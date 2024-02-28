package com.esewa.restchangerequestapproval.requestChange.service;

import com.esewa.restchangerequestapproval.requestChange.entity.ChangeRequest;
import com.esewa.restchangerequestapproval.requestChange.model.RequestDto;
import com.esewa.restchangerequestapproval.requestChange.repo.RequestRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService{

    private final RequestRepo requestRepo;

    public List<RequestDto> getChangeRequest(){
        return requestRepo.findAll().stream().map(this::convertEntityToDto).toList();
    }

    private RequestDto convertEntityToDto(ChangeRequest changeRequest) {
        RequestDto requestDto = new RequestDto();
        requestDto.setTopic(changeRequest.getTopic());
        requestDto.setDepartment(changeRequest.getDepartment());
        requestDto.setAssignTo(changeRequest.getAssignTo());
        requestDto.setReviewer(changeRequest.getReviewer());
        requestDto.setSeverity(changeRequest.getSeverity());
        requestDto.setEndDate(changeRequest.getEndDate());
        requestDto.setDescription(changeRequest.getDescription());
        requestDto.setImpact(changeRequest.getImpact());
        requestDto.setRollBack(changeRequest.getRollBack());
        requestDto.setStatus(changeRequest.getStatus());
        requestDto.setDeleteStatus(changeRequest.isDeleteStatus());
        return requestDto;
    }


    @Override
    public void createRequest(ChangeRequest change){
        requestRepo.save(change);
    }
//
//    @Override
//    public List<ChangeRequest> viewAllRequest(){
//        List<ChangeRequest> allRequest = new ArrayList<>();
//        requestRepo.findAll().forEach(request1->allRequest.add(request1));
//        return allRequest;
//    }

}
