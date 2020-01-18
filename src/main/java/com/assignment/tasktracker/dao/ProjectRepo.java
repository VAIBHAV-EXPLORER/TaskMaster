package com.assignment.tasktracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.tasktracker.model.Project;

public interface ProjectRepo extends JpaRepository<Project, String> {

}
