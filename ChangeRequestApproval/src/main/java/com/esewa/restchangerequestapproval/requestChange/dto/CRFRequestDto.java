package com.esewa.restchangerequestapproval.requestChange.dto;

import com.esewa.restchangerequestapproval.shared.Severity;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.Date;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties
public class CRFRequestDto{
    @NotNull(message = "topic is must required ")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]{2,100}$", message = "Topic must contain only letters, numbers, and spaces and be between 2 and 100 characters Integer")
    private String topic;
    private String department;

    @JsonAlias("author_id")
    private Integer author;

//    @JsonProperty
    private Severity severity;

    @JsonAlias("end_date")
    private Date endDate;
    private String description;
    @JsonAlias("roll_back")
    private String rollBack;
    private String impact;

    @JsonAlias("assign_to")
    private Integer assignTo;

    @JsonAlias("supervisor_id")
    private Integer supervisor;
}
