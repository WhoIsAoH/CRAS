package com.esewa.restchangerequestapproval.requestChange.entity;

import com.esewa.restchangerequestapproval.shared.Severity;
import com.esewa.restchangerequestapproval.shared.ProgressStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

@Getter
@Setter
@Entity
public class ChangeRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String topic;
    private String department;
    @JsonProperty("assign_to")
    private String assignTo;
    private String reviewer;
    @Enumerated(EnumType.STRING)
    private Severity severity;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("start_date")
    private Date startDate;
    @JsonProperty("end_date")
    private Date endDate;

    private String description;
    private String impact;

    @JsonProperty("roll_back")
    private String rollBack;

    //status
    @Value( value = "${some.key: PENDING}")
    private ProgressStatus status;

    @Value(value = "${some.key: false}")
    @JsonProperty("delete_status")
    private boolean deleteStatus;

}


    //if needed listed should be added (ask seniors)
    //Description part
//    private String software;
//    private String hardware;
//    private String application;
//    private String database;
//    private String security;
//    @JsonProperty("business_process")
//    private String businessProcess;
