package com.andrei.projectendava.api.controllers;

import com.andrei.projectendava.dao.EmployeeRepository;
import com.andrei.projectendava.dao.ProjectRepository;
import com.andrei.projectendava.entities.Employee;
import com.andrei.projectendava.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app-api/projects")
public class ProjectApiController {
    @Autowired
    ProjectRepository projectRepo;

    @GetMapping
    public Iterable<Project> getProject(){
        return projectRepo.findAll();
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable("id") Long id){
        return projectRepo.findById(id).get();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Project create(@RequestBody Project project){
        return projectRepo.save(project);

    }

    @PutMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Project update(@RequestBody Project project){
        return projectRepo.save(project);
    }

    @PatchMapping(path = "/{id}", consumes="application/json")
    public Project partialUpdate(@PathVariable("id") long id, @RequestBody Project patchEmployee){
        Project project=projectRepo.findById(id).get();

        if(patchEmployee.getName()!=null){
            project.setName(patchEmployee.getName());
        }
        if(patchEmployee.getStage()!=null){
            project.setStage(patchEmployee.getStage());
        }
        if(patchEmployee.getDescription()!=null){
            project.setDescription(patchEmployee.getDescription());
        }
        return projectRepo.save(project);
    }

    @DeleteMapping("/{id}")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        try {
            projectRepo.deleteById(id);
        }catch (EmptyResultDataAccessException e){

        }

    }

}
