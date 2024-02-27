package com.esewa.restchangerequestapproval.department.service;

import com.esewa.restchangerequestapproval.department.entity.Department;
import com.esewa.restchangerequestapproval.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service

public class DepartmentServiceImple implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department updateDepartment(int id, Department department) {
        Department dep=departmentRepository.findById(id).get();

        if(Objects.nonNull(department.getName())&&!"".equalsIgnoreCase(department.getName())){
            dep.setName(department.getName());
        }

        if(Objects.nonNull(department.getAddress())&&!"".equalsIgnoreCase(department.getAddress())){
            dep.setName(department.getAddress());
        }
        return departmentRepository.save(dep);
    }
}
