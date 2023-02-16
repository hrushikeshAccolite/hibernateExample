package com.student.management;

import com.student.management.models.AadhaarCard;
import com.student.management.models.Student;
import com.student.management.repository.StudentRepository;
import com.student.management.services.StudentServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ManagementApplicationTests {

	@Autowired
	StudentServices studentServices;

	@Test
	void addStudent(){
		Student s = new Student();
		s.setName("Hrushikesh");
		s.setGrade(11);
		s.setContactNumber(9987300981L);

		AadhaarCard aadhaarCard = new AadhaarCard();
		aadhaarCard.setAadhaarNumber("1234 2123 8888");
		s.setAadhaarCard(aadhaarCard);

		studentServices.save(s);
	}

	@Test
	void findAll() {
		List<Student> studentList = studentServices.findAll();
		System.out.println(studentList);
	}

}
