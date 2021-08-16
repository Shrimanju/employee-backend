package com.shrimanju.employeebackend.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.shrimanju.employeebackend.exception.ResourceNotFoundException;
import com.shrimanju.employeebackend.model.Employee;
import com.shrimanju.employeebackend.repository.EmployeeRepository;

@Service
public class EmployeeService {
	  
    @Autowired
    EmployeeRepository repository;
     
    public List<Employee> getAllEmployees()
    {
        List<Employee> employeeList = repository.findAll();
         
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<Employee>();
        }
    }
     
    public Employee getEmployeeById(Long id) throws ResourceNotFoundException 
    {
        Optional<Employee> employee = repository.findById(id);
         
        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new ResourceNotFoundException("No employee record exist for given id");
        }
    }
     
    public Employee createEmployee(Employee entity) throws ResourceNotFoundException
    {
       
            entity = repository.save(entity);
             
            return entity;
        
    } 
    
    public Employee UpdateEmployee(Employee entity) throws ResourceNotFoundException
    {
        Optional<Employee> employee = repository.findById(entity.getId());
         
        if(employee.isPresent()) 
        {
            Employee newEntity = employee.get();
            newEntity.setEmailId(entity.getEmailId());
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());
 
            newEntity = repository.save(newEntity);
             
           
        }
		return entity; 
    } 
     
    public void deleteEmployeeById(Long id) throws ResourceNotFoundException
    {
        Optional<Employee> employee = repository.findById(id);
         
        if(employee.isPresent()) 
        {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("No employee record exist for given id");
        }
    } 
    public ResponseEntity<HttpStatus> deleteAllEmp(List<Employee> entity) throws ResourceNotFoundException{
    try {
    	repository.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	catch(Exception e) {}
	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
}

	public Object getEmployeeById(String anyString, String anyString2) {
		// TODO Auto-generated method stub
		return null;
	}
    }