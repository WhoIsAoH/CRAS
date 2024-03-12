package com.esewa.restchangerequestapproval.formverification.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VerifyRequestDto {
    private String comment;

    @JsonAlias("form_id")
    private Integer formId;

    @JsonAlias("user_id")
    private Integer userId;
}
