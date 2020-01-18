package com.assignment.tasktracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TaskTrackerApplication {
	
	static final Logger logger = LoggerFactory.getLogger(TaskTrackerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TaskTrackerApplication.class, args);
		logger.info("-- Task Tracker Started --");
	}

}
