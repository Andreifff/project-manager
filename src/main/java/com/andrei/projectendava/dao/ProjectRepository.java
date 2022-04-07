package com.andrei.projectendava.dao;

import com.andrei.projectendava.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "projectsApi",path="projectsApi")
public interface ProjectRepository extends CrudRepository<Project, Long> {
    @Override
    public List<Project> findAll();

    String sqlQuery="SELECT stage as label, cOUNT(*) as value" +
            "FROM project" +
            "GROUP BY stage";


}
