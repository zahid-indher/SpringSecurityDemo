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


@RestController
public class StudentsController {
	@Autowired
	private StudentsRepository studentsRepository;

	
	@GetMapping("/students")
	public List<Students> getAllStudentss() {
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
	
//	@PutMapping("/Studentss/{id}")
//	public ResponseEntity<Students> updateStudents(@PathVariable(value = "id") Long StudentsId,
//			@Valid @RequestBody Students StudentsDetails) throws ResourceAccessException {
//		Students Students = studentsRepository.findById(StudentsId)
//				.orElseThrow(() -> new ResourceAccessException("Students not found for this id :: " + studentsId));
//
//		Students.setId(StudentsDetails.getId());
//		Students.setName(StudentsDetails.getName());
//		final Students updatedStudents = studentsRepository.save(Students);
//		return ResponseEntity.ok(updatedStudents);
//	}
//	
//	@DeleteMapping("/Studentss/{id}")
//	public Map<String, Boolean> deleteStudents(@PathVariable(value = "id") Long StudentsId)
//			throws ResourceAccessException {
//		Students Students = studentsRepository.findById(StudentsId)
//				.orElseThrow(() -> new ResourceAccessException("Students not found for this id :: " + studentsId));
//
//		studentsRepository.delete(Students);
//		Map<String, Boolean> response = new HashMap<>();
//		response.put("deleted", Boolean.TRUE);
//		return response;
//	}
	
}
