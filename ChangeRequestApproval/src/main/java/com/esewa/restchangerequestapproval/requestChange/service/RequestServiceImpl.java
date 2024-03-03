package com.esewa.restchangerequestapproval.requestChange.service;

import com.esewa.restchangerequestapproval.requestChange.entity.ChangeRequest;
import com.esewa.restchangerequestapproval.requestChange.model.CRFRequestDto;
import com.esewa.restchangerequestapproval.requestChange.model.CRFResponseDto;
import com.esewa.restchangerequestapproval.requestChange.repo.RequestRepo;
import com.esewa.restchangerequestapproval.shared.ModelMapperService;
import com.esewa.restchangerequestapproval.shared.exception.GlobalExceptionHandler;
import com.esewa.restchangerequestapproval.shared.exception.ResourceNotFoundException;
import com.esewa.restchangerequestapproval.shared.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {

    private final RequestRepo requestRepo;

    private final ModelMapperService modelMapperService;


    @Override
    public List<CRFResponseDto> getChangeRequest() {
        return modelMapperService.entityToListDto(requestRepo.findAll());
    }

    @Override
    public void createChange(CRFRequestDto crfRequestDto) {
        log.info("creating change request");
        requestRepo.save(modelMapperService.crfRequestDtoToChangeForm(crfRequestDto));
    }

    @Override
    public CRFResponseDto getRequestById(Long id) {
        ChangeRequest changeRequest = requestRepo.findById(id)
                .orElseThrow(() -> {
                log.error("got error" );
                throw new RuntimeException("error finding id with" + id);
                });

//        log.error("ERROR FINDING ID");
        return modelMapperService.changeFormToCRFRequestDto(changeRequest);
    }

    public CRFResponseDto updateRequestForm(Long id, CRFRequestDto crfRequestDto) {
        ChangeRequest existingRequest = requestRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(crfRequestDto.getTopic(), crfRequestDto.getDepartment(), id));

        ChangeRequest updatedRequest = modelMapperService.crfRequestDtoToChangeForm(crfRequestDto);

        existingRequest.setTopic(updatedRequest.getTopic());
        existingRequest.setDepartment(updatedRequest.getDepartment());
        existingRequest.setAssignTo(updatedRequest.getAssignTo());
        existingRequest.setReviewer(updatedRequest.getReviewer());
        existingRequest.setSeverity(updatedRequest.getSeverity());
        existingRequest.setEndDate(updatedRequest.getEndDate());
        existingRequest.setDescription(updatedRequest.getDescription());
        existingRequest.setImpact(updatedRequest.getImpact());
        existingRequest.setRollBack(updatedRequest.getRollBack());

        return modelMapperService.changeFormToCRFRequestDto(existingRequest);

    }


}
