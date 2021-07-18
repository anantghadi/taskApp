package com.tasks.taskApp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Task implements Serializable {

	private static final long serialVersionUID = -8112861728039056306L;
	
	@ApiModelProperty(notes = "Id of the Task",name="id",required=true,value="ID")
	@Id
	@GeneratedValue
	private Long id;
	
	@ApiModelProperty(notes = "Title of the Task",name="title",required=true,value="Title")
	@NotNull
	private String title;
	
	@ApiModelProperty(notes = "Description of the Task",name="description",required=true,value="Description")
	@NotNull
	private String Description;
	
	@ApiModelProperty(notes = "Creation Date of the Task",name="creationDate",value="Creation Date")
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	
	@ApiModelProperty(notes = "Start Date of the Task",name="startDate",value="Start Date")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@ApiModelProperty(notes = "End Date of the Task",name="endDate",value="End Date")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@ApiModelProperty(notes = "Status of the Task",name="completed",value="Completed")
	private boolean completed;

	@PrePersist
	private void init() {
		this.creationDate = new Date();
	}

	public Task(String title, String description) {
		super();
		this.title = title;
		this.Description = description;
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
}
