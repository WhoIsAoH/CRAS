package com.esewa.restchangerequestapproval.formverification.controller;

import com.esewa.restchangerequestapproval.formverification.dto.VerifyRequestDto;
import com.esewa.restchangerequestapproval.formverification.dto.VerifyResponseDto;
import com.esewa.restchangerequestapproval.formverification.service.FormVerifyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/verify")
public class FormVerifyController {

    private final FormVerifyService formVerifyService;

    public FormVerifyController(FormVerifyService formVerifyService) {
        this.formVerifyService = formVerifyService;
    }


    @PostMapping("/add")
    public void createVerifyForm(@RequestBody VerifyRequestDto verifyRequestDto){
        formVerifyService.createVerifyForm(verifyRequestDto);
    }

    @PostMapping("/view")
    public List<VerifyResponseDto> viewVerifyForm(){
        return formVerifyService.viewAllVerification();
    }
}

