package com.esewa.restchangerequestapproval.requestChange.controller;

import com.esewa.restchangerequestapproval.requestChange.model.CRFRequestDto;
import com.esewa.restchangerequestapproval.requestChange.model.CRFResponseDto;
import com.esewa.restchangerequestapproval.requestChange.service.RequestService;
import lombok.RequiredArgsConstructor;
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


    @PostMapping("/createRequest")
    public void CreateRequest(@RequestBody CRFRequestDto crfRequestDto){
        requestService.createChange(crfRequestDto);
    }

    @GetMapping("/viewRequest/{id}")
    public ResponseEntity<CRFResponseDto> viewRequestById(@PathVariable Long id){
        CRFResponseDto crfResponseDto = requestService.getRequestById(id);
        return new ResponseEntity<>(crfResponseDto, HttpStatus.OK);
    }

    @PostMapping("/updateRequest/{id}")
    public void updateRequest(@PathVariable Long id, @RequestBody CRFRequestDto crfRequestDto){
        requestService.updateRequestForm(id, crfRequestDto);
    }




}
