package com.tasks.taskApp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasks.taskApp.dao.ITaskRepository;
import com.tasks.taskApp.model.Task;

@Service
@Transactional
public class TaskServiceImpl implements ITaskService{
	
	@Autowired
	private ITaskRepository taskRepository;
	
	@Override
	public Task getOneById(Long id) {
		return taskRepository.getOne(id);
	}

	@Override
	public List<Task> getAll() {
		return taskRepository.findAll();
	}

	@Override
	public List<Task> getAllByTitle(String title) {
		return taskRepository.findByTitleLike(title);
	}

	@Override
	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public Task updateTask(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public void deleteTask(Long id) {
		Task task = this.getOneById(id);
		taskRepository.delete(task);;
	}

	
		
}
