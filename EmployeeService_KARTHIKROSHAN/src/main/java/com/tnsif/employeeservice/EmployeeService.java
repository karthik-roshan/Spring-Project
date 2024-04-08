package com.tnsif.employeeservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {
	@Autowired
	private EmployeeRepository repo;
	public List<Employee> listAll()
	{
		return repo.findAll();
	}
	public void save(Employee emp)
	{
		repo.save(emp);
	}
	public Employee get(Integer id)
	{
		return repo.findById(id).get();
		
	}
	//deleting the record
	
	public void delete(Integer id)
	{
		repo.deleteById(id);
	}
	
	//updating the record
	
	public void update(Employee emp)
	{
		repo.save(emp);
	}

}