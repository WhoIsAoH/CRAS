package com.esewa.restchangerequestapproval.department.repository;

import com.esewa.restchangerequestapproval.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
