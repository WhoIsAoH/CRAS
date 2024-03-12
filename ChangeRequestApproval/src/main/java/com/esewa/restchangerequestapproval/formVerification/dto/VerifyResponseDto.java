package com.esewa.restchangerequestapproval.formVerification.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VerifyResponseDto {
    private Integer id;
    private String comment;

    @JsonAlias("form_id")
    private Integer formId;

    @JsonAlias("user_id")
    private Integer userId;
}
