package com.andrei.projectendava.controller;

import com.andrei.projectendava.dao.EmployeeRepository;
import com.andrei.projectendava.entities.Employee;
import com.andrei.projectendava.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository empRepo;

    @Autowired
    EmployeeService empService;

    @GetMapping
    public String displayEmployees(Model model){
        List<Employee> employees=empRepo.findAll();
        model.addAttribute("employees",employees);
        return "employees/list-employees";
    }

    @GetMapping("/new")
    public String displayEmployeeForm(Model model){
        Employee anEmployee=new Employee();
        //attributeName must have same name as in the .html file
        model.addAttribute("employee",anEmployee);
        return "employees/new-employee";
    }

    @PostMapping("/save")
    public String createEmployee(Model model, Employee employee){
        //save to db using employee crud repo
        empRepo.save(employee);
        //redirect to prevent duplicate submissions
        return "redirect:/employees/new";
    }

    @GetMapping("/update")
    public String displayEmployeeUpdateForm(@RequestParam("id") long id, Model model) {

        Employee employee = empService.findByEmployeeId(id);

        model.addAttribute("employee", employee);

        return "employees/new-employee";
    }

    @GetMapping("delete")
    public String deleteEmployee(@RequestParam("id") long id, Model model) {

        Employee employee = empService.findByEmployeeId(id);

        empService.delete(employee);

        return "redirect:/employees";
    }
}
