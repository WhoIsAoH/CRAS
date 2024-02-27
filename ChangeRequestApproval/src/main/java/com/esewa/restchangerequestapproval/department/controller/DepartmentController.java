package com.esewa.restchangerequestapproval.department.controller;

import com.esewa.restchangerequestapproval.department.entity.Department;
import com.esewa.restchangerequestapproval.department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping("/department")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/")
    public List<Department> fetchDepartment(){
        return departmentService.fetchDepartment();
    }

    @PutMapping("/department/{id}")
        public Department updateDepartment(@PathVariable("id") int id,
                                           @RequestBody Department department)
    {
        return departmentService.updateDepartment(id,department);
    }

}
