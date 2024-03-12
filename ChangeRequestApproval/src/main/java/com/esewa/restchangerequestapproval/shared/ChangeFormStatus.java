package com.esewa.restchangerequestapproval.shared;

import com.esewa.restchangerequestapproval.requestChange.entity.ChangeRequest;
import com.esewa.restchangerequestapproval.requestChange.repo.RequestRepo;
import com.esewa.restchangerequestapproval.shared.MessageConstant;
import com.esewa.restchangerequestapproval.shared.ProgressStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ChangeFormStatus {
    private  final RequestRepo requestRepo;

    //changing status to pending
    public void changeStatusToPending(Integer id){
        ChangeRequest changeRequest = requestRepo.findById(id).orElseThrow(()-> new RuntimeException(MessageConstant.PRODUCT_NOT_FOUND));
        changeRequest.setStatus(ProgressStatus.PENDING);
        requestRepo.save(changeRequest);
    }

    //changing status to processing
    public void changeStatusToProcessing(Integer id){
        ChangeRequest changeRequest = requestRepo.findById(id).orElseThrow(()-> new RuntimeException(MessageConstant.PRODUCT_NOT_FOUND));
        changeRequest.setStatus(ProgressStatus.PROCESSING);
        requestRepo.save(changeRequest);
    }
    //changing status to complete
    public void changeStatusToComplete(Integer id){
        ChangeRequest changeRequest = requestRepo.findById(id).orElseThrow(()-> new RuntimeException(MessageConstant.PRODUCT_NOT_FOUND));
        changeRequest.setStatus(ProgressStatus.COMPLETED);
        requestRepo.save(changeRequest);
    }
    //changing status to deleted
    public void changeStatusToDeleted(Integer id){
        ChangeRequest changeRequest = requestRepo.findById(id).orElseThrow(()-> new RuntimeException(MessageConstant.PRODUCT_NOT_FOUND));
        changeRequest.setStatus(ProgressStatus.DELETED);
        requestRepo.save(changeRequest);
    }

}
