package com.esewa.restchangerequestapproval.requestChange.entity;

import com.esewa.restchangerequestapproval.security.user.User;
import com.esewa.restchangerequestapproval.shared.Severity;
import com.esewa.restchangerequestapproval.shared.ProgressStatus;
import com.esewa.restchangerequestapproval.shared.Timestampt;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.auditing.CurrentDateTimeProvider;

import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChangeRequest extends Timestampt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //this need to be mapped after the creation of user-info-DTO
//    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "teacher_id",referencedColumnName = "teacherId")
//    private User user;
    private String topic;
    private String department;
    private String assignTo;
    private String reviewer;
    @Enumerated(EnumType.STRING)
    private Severity severity;
    @Column(updatable = false)
    private Date startDate= Calendar.getInstance().getTime();;
    private Date endDate;

    private String description;
    private String impact;

    private String rollBack;

    //status
    @Enumerated(EnumType.STRING)
    private ProgressStatus status= ProgressStatus.PENDING;


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
