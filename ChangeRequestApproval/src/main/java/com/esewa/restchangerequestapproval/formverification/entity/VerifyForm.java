package com.esewa.restchangerequestapproval.formverification.entity;

import com.esewa.restchangerequestapproval.requestChange.entity.ChangeRequest;
import com.esewa.restchangerequestapproval.security.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VerifyForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private ChangeRequest form;

    private String comment;

    @ManyToOne
    private User user;


}
