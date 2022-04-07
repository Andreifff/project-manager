package com.andrei.projectendava.controller;

import com.andrei.projectendava.dao.EmployeeRepository;
import com.andrei.projectendava.dao.ProjectRepository;
import com.andrei.projectendava.entities.Employee;
import com.andrei.projectendava.entities.Project;
import com.andrei.projectendava.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository empRepo;

    @Autowired
    ProjectService projectService;


    @GetMapping
    public String displayProjects(Model model){
        List<Project> projects=proRepo.findAll();
        model.addAttribute("projects",projects);
        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model){
        Project aProject=new Project();

        List<Employee> employees= empRepo.findAll();

        //attributeName must have same name as in the .html file
        model.addAttribute("project",aProject);
        model.addAttribute("allEmployees",employees);
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model){
        //this will handle the saving to the DB
        proRepo.save(project);

        //redirect to prevent duplicate submissions
        return "redirect:/projects";
    }


}
