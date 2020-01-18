package com.assignment.tasktracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.tasktracker.dao.TaskRepo;
import com.assignment.tasktracker.model.Task;
import com.assignment.tasktracker.utility.ApplicationUtility;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	TaskRepo taskRepo;

	@GetMapping("/all")
	public List<Task> getAllTasks() {
		return taskRepo.findAll();
	}

	@GetMapping("/{id}")
	public Task getTaskById(@PathVariable String id) {
		return taskRepo.getOne(id);
	}

	@PostMapping("/add")
	public String addTask(@RequestBody Task task) {
		task.setTaskid(ApplicationUtility.getRandomId());
		taskRepo.save(task);
		return "Task Added Successfully with ID :" + task.getTaskid();
	}

	@DeleteMapping("/delete/{id}")
	public String deleteTask(@PathVariable(name = "id") String id) {
		taskRepo.deleteById(id);
		return "Task Deleted Successfully with ID : " + id;
	}

}
