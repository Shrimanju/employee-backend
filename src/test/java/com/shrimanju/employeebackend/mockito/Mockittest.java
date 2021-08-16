package com.shrimanju.employeebackend.mockito;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shrimanju.employeebackend.model.Employee;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.shrimanju.employeebackend.service.EmployeeService;
import com.sun.el.stream.Optional;
import com.shrimanju.employeebackend.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest

public class Mockittest {
	  @Autowired
	  private WebApplicationContext webApplicationContext;
	  private MockMvc mockMvc;
	
	@Autowired
	ObjectMapper mapper;
	
	@Autowired
	private EmployeeService employeeServicee;

	@MockBean
	private EmployeeRepository employeeRepository;

	Employee RECORD_1 = new Employee("Rayven Yor", "Rayven Yor", "Cebu Philippines", 2365);
	Employee RECORD_2 = new Employee("Rayven Yor", "Rayven Yor", "Cebu Philippines", 2365);
	Employee RECORD_3 = new Employee("Rayven Yor", "Rayven Yor", "Cebu Philippines", 2365);

	@Test
	public void getAllRecords_success() throws Exception {
		List<Employee> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));

		Mockito.when(employeeRepository.findAll()).thenReturn(records);

//		mockMvc.perform(MockMvcRequestBuilders.get("/employees").contentType(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk());
//                .andExpect(jsonPath("$", hasSize(3)))
//                .andExpect(jsonPath("$[2].name", is("Jane Doe")));
	}

//	@Test
//	public void GetAllEmp() {
//		when(employeeRepository.findAll()).thenReturn(Stream
//				.of(new Employee("Rayven Yor", "Rayven Yor", "Cebu Philippines", 2365),
//						new Employee("Rayven Yorqw", "Rayven Yowqr", "Cebu Philiwqppines", 23615))
//				.collect(Collectors.toList()));
//		assertEquals(2, employeeServicee.getAllEmployees().size());
////		  List<Employee> records = new ArrayList<>(Arrays.asList(RECORD_1,RECORD_2,RECORD_3));
////		  Mockito.when(employeeService.getAllEmployees()).thenReturn((List<Employee>) records);
////		  mockMvc.perform(MockMvcRequestBuilders.get("/employees")
////		           );
////							
//
//	}
//
//	public void GetSingleEmpName() {
////		long id=12;
////		String name="shrimanju";
////		 when(employeeRepository.findById(id)).thenReturn(Stream.of(new Employee("Rayven Yor","Rayven Yor", "Cebu Philippines", 2365)
////				 ).collect(Collectors.toList()));
////		 assertEquals(2,employeeServicee.getEmployeeById(id));
////		  List<Employee> records = new ArrayList<>(Arrays.asList(RECORD_1,RECORD_2,RECORD_3));
////		  Mockito.when(employeeService.getAllEmployees()).thenReturn((List<Employee>) records);
////		  mockMvc.perform(MockMvcRequestBuilders.get("/employees")
////		           );
//	}
//
//	@Test
//	public void Createnew() {
//		Employee RECORD_1 = new Employee("Rayven Yor", "Rayven Yor", "Cebu Philippines", 2365);
//		Employee RECORD_2 = new Employee("Rayven Yor", "Rayven Yor", "Cebu Philippines", 2365);
//		Employee RECORD_3 = new Employee("Rayven Yor", "Rayven Yor", "Cebu Philippines", 2365);
////		    List<Employee> entity = new ArrayList<>(Arrays.asList(RECORD_1,RECORD_2,RECORD_3));
//		when(employeeRepository.save(RECORD_3)).thenReturn(RECORD_3);
//		assertEquals(RECORD_3, employeeServicee.createEmployee(RECORD_3));
////		    assertEquals(entity,employeeServicee.createEmployee(entity));
//	}
//
//	@Test
//	public void deletetest() {
//		Employee RECORD_1 = new Employee("Rayven Yor", "Rayven Yor", "Cebu Philippines", 2365);
//		Employee RECORD_3 = new Employee("Rayven Yor", "Rayven Yor", "Cebu Philippines", 2365);
//		List<Employee> entity = new ArrayList<>(Arrays.asList(RECORD_3));
//		employeeServicee.deleteAllEmp(entity);
//		assertNotEquals(2, employeeServicee.getAllEmployees().size());
//	}
}