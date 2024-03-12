package com.esewa.restchangerequestapproval.requestChange.controller;

import com.esewa.restchangerequestapproval.requestChange.dto.CRFRequestDto;
import com.esewa.restchangerequestapproval.requestChange.dto.CRFResponseDto;
import com.esewa.restchangerequestapproval.requestChange.service.RequestService;
import com.esewa.restchangerequestapproval.shared.MessageConstant;
import com.esewa.restchangerequestapproval.shared.UserResponse;
import lombok.RequiredArgsConstructor;
import org.aspectj.bridge.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/form")
@RequiredArgsConstructor
public class RequestFormController {
    private final RequestService requestService;

    @GetMapping("/viewAllRequest")
    public List<CRFResponseDto> getAllRequest(){
        return requestService.getChangeRequest();
    }
    @GetMapping("/viewAllRequest/{field}")
    public List<CRFResponseDto> getAllRequestSortSevirity(@PathVariable String field){
        return requestService.getChangeRequestWithSortSevirity(field);
    }


    @PostMapping("/createRequest")
    public void CreateRequest(@RequestBody CRFRequestDto crfRequestDto){
        requestService.createChange(crfRequestDto);
    }

    @GetMapping("/viewRequest/{id}")
    public ResponseEntity<CRFResponseDto> viewRequestById(@PathVariable Integer id){
        CRFResponseDto crfResponseDto = requestService.getRequestById(id);
        return new ResponseEntity<>(crfResponseDto, HttpStatus.OK);
    }

    @PostMapping("/updateRequest/{id}")
    public UserResponse updateRequest(@PathVariable Integer id, @RequestBody CRFRequestDto crfRequestDto){
        requestService.updateRequestForm(id, crfRequestDto);
        return new UserResponse(MessageConstant.SAVED_SUCCESSFULLY);
    }




}
