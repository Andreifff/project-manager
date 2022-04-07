package com.andrei.projectendava;

import com.andrei.projectendava.dao.ProjectRepository;
import com.andrei.projectendava.entities.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProjectEndavaApplicationTests {

    @Autowired
    ProjectRepository proRepo;



    @Test
    public void ifNewProjectSaved_thenSuccess() {
        Project newProject = new Project("New Test Project", "COMPLETE", "Test Description");
        proRepo.save(newProject);

        //id has to be +1 of the last created project id
        //will run because LocalDate doesn't have @notnull
        assertEquals(5, proRepo.findAll().size());

    }

}
