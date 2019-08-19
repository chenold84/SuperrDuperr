package com.chen.DeltaA.SuperrDuperr.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.chen.DeltaA.SuperrDuperr.controller.RecordNotFoundException;
import com.chen.DeltaA.SuperrDuperr.model.Reminder;
import com.chen.DeltaA.SuperrDuperr.model.Tag;
import com.chen.DeltaA.SuperrDuperr.model.ToDoItem;
import com.chen.DeltaA.SuperrDuperr.model.ToDoList;
import com.chen.DeltaA.SuperrDuperr.repository.ToDoItemRepository;
import com.chen.DeltaA.SuperrDuperr.repository.ToDoListRepository;
import com.chen.DeltaA.SuperrDuperr.repository.ToDoReminderRepository;

@Service
public class ToDoListServiceImpl implements ToDoListService {
	
	private ToDoListRepository toDoListOp;
	private ToDoItemRepository toDoItemOp;
	private ToDoReminderRepository toDoReminderOp;
	
	public ToDoListServiceImpl(ToDoListRepository toDoListOp,
			ToDoItemRepository toDoItemOp,
			ToDoReminderRepository toDoReminderOp) {
		this.toDoListOp = toDoListOp;
		this.toDoItemOp = toDoItemOp;
		this.toDoReminderOp = toDoReminderOp;
	}

	@Override
	public ToDoList getToDoList(Long id) {
		ToDoList toDoList = null;
		
		Optional<ToDoList> list = toDoListOp.findById(id);
		if(list.isPresent()) {
			toDoList = list.get();
		}else {
			throw new RecordNotFoundException("Invalid List ID");
		}
		
		return toDoList;
	}

	@Override
	public ToDoList saveToDoList(ToDoList toDoList) {
		return toDoListOp.save(toDoList);
	}


	@Override
	public ToDoItem saveToDoItem(Long listId, ToDoItem item) {
		ToDoList toDoList = null;
		Optional<ToDoList> list = toDoListOp.findById(listId);
		if(list.isPresent()) {
			toDoList = list.get();
			item.setToDoList(toDoList);
			toDoItemOp.save(item);
		}else {
			throw new RecordNotFoundException("Invalid List ID");
		}
		return item;
	}

	@Override
	public ToDoItem saveTags(Long itemId, List<Tag> tags) {
		ToDoItem toDoItem = null;
		Optional<ToDoItem> item = toDoItemOp.findById(itemId);
		if(item.isPresent()) {
			toDoItem = item.get();
			toDoItem.setTags(tags);
			toDoItemOp.save(toDoItem);
			
		}else {
			throw new RecordNotFoundException("Invalid Item ID");
		}
		return toDoItem;
	}

	@Override
	public ToDoItem getItem(Long itemId) {
		ToDoItem toDoItem = null;
		Optional<ToDoItem> item = toDoItemOp.findById(itemId);
		if(item.isPresent()) {
			toDoItem = item.get();
		}else {
			throw new RecordNotFoundException("Invalid Item ID");
		}
		return toDoItem;
	}

	@Override
	public ToDoItem markItemAsCompleted(Long itemId) {
		ToDoItem toDoItem = null;
		Optional<ToDoItem> item = toDoItemOp.findById(itemId);
		if(item.isPresent()) {
			toDoItem = item.get();
			toDoItem.setCompleted(true);
			toDoItemOp.save(toDoItem);
		}else {
			throw new RecordNotFoundException("Invalid Item ID");
		}
		return toDoItem;
	}

	@Override
	public Reminder saveReminder(Long itemId, @Valid Reminder reminder) {
		ToDoItem toDoItem = null;
		Optional<ToDoItem> item = toDoItemOp.findById(itemId);
		if(item.isPresent()) {
			toDoItem = item.get();
			reminder.setToDoItem(toDoItem);
			toDoReminderOp.save(reminder);
			
		}else {
			throw new RecordNotFoundException("Invalid Item ID");
		}
		return reminder;
	}

	@Override
	public void deleteToDoItem(Long itemId) {
		toDoItemOp.deleteById(itemId);
	}
	
}