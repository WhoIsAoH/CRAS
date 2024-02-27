package com.esewa.restchangerequestapproval.department.service;

import com.esewa.restchangerequestapproval.department.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

   public List<Department> fetchDepartment();

   public  Department updateDepartment(int id, Department department);
}
