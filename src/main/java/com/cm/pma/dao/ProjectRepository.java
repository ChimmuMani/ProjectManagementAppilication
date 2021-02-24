package com.cm.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cm.pma.entities.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long>{
@Override
List<Project> findAll();

}
