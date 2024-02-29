package com.esewa.restchangerequestapproval.requestChange.model;

import com.esewa.restchangerequestapproval.shared.Severity;
import com.esewa.restchangerequestapproval.shared.ProgressStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

@Getter
@Setter
public class ResponseDto {
     private String topic;
    @NotNull
    private String department;
    @JsonProperty("assign_to")
    private String assignTo;
    private String reviewer;
    @NotNull
    private Severity severity;
    @JsonProperty("start_date")
    private Date startDate;
    @JsonProperty("end_date")
    private Date endDate;

    private String description;
    private String impact;
    @JsonProperty("roll_back")
    private String rollBack;

    private ProgressStatus status;
}
