package com.esewa.restchangerequestapproval.shared;

import com.esewa.restchangerequestapproval.requestChange.entity.ChangeRequest;
import com.esewa.restchangerequestapproval.requestChange.model.CRFRequestDto;
import com.esewa.restchangerequestapproval.requestChange.model.CRFResponseDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ModelMapperService {


    private final ModelMapper modelMapper;


    public ChangeRequest crfRequestDtoToChangeForm(CRFRequestDto crfRequestDto){
        ChangeRequest changeRequest = this.modelMapper.map(crfRequestDto, ChangeRequest.class);
        return changeRequest;
    }

    public CRFResponseDto changeFormToCRFRequestDto(ChangeRequest changeRequest){
        CRFResponseDto crfResponseDto = this.modelMapper.map(changeRequest, CRFResponseDto.class);
        return crfResponseDto;
    }

    public List<CRFResponseDto> entityToListDto(List<ChangeRequest> changeRequests){
        return changeRequests.stream().map(this:: changeFormToCRFRequestDto).collect(Collectors.toList());
    }
}
