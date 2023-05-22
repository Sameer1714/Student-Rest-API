package com.student.controller;

import java.util.List;
import java.util.Optional;

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

import com.student.modal.Student;
import com.student.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/student")
	public ResponseEntity<List<Student>> GetStudnetInfo() {

		List<Student> getAllStudentInfo = studentService.GetAllStudentInfo();

		if (getAllStudentInfo.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.of(Optional.of(getAllStudentInfo));

	}

	@PostMapping("/student")
	public ResponseEntity<Student> AddStudent(@RequestBody Student student) {
		try {
			studentService.addStudent(student);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<Student> STudentGetByID(@PathVariable("id") int id) {

		Student fIndById = studentService.FIndById(id);

		System.out.println("shdd: " + fIndById);

		if (fIndById == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.of(Optional.of(fIndById));

	}

	@DeleteMapping("/student/{id}")
	public ResponseEntity<Void> DeleteStuudentInfo(@PathVariable("id") int id) {

		try {
			studentService.deleteStudentInfo(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudentInfo(@RequestBody Student student, @PathVariable("id") int id) {
		try {
			Student editByID = studentService.EditByID(student, id);

			return ResponseEntity.ok().body(student);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

}
