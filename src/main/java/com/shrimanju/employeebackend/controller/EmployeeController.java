package com.shrimanju.employeebackend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import com.shrimanju.employeebackend.exception.ResourceNotFoundException;
import com.shrimanju.employeebackend.model.Employee;
import com.shrimanju.employeebackend.repository.EmployeeRepository;
import com.shrimanju.employeebackend.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
    EmployeeService service;
	
	// get all employees
	@GetMapping("/employees")
	  public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> list = service.getAllEmployees();
		 return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);

	}		
	
	// get employee by id rest api
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id)throws ResourceNotFoundException  {
		Employee entity = service.getEmployeeById(id);
				
				  return new ResponseEntity<Employee>(entity, new HttpHeaders(), HttpStatus.OK);
		
	}
	// create employee rest api
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) 
             throws ResourceNotFoundException {
		
	        return service.createEmployee(employee);

	    }
		
	
//	// create employee rest api
//	@PostMapping("/employees")
//	public Employee createEmployee(@RequestBody Employee employee) {
//		
//		return employeeRepository.save(employee);
//	}
//	

//	// update employee rest api
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		employee.setPhoneno(employeeDetails.getPhoneno());
		
		Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
//	
	// delete employee rest api
	@DeleteMapping("/employees/{id}")
	 public HttpStatus deleteEmployee(@PathVariable Long id) throws ResourceNotFoundException {
		  service.deleteEmployeeById(id);
	        return HttpStatus.ACCEPTED;
	    }
	
	@DeleteMapping("/employees/")
	public void deleteAll(){

			service.deleteAllEmp(null);
		
		
	}
}











//
//
//package com.shrimanju.employeebackend.controller;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.shrimanju.employeebackend.exception.ResourceNotFoundException;
//import com.shrimanju.employeebackend.model.Employee;
//import com.shrimanju.employeebackend.repository.EmployeeRepository;
//import com.shrimanju.employeebackend.service.EmployeeService;
//
//
//@CrossOrigin(origins = "http://localhost:3000")
//@RestController
//@RequestMapping("/api/v1/")
//public class EmployeeController {
//	@Autowired
//    EmployeeService service;
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    // get all employees
//    @GetMapping("/employees")
//    public List < Employee> getAllEmployees() {
//        return employeeRepository.findAll();
//    }
//
//    // create employee rest api
//    @PostMapping("/employees")
//    public Employee createEmployee(@RequestBody Employee employee) {
//        return employeeRepository.save(employee);
//    }
//
//    // get employee by id rest api
//    @GetMapping("/employees/{id}")
//    public ResponseEntity < Employee > getEmployeeById(@PathVariable Long id) {
//    	Employee employee = employeeRepository.findById(id)
// 				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//        return ResponseEntity.ok(employee);
//    }
//
// // update employee rest api
// 	@PutMapping("/employees/{id}")
// 	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
// 		Employee employee = employeeRepository.findById(id)
// 				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
// 		employee.setFirstName(employeeDetails.getFirstName());
// 		employee.setLastName(employeeDetails.getLastName());
// 		employee.setEmailId(employeeDetails.getEmailId());
// 		employee.setPhoneno(employeeDetails.getPhoneno());
// 		
// 		Employee updatedEmployee = employeeRepository.save(employee);
// 		return ResponseEntity.ok(updatedEmployee);
// 	}
//    // delete employee rest api
//    @DeleteMapping("/employees/{id}")
//    public ResponseEntity < Map < String, Boolean >> deleteEmployee(@PathVariable Long id) {
//    	Employee employee = employeeRepository.findById(id)
// 				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//
//        employeeRepository.delete(employee);
//        Map < String, Boolean > response = new HashMap < > ();
//        response.put("deleted", Boolean.TRUE);
//        return ResponseEntity.ok(response);
//    }
////	// deleteAll employee rest api
//	@DeleteMapping("/employees/")
//	public void deleteAll(){
//
//			service.deleteAllEmp();
//		
//		
//	}
//}