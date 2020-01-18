package com.assignment.tasktracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.tasktracker.model.Task;

public interface TaskRepo extends JpaRepository<Task, String> {

}
