package com.esewa.restchangerequestapproval.requestChange.controller;

import com.esewa.restchangerequestapproval.requestChange.model.RequestDto;
import com.esewa.restchangerequestapproval.requestChange.model.ResponseDto;
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
    private List<ResponseDto> getAllRequest(){

        return requestService.getChangeRequest();
    }


    @PostMapping("/createRequest")
    private void CreteRequest(@RequestBody RequestDto requestDto){
        requestService.createChange(requestDto);
    }

    @GetMapping("/viewRequest/{id}")
    public ResponseEntity<ResponseDto> viewRequestById(@PathVariable Long id){
        ResponseDto responseDto = requestService.getRequestById(id);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PostMapping("/updateRequest/{id}")
    public void updateRequest(@PathVariable Long id, @RequestBody RequestDto requestDto){
//        return resp
        requestService.updateRequestForm(id, requestDto);
    }




}
