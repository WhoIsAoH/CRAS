package com.esewa.restchangerequestapproval.requestChange.repo;

import com.esewa.restchangerequestapproval.requestChange.entity.ChangeRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepo extends JpaRepository<ChangeRequest, Long> {
}
