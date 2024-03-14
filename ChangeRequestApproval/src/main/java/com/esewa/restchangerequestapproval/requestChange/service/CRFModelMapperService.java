package com.esewa.restchangerequestapproval.requestChange.service;

import com.esewa.restchangerequestapproval.requestChange.entity.ChangeRequest;
import com.esewa.restchangerequestapproval.requestChange.dto.CRFRequestDto;
import com.esewa.restchangerequestapproval.requestChange.dto.CRFResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
public class CRFModelMapperService {

    private final ModelMapper modelMapper;

    public ChangeRequest crfRequestDtoToChangeForm(CRFRequestDto crfRequestDto){
        return modelMapper.map(crfRequestDto,ChangeRequest.class);
    }

    public CRFResponseDto changeFormToCRFRequestDto(ChangeRequest changeRequest){
        //error
        CRFResponseDto crfResponseDto = this.modelMapper.map(changeRequest, CRFResponseDto.class);
        crfResponseDto.setAuthorId(changeRequest.getAuthor().getId());
//        crfResponseDto.setAssignTo(changeRequest.getAssignTo().getId());
//        crfResponseDto.setSupervisor(changeRequest.getSupervisor().getId());
        crfResponseDto.setSupervisorId(changeRequest.getSupervisor().getId());
        crfResponseDto.setAssignToId(changeRequest.getAssignTo().getId());
        log.info(String.valueOf(crfResponseDto.getAuthorId()));
        log.info(String.valueOf(crfResponseDto.getAssignTo()));
        return crfResponseDto;
    }

    public List<CRFResponseDto> entityToListDto(List<ChangeRequest> changeRequests){
        return changeRequests.stream().map(this:: changeFormToCRFRequestDto).collect(Collectors.toList());
    }
}
