package com.andrei.projectendava.controller;

import com.andrei.projectendava.dao.EmployeeRepository;
import com.andrei.projectendava.dao.ProjectRepository;
import com.andrei.projectendava.dto.EmployeeProject;
import com.andrei.projectendava.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {



    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository empRepo;


    @GetMapping(value={"/","/home"})
    public String displayHome(Model model){



        List<Project> projects=proRepo.findAll();
        model.addAttribute("projectsList",projects);

        List<EmployeeProject> employeesProjectCnt = empRepo.employeeProjects();
        model.addAttribute("employeesListProjectsCnt", employeesProjectCnt);


        return "main/home";
    }
}
