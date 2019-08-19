package com.chen.DeltaA.SuperrDuperr.service;

import java.util.List;

import javax.validation.Valid;

import com.chen.DeltaA.SuperrDuperr.model.Reminder;
import com.chen.DeltaA.SuperrDuperr.model.Tag;
import com.chen.DeltaA.SuperrDuperr.model.ToDoItem;
import com.chen.DeltaA.SuperrDuperr.model.ToDoList;

public interface ToDoListService {
	
	public ToDoList getToDoList(Long id);
	public ToDoList saveToDoList(ToDoList toDoList);
	public ToDoItem saveToDoItem(Long listId, ToDoItem item);
	public ToDoItem getItem(Long listId);
	public ToDoItem saveTags(Long listId, List<Tag> item);
	public ToDoItem markItemAsCompleted(Long itemId);
	public Reminder saveReminder(Long itemId, @Valid Reminder reminder);
	public void deleteToDoItem(Long itemId);
}
