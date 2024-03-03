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

    private String topic;
    private String department;
    private String assignTo;
    private String reviewer;
    @Enumerated(EnumType.STRING)
    private Severity severity;
    @Column(updatable = false)
    private Date startDate;;
    private Date endDate;

    private String description;
    private String impact;

    private String rollBack;

    //status
    @Enumerated(EnumType.STRING)
    private ProgressStatus status= ProgressStatus.PENDING;


}
