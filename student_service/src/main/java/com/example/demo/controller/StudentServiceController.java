package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;

@RestController
public class StudentServiceController {
	private static Map<String, List<Student>> schoolDB = new HashMap<>();
	static {
		schoolDB = new HashMap<>();
		List<Student> lst = new ArrayList<>();
		Student std = new Student("Sajal", "CLass IV");
		lst.add(std);
		std = new Student("Lokesh", "Class V");
		lst.add(std);

		schoolDB.put("abcschool", lst);

		lst = new ArrayList<Student>();
		std = new Student("Kajal", "Class III");
		lst.add(std);
		std = new Student("Sukesh", "Class VI");
		lst.add(std);

		schoolDB.put("xyzschool", lst);
	}

	@GetMapping(value = "/getStudentDetailsForSchool/{schoolname}")
	public List<Student> getStudent(@PathVariable String schoolname) {
		System.out.println("Getting Student details for " + schoolname);
		List<Student> studentList = schoolDB.get(schoolname);
		if (studentList == null) {
			studentList = new ArrayList<Student>();
			Student std = new Student("Not Found", "N/A");
			studentList.add(std);
		}
		return studentList;
	}
}
