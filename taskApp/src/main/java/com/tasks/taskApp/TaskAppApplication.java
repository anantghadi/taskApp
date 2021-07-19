package com.tasks.taskApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.tasks.taskApp.model.Task;
import com.tasks.taskApp.service.ITaskService;

@ComponentScan
@SpringBootApplication
public class TaskAppApplication implements CommandLineRunner{
	
	@Autowired
	private ITaskService taskService;
	
	public static void main(String[] args) {
		SpringApplication.run(TaskAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 1; i <= 5; i++) {
			taskService.saveTask(new Task("title " + i, "description " + i));
		}
	}
}
