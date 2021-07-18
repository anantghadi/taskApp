package com.tasks.taskApp.service;

import java.util.List;

import com.tasks.taskApp.model.Task;

public interface ITaskService {
	public Task getOneById(Long id);

	public List<Task> getAll();

	public List<Task> getAllByTitle(String title);

	public Task saveTask(Task task);

	public Task updateTask(Task task);

	public void deleteTask(Long id);
}
