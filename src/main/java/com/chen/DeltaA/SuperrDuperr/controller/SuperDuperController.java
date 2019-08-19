package com.chen.DeltaA.SuperrDuperr.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.chen.DeltaA.SuperrDuperr.model.Reminder;
import com.chen.DeltaA.SuperrDuperr.model.Tag;
import com.chen.DeltaA.SuperrDuperr.model.ToDoItem;
import com.chen.DeltaA.SuperrDuperr.model.ToDoList;
import com.chen.DeltaA.SuperrDuperr.service.ToDoListService;

@RestController
@RequestMapping("/api/v1/todolist")
public class SuperDuperController {
	
	private ToDoListService toDoListService;

	public SuperDuperController(ToDoListService toDoListService) {
		this.toDoListService = toDoListService;
	}

	@GetMapping("/lists/{listId}")
	public ResponseEntity<ToDoList>getAllItems(@PathVariable Long listId){
		return new ResponseEntity<ToDoList>(toDoListService.getToDoList(listId), HttpStatus.OK);
	}
	
	@PostMapping("/lists")
	public ResponseEntity<ToDoList>createToDoList(@RequestBody @Valid ToDoList toDoList){
		return new ResponseEntity<ToDoList>(toDoListService.saveToDoList(toDoList), HttpStatus.CREATED);
	}
	
	@PostMapping("/lists/{listId}/items")
	public ResponseEntity<ToDoItem>createToDoItem(@PathVariable Long listId, @RequestBody @Valid ToDoItem toDoItem){
		return new ResponseEntity<ToDoItem>(toDoListService.saveToDoItem(listId, toDoItem), HttpStatus.CREATED);
	}
	
	@GetMapping("/items/{itemId}")
	public ResponseEntity<ToDoItem>getItem(@PathVariable Long itemId){
		return new ResponseEntity<ToDoItem>(toDoListService.getItem(itemId), HttpStatus.OK);
	}
	
	@PutMapping("/items/{itemId}")
	public ResponseEntity<ToDoItem>markItemAsCompleted(@PathVariable Long itemId){
		return new ResponseEntity<ToDoItem>(toDoListService.markItemAsCompleted(itemId), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/items/{itemId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteToDoItem(@PathVariable Long itemId){
		toDoListService.deleteToDoItem(itemId);
	}
	
	@PostMapping("/items/{itemId}/tags")
	public ResponseEntity<ToDoItem>tagToDoItem(@PathVariable Long itemId,
			@RequestBody @Valid List<Tag> tags){
		return new ResponseEntity<ToDoItem>(toDoListService.saveTags(itemId, tags), HttpStatus.CREATED);
	}
	
	@PostMapping("/items/{itemId}/reminder")
	public ResponseEntity<Reminder>tagToDoItem(@PathVariable Long itemId,
			@RequestBody @Valid Reminder reminder){
		return new ResponseEntity<Reminder>(toDoListService.saveReminder(itemId, reminder), HttpStatus.CREATED);
	}
	
}
