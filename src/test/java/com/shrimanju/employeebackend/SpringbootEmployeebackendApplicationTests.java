package com.shrimanju.employeebackend;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shrimanju.employeebackend.model.Employee;
import com.shrimanju.employeebackend.repository.EmployeeRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class SpringbootEmployeebackendApplicationTests {
	
	@Autowired
EmployeeRepository Erepo;
	
	@Test
	@Order(1)
	public void Createnew() {
		Employee e=new Employee();
		e.setId(25L);
		e.setFirstName("shrimanjuqq");
		e.setLastName("ks");
		e.setEmailId("shri@gmail.com");
		e.setPhoneno(222);
		Erepo.save(e);
		assertNotNull(Erepo.findById(21L).get());
	}

	@Test
	@Order(2)
	public void ReadAll(){
	List<Employee> list=Erepo.findAll();
	assertThat(list).size().isGreaterThanOrEqualTo(0);
	}
	@Test
	@Order(3)
	public void ReadBySingleEmailId(){
	Employee emp=Erepo.findById(11L).get();
	assertEquals("shri@gmail.com",emp.getEmailId());
	}
	@Test
	@Order(4)
	public void ReadBySinglePhoneno(){
	Employee emp=Erepo.findById(21L).get();
	assertEquals(222, emp.getPhoneno());
	}
	@Test
	@Order(5)
	public void ReadBySinglefirstname(){
	Employee emp=Erepo.findById(21L).get();
	assertEquals("shrimanjuqq", emp.getFirstName());
	}
	@Test
	@Order(6)
	public void ReadBySinglelastname(){
	Employee emp=Erepo.findById(21L).get();
	assertEquals("ks",emp.getLastName());
	}
	@Test
	@Order(7)
	public void Update(){
		Employee emp=Erepo.findById(21L).get();
		emp.setFirstName("shrimanjuks");
		Erepo.save(emp);
		assertNotEquals("shrimanju",Erepo.findById(21L).get().getFirstName());
		}
//	@Test
//	@Order(8)
//	public void delete(){
//		Erepo.deleteById(2L);
//		assertThat(Erepo.existsById(2L)).isFalse();
//		}
//	@Test
//	@Order(8)
//	public void deleteAll(){
//		Erepo.deleteAll();
//		assertNotNull(Erepo);
//		}
}
