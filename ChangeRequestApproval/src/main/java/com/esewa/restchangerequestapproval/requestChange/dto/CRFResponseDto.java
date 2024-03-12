package com.esewa.restchangerequestapproval.requestChange.dto;

import com.esewa.restchangerequestapproval.security.entity.User;
import com.esewa.restchangerequestapproval.shared.ProgressStatus;
import com.esewa.restchangerequestapproval.shared.Severity;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
//@JsonIgnoreProperties
public class CRFResponseDto {
    private Integer id;


    @JsonIgnore
    private User author;
    private Integer authorId;


    private String topic;
    @NotNull
    private String department;
    @NotNull
    private Severity severity;
    @JsonAlias("start_date")
    private Date startDate;
    @JsonAlias("end_date")
    private Date endDate;

    private String description;
    private String impact;
    @JsonAlias("roll_back")
    private String rollBack;

    private ProgressStatus status;

    @JsonAlias("assign_to")
    private Integer assignTo;
    private Integer supervisor;
}
