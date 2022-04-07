package com.andrei.projectendava.services;

import java.util.List;

import com.andrei.projectendava.dao.ProjectRepository;
import com.andrei.projectendava.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProjectService {

    @Autowired
    ProjectRepository proRepo;


    public Project save(Project project) {
        return proRepo.save(project);
    }


    public List<Project> getAll() {
        return proRepo.findAll();
    }


}