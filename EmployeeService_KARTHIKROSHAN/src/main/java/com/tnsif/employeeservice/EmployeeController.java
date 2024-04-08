package com.tnsif.employeeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.NoResultException;

import java.util.List;

@RestController

public class EmployeeController {
	@Autowired
	private EmployeeService emp;
	@GetMapping("/employeeservice ")
	public List<Employee > list()
	{
		return emp.listAll();
	}
	@PostMapping("/employeeservice")
	public void add(@RequestBody Employee  emp1)
	{
		emp.save(emp1);
	}
	@GetMapping("/Employee /{id}")
	public ResponseEntity<Employee> get(@PathVariable Integer id)
	{
		try {
			Employee ep =emp.get(id);
			return new ResponseEntity<Employee>(ep,HttpStatus.OK);
		}
		catch(NoResultException e)
		{
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/employeeservice/{id}")
	public void delete(@PathVariable Integer id)
	{
		emp.delete(id);
	}
	
	@PutMapping("/Employee/{id}")
	public ResponseEntity<Employee>update(@PathVariable Integer id,@RequestBody Employee update_ep)
	{
		try {
			Employee exist_ep =emp.get(id);
			exist_ep.setEname(update_ep.getEname());
			exist_ep.setEaddress(update_ep.getEaddress());
			exist_ep.setSalary(update_ep.getSalary());
			exist_ep.setMobileno(update_ep.getMobileno());
			exist_ep.setIncrement(update_ep.getIncrement());
			exist_ep.setSales(update_ep.getSales());

			
		     emp.update(exist_ep);
		return new ResponseEntity<Employee>(exist_ep,HttpStatus.OK);
		}
		catch(NoResultException e)
		{
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}
}