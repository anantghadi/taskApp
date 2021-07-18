package com.tasks.taskApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasks.taskApp.model.Task;
import com.tasks.taskApp.service.ITaskService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "TaskRestController", description = "REST Apis related to Tasks Entity!!!!")
@RequestMapping("/tasks")
@RestController
public class TaskRestController {
	
	@Autowired
	public ITaskService taskService;
	
	@ApiOperation(value = "Get list of Tasks in the System ", response = Iterable.class, tags = "Get All Tasks")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"), 
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
	public List<Task> tasks(){
		return taskService.getAll();
	}
	
	@ApiOperation(value = "Get specific Task By Id in the System ", response = Task.class, tags = "Get Task By Id")
	@GetMapping("/{id}")
	public Task task(@PathVariable("id") Long id){
		return taskService.getOneById(id);
	}
	
	@ApiOperation(value = "Set specific Task the System ", response = Task.class, tags = "Create Task")
	@PostMapping
	public Task save(@RequestBody Task task){
		return taskService.saveTask(task);
	}
	
	@ApiOperation(value = "Update specific Task in the System ", response = Task.class, tags = "Update Task")
	@PutMapping
	public Task put(@RequestBody Task task){
		return taskService.updateTask(task);
	}
	
	@ApiOperation(value = "Delete specific Task By Id in the System ", response = Task.class, tags = "Delete Task")
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id){
		taskService.deleteTask(id);
	}
}
