package com.esewa.restchangerequestapproval.requestChange.controller;

import com.esewa.restchangerequestapproval.requestChange.entity.ChangeRequest;
import com.esewa.restchangerequestapproval.requestChange.model.RequestDto;
import com.esewa.restchangerequestapproval.requestChange.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/form")
@RequiredArgsConstructor
public class Controller {
    private final RequestService requestService;

    @GetMapping("/viewAllRequest")
    private List<RequestDto> getAllRequest(){
        return requestService.getChangeRequest();
    }

//only for test - this will be remove tomorrow
    @PostMapping("/createRequest")
    private String CreteRequest(@RequestBody ChangeRequest changeRequest){
        requestService.createRequest(changeRequest);
        return "created successfully";
    }

}
