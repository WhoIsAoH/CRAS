package com.esewa.restchangerequestapproval.shared;

import com.esewa.restchangerequestapproval.requestChange.entity.ChangeRequest;
import com.esewa.restchangerequestapproval.requestChange.model.RequestDto;
import com.esewa.restchangerequestapproval.requestChange.model.ResponseDto;
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


    public ChangeRequest requestDtoToChangeForm(RequestDto requestDto){
        ChangeRequest changeRequest = this.modelMapper.map(requestDto, ChangeRequest.class);
        return changeRequest;
    }

    public ResponseDto changeFormToRequestDto(ChangeRequest changeRequest){
        ResponseDto responseDto = this.modelMapper.map(changeRequest, ResponseDto.class);
        return responseDto;
    }

    public List<ResponseDto> entityToListDto(List<ChangeRequest> changeRequests){
        return changeRequests.stream().map(this:: changeFormToRequestDto).collect(Collectors.toList());
    }
}
