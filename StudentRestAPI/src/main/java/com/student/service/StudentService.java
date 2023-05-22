package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.StudentRepository;
import com.student.modal.Address;
import com.student.modal.Student;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> GetAllStudentInfo() {
		List<Student> findAll = studentRepository.findAll();

		return findAll;
	}

	public Student addStudent(Student student) {

		Student save = studentRepository.save(student);
		return save;
	}

	public Student FIndById(int id) {

		Student s = null;

		try {

			Optional<Student> findById = studentRepository.findById(id);

			s = findById.get();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return s;
	}

	public void deleteStudentInfo(int id) {

		studentRepository.deleteById(id);

	}

	public Student EditByID(Student student, int id) {

		student.setId(id);

		Student save = studentRepository.save(student);

		return save;
	}
}
