package com.spring.security.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import com.spring.security.model.Students;
import com.spring.security.repository.StudentsRepository;
import com.spring.security.service.CityService;

@RestController
public class StudentsController {
	@Autowired
	private StudentsRepository studentsRepository;
	
	@Autowired
	CityService c;
	

	@GetMapping("/lastName")
	public void lastName() {
		List<Students> studentList = c.findByNameEndsWith("Indher");
		System.out.println(studentList.get(0));
		studentList.forEach(name -> {
		    System.out.println(name);
		});		

		studentList.forEach(System.out::println);
		
	}
	
	@GetMapping("/students")
	public List<Students> getAllStudents() {
		return studentsRepository.findAll();
	}

	@GetMapping("/students/{id}")
	public ResponseEntity<Students> getStudentsById(@PathVariable(value = "id") Long studentId)
			throws ResourceAccessException {
		Students student = studentsRepository.findById(studentId)
				.orElseThrow(() -> new ResourceAccessException("Students Not Found For This ID :: " + studentId));
		return ResponseEntity.ok().body(student);
	}

	@PostMapping("/students")
	public Students createStudents(@Valid @RequestBody Students students) {
		return studentsRepository.save(students);
	}

	@PutMapping("/students/{id}")
	public ResponseEntity<Students> updateStudents(@PathVariable(value = "id") Long studentsId,
			@Valid @RequestBody Students studentsDetails) throws ResourceAccessException {
		Students students = studentsRepository.findById(studentsId)
				.orElseThrow(() -> new ResourceAccessException("Students not found for this id :: " + studentsId));

		students.setStudentId(studentsDetails.getStudentId());
		students.setFirstName(studentsDetails.getFirstName());
		students.setLastName(studentsDetails.getLastName());
		students.setEmail(studentsDetails.getEmail());
		students.setMobileNo(studentsDetails.getMobileNo());

		final Students updatedStudents = studentsRepository.save(students);
		return ResponseEntity.ok(updatedStudents);
	}

	@DeleteMapping("/students/{id}")
	public Map<String, Boolean> deleteStudents(@PathVariable(value = "id") Long studentsId)
			throws ResourceAccessException {
		Students students = studentsRepository.findById(studentsId)
				.orElseThrow(() -> new ResourceAccessException("Students not found for this id :: " + studentsId));

		studentsRepository.delete(students);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
