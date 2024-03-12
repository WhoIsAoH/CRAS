package com.esewa.restchangerequestapproval.shared;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
//@MappedSuperclass
public abstract class Timestampt {



    @CreationTimestamp
    private LocalDateTime dateTimeAtCreation;

    @UpdateTimestamp
    private LocalDateTime updateTimestamp;


}
