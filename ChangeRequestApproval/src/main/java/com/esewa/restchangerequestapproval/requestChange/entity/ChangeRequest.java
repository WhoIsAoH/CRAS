package com.esewa.restchangerequestapproval.requestChange.entity;

import com.esewa.restchangerequestapproval.security.entity.User;
import com.esewa.restchangerequestapproval.shared.ProgressStatus;
import com.esewa.restchangerequestapproval.shared.Severity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChangeRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //many to one mapping
    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="author_id")
    private User author;

    private String topic;
    private String department;
    @Enumerated(EnumType.STRING)
    private Severity severity;
    @Column(updatable = false)
    private Date startDate;
    private Date endDate;

    private String description;
    private String impact;

    private String rollBack;

    //status
    @Enumerated(EnumType.STRING)
    private ProgressStatus status= ProgressStatus.PENDING;

    @ManyToOne
    private User assignTo;
    @ManyToOne
    private User supervisor;
}
