package com.andrei.projectendava.services;

import java.util.List;
import java.util.Optional;

import com.andrei.projectendava.dao.EmployeeRepository;
import com.andrei.projectendava.dto.EmployeeProject;
import com.andrei.projectendava.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository empRepo;


    public Employee save(Employee employee) {
        return empRepo.save(employee);
    }


    public Iterable<Employee> getAll() {
        return empRepo.findAll();
    }


    public List<EmployeeProject> employeeProjects() {
        return empRepo.employeeProjects();
    }


    public Employee findByEmployeeId(long theId) {
        // TODO Auto-generated method stub
        return empRepo.findByEmployeeId(theId);
    }


    public void delete(Employee theEmp) {
        empRepo.delete(theEmp);

    }

}
