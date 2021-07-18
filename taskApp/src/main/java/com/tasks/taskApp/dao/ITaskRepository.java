package com.tasks.taskApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasks.taskApp.model.Task;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Long> {

	public List<Task> findByTitleLike(String title);

}
