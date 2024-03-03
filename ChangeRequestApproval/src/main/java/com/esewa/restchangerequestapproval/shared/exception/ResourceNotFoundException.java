package com.esewa.restchangerequestapproval.shared.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{

        String resourceName;
        String fieldName;
        long fieldValue;
        public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue){
            super();
            this.resourceName=resourceName;
            this.fieldName = fieldName;
            this.fieldValue = fieldValue;
        }


}