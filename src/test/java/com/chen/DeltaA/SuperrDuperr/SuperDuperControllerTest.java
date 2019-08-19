package com.chen.DeltaA.SuperrDuperr;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.chen.DeltaA.SuperrDuperr.controller.SuperDuperController;
import com.chen.DeltaA.SuperrDuperr.model.ToDoList;
import com.chen.DeltaA.SuperrDuperr.service.ToDoListService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(SuperDuperController.class)
public class SuperDuperControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@MockBean
	ToDoListService toDoListService;
	
	/*
	 * @BeforeClass public static void setUpBeforeClass() throws Exception { }
	 * 
	 * @Before public void setUp() throws Exception { }
	 */

	@Test
	public void testSuperDuperController() throws Exception {
		ToDoList toDoList = new ToDoList("First List");
		toDoList.setId(1L);
		when(toDoListService.getToDoList(1L)).thenReturn(toDoList);
		
		mockMvc.perform(get("/api/v1/todolist/lists/1")).andExpect(status().isOk());
		
		verify(toDoListService, times(1)).getToDoList(1L);
	}

	@Test
	public void testGetAllItems() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateToDoList() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateToDoItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testMarkItemAsCompleted() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteToDoItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testTagToDoItemLongListOfTag() {
		fail("Not yet implemented");
	}

	@Test
	public void testTagToDoItemLongReminder() {
		fail("Not yet implemented");
	}

	@Test
	public void testEquals() {
		fail("Not yet implemented");
	}

	@Test
	public void testClone() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotify() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotifyAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLongInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testWait() {
		fail("Not yet implemented");
	}

	@Test
	public void testFinalize() {
		fail("Not yet implemented");
	}

}
