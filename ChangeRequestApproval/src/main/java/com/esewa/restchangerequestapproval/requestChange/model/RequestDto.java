package com.esewa.restchangerequestapproval.requestChange.model;

import com.esewa.restchangerequestapproval.shared.Severity;
import com.esewa.restchangerequestapproval.shared.ProgressStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RequestDto {
    private String topic;
    private String department;
    private String assignTo;
    private String reviewer;
    private Severity severity;
    private Date endDate;
    private String description;
    private String impact;
    private String rollBack;
    private ProgressStatus status;
    private boolean deleteStatus;
}
