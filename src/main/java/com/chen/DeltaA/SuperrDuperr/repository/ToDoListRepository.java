package com.chen.DeltaA.SuperrDuperr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chen.DeltaA.SuperrDuperr.model.ToDoList;

@Repository
public interface ToDoListRepository extends CrudRepository<ToDoList, Long> {

}
