package com.chen.DeltaA.SuperrDuperr.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Reminder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Future
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private LocalDateTime  remindOn;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="to_do_item_id", nullable = false)
	@JsonIgnoreProperties("reminder")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private ToDoItem toDoItem;

	public Reminder() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getRemindOn() {
		return remindOn;
	}

	public void setRemindOn(LocalDateTime remindOn) {
		this.remindOn = remindOn;
	}

	public ToDoItem getToDoItem() {
		return toDoItem;
	}

	public void setToDoItem(ToDoItem toDoItem) {
		this.toDoItem = toDoItem;
	}
	
}
