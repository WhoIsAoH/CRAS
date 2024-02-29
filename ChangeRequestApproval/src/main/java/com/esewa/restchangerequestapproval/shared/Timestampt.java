package com.esewa.restchangerequestapproval.shared;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.print.attribute.standard.DateTimeAtCreation;

@Data

public abstract class Timestampt {

    @CreationTimestamp
    private DateTimeAtCreation dateTimeAtCreation;

    @UpdateTimestamp
    private UpdateTimestamp updateTimestamp;
}
