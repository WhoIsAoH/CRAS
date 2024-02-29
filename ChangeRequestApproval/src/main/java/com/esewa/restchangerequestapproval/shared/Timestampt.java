package com.esewa.restchangerequestapproval.shared;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.print.attribute.standard.DateTimeAtCreation;

@Data

public abstract class Timestampt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private DateTimeAtCreation dateTimeAtCreation;

    @UpdateTimestamp
    private UpdateTimestamp updateTimestamp;
}
