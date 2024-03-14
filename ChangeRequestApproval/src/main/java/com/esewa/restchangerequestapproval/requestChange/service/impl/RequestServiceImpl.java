package com.esewa.restchangerequestapproval.requestChange.service.impl;

import com.esewa.restchangerequestapproval.requestChange.entity.ChangeRequest;
import com.esewa.restchangerequestapproval.requestChange.dto.CRFRequestDto;
import com.esewa.restchangerequestapproval.requestChange.dto.CRFResponseDto;
import com.esewa.restchangerequestapproval.requestChange.repo.RequestRepo;
import com.esewa.restchangerequestapproval.requestChange.service.CRFModelMapperService;
import com.esewa.restchangerequestapproval.requestChange.service.RequestService;
import com.esewa.restchangerequestapproval.security.repo.UserRepository;
import com.esewa.restchangerequestapproval.shared.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {

    private final RequestRepo requestRepo;

    private final com.esewa.restchangerequestapproval.requestChange.service.CRFModelMapperService CRFModelMapperService;

    private final UserRepository userRepository;


    @Override
    public List<CRFResponseDto> getChangeRequest() {
        List<ChangeRequest> changeRequests=requestRepo.findAll();
        return CRFModelMapperService.entityToListDto(changeRequests);
    }

    @Override
    public List<CRFResponseDto> getChangeRequestWithSortSevirity(@PathVariable String field) {
        List<ChangeRequest> changeRequests=requestRepo.findAll(Sort.by(Sort.Direction.ASC, field));
        return CRFModelMapperService.entityToListDto(changeRequests);
    }


    @Override
    public void createChange(CRFRequestDto crfRequestDto) {
        log.info("creating change request");
        ChangeRequest changeRequest= CRFModelMapperService.crfRequestDtoToChangeForm(crfRequestDto);
        log.info("author ko kuraa");
        log.info(String.valueOf(crfRequestDto.getAuthor()));
        changeRequest.setAuthor(userRepository.findById(crfRequestDto.getAuthor()).get());
        log.info(String.valueOf(userRepository.findById(crfRequestDto.getSupervisor()).get()));
        changeRequest.setSupervisor(userRepository.findById(crfRequestDto.getSupervisor()).get());
        log.info(String.valueOf(userRepository.findById(crfRequestDto.getAssignTo()).get()));
        changeRequest.setAssignTo(userRepository.findById(crfRequestDto.getAssignTo()).get());
        changeRequest.setAssigneeVerification(false);
        changeRequest.setSupervisorVerification(false);
        log.info("testing ");
        requestRepo.save(changeRequest);

    }

    @Override
    public CRFResponseDto getRequestById(Integer id) {
        ChangeRequest changeRequest = requestRepo.findById(id)
                .orElseThrow(() -> {
                log.error("got error" );
                throw new RuntimeException("error finding id with" + id);
                });
        //user object
        //user id
        log.info("printing dto by id");
        log.info(String.valueOf(changeRequest.getAuthor().getId()));
        return CRFModelMapperService.changeFormToCRFRequestDto(changeRequest);
    }

    public void updateRequestForm(Integer id, CRFRequestDto crfRequestDto) {
        ChangeRequest existingRequest = requestRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(crfRequestDto.getTopic()));
        ChangeRequest updatedRequest = CRFModelMapperService.crfRequestDtoToChangeForm(crfRequestDto);
        existingRequest.setTopic(updatedRequest.getTopic());
        existingRequest.setDepartment(updatedRequest.getDepartment());
        existingRequest.setAssignTo(updatedRequest.getAssignTo());
        existingRequest.setSupervisor(updatedRequest.getSupervisor());
        existingRequest.setSeverity(updatedRequest.getSeverity());
        existingRequest.setEndDate(updatedRequest.getEndDate());
        existingRequest.setDescription(updatedRequest.getDescription());
        existingRequest.setImpact(updatedRequest.getImpact());
        existingRequest.setRollBack(updatedRequest.getRollBack());
        requestRepo.save(existingRequest);
    }
}
