package com.esewa.restchangerequestapproval.requestChange.model;

import com.esewa.restchangerequestapproval.shared.ProgressStatus;
import com.esewa.restchangerequestapproval.shared.Severity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {
    @NotNull(message = "topic is must required ")
    @Size(min=2, max = 100, message = "Specific topic only")
    private String topic;

    private String department;
    @JsonProperty("assign_to")
    private String assignTo;
    private String reviewer;
    private Severity severity;

    @JsonIgnore
    private Date startDate;

    @JsonProperty("end_date")
    private Date endDate;
    private String description;
    private String impact;
    @JsonProperty("roll_back")
    private String rollBack;

    @JsonIgnore
    private ProgressStatus status;

}
