package com.assignment.tasktracker.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.tasktracker.dao.ProjectRepo;
import com.assignment.tasktracker.model.Project;
import com.assignment.tasktracker.utility.ApplicationUtility;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	ProjectRepo projectRepo;

	@GetMapping("/all")
	public List<Project> getAllProjects() {

		return projectRepo.findAll();

	}

	@GetMapping("/{id}")
	public Project getProjectById(@PathVariable(name = "id") String id) {
		return projectRepo.getOne(id);
	}

	@PostMapping("/add")
	public Map<String, String> addProject(@RequestBody Project project) {
		project.setProjectid(ApplicationUtility.getRandomId());
		HashMap<String, String> map = new HashMap<>();
		map.put("Status", "Success");
		map.put("Message", "Project Added with ID : " + project.getProjectid());
		projectRepo.save(project);

		return map;

	}

	@DeleteMapping("/delete/{id}")
	public String deleteProject(@PathVariable(name = "id") String id) {
		projectRepo.deleteById(id);
		return "Project Deleted with ID : " + id;
	}

}
