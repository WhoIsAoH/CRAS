package com.esewa.restchangerequestapproval.requestChange.service;

import com.esewa.restchangerequestapproval.requestChange.entity.ChangeRequest;
import com.esewa.restchangerequestapproval.requestChange.model.RequestDto;
import com.esewa.restchangerequestapproval.requestChange.model.ResponseDto;
import com.esewa.restchangerequestapproval.requestChange.repo.RequestRepo;
import com.esewa.restchangerequestapproval.shared.ModelMapperService;
import com.esewa.restchangerequestapproval.shared.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService{

    private final RequestRepo requestRepo;

    private final ModelMapperService modelMapperService;


    @Override
    public List<ResponseDto> getChangeRequest() {
        return modelMapperService.entityToListDto(requestRepo.findAll());
    }

    @Override
    public void createChange(RequestDto requestDto){
        log.info("creating change request");
        requestRepo.save(modelMapperService.requestDtoToChangeForm(requestDto));
//        requestRepo.save(change);
    }

    @Override
    public ResponseDto getRequestById(Long id){
        ChangeRequest changeRequest = requestRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("error finding id with"+id));
        return modelMapperService.changeFormToRequestDto(changeRequest);
    }

    public ResponseDto updateRequestForm(Long id, RequestDto requestDto){
        ChangeRequest existingRequest = requestRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("","",id));

        ChangeRequest updatedRequest = modelMapperService.requestDtoToChangeForm(requestDto);

        existingRequest.setTopic(updatedRequest.getTopic());
        existingRequest.setDepartment(updatedRequest.getDepartment());
        existingRequest.setAssignTo(updatedRequest.getAssignTo());
        existingRequest.setReviewer(updatedRequest.getReviewer());
        existingRequest.setSeverity(updatedRequest.getSeverity());
        existingRequest.setEndDate(updatedRequest.getEndDate());
        existingRequest.setDescription(updatedRequest.getDescription());
        existingRequest.setImpact(updatedRequest.getImpact());
        existingRequest.setRollBack(updatedRequest.getRollBack());

        return modelMapperService.changeFormToRequestDto(existingRequest);
//        return modelMapperService.requestDtoToChangeForm(existingRequest);

    }












}
