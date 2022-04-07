package com.andrei.projectendava;

import com.andrei.projectendava.dao.EmployeeRepository;
import com.andrei.projectendava.dao.ProjectRepository;
import com.andrei.projectendava.entities.Employee;
import com.andrei.projectendava.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ProjectEndavaApplication {

    @Autowired
    EmployeeRepository empRepo;

    @Autowired
    ProjectRepository projRepo;

    public static void main(String[] args) {
        SpringApplication.run(ProjectEndavaApplication.class, args);
    }

}
