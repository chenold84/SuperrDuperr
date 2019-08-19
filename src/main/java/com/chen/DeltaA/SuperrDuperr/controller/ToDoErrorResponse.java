package com.chen.DeltaA.SuperrDuperr.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ToDoErrorResponse {
	private HttpStatus status;
    private List<String> message;
    private Long timeStamp;
    
    public ToDoErrorResponse() {}
    
	public ToDoErrorResponse(HttpStatus status, String message, Long timeStamp) {
		super();
		this.status = status;
		this.message = Arrays.asList(message);
		this.timeStamp = timeStamp;
	}
	
	public ToDoErrorResponse(HttpStatus status, List<String> message, Long timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public List<String> getMessage() {
		return message;
	}
	public void setMessage(List<String> message) {
		this.message = message;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
}
