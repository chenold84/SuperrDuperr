package com.chen.DeltaA.SuperrDuperr.bootstrap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.chen.DeltaA.SuperrDuperr.model.Tag;
import com.chen.DeltaA.SuperrDuperr.model.ToDoItem;
import com.chen.DeltaA.SuperrDuperr.model.ToDoList;
import com.chen.DeltaA.SuperrDuperr.repository.ToDoItemRepository;
import com.chen.DeltaA.SuperrDuperr.repository.ToDoListRepository;

@Component
public class BootStrap implements CommandLineRunner {

	private ToDoListRepository toDoListOp;
	private ToDoItemRepository toDoItemOp;

	public BootStrap(ToDoListRepository toDoListOp, ToDoItemRepository toDoItemOp) {
		this.toDoListOp = toDoListOp;
		this.toDoItemOp = toDoItemOp;
	}

	@Override
	public void run(String... args) throws Exception {
		ToDoList newList = new ToDoList("First list");
		toDoListOp.save(newList);

		ToDoItem newItem = new ToDoItem("First Item", false);
		newItem.setToDoList(newList);
		toDoItemOp.save(newItem);

		List<Tag> tags = new ArrayList<>();
		tags.add(new Tag("Tag 1"));
		tags.add(new Tag("Tag 2"));
		newItem.setTags(tags);
		toDoItemOp.save(newItem);
		 
	}

}
