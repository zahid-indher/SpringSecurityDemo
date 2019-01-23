package com.spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.security.model.Students;
import com.spring.security.repository.StudentsRepository;


@RestController
public class StudentsController {
	@Autowired
	private StudentsRepository studentsRepository;

	
	@GetMapping("/students")
	public List<Students> getAllEmployees() {
		return studentsRepository.findAll();
	}
	
}
