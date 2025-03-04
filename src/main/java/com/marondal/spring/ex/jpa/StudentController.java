package com.marondal.spring.ex.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.ex.jpa.domain.Student;
import com.marondal.spring.ex.jpa.service.StudentService;

@RequestMapping("/jpa/student")
@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@ResponseBody
	@GetMapping("/create")
	public Student createStudent() {
		// 김인규, 010-1234-5678, lecture@hagulu.com, 개발자
		Student student = studentService.addStudent("김인규", "010-1234-5678", "lecture@hagulu.com", "개발자");
		
		return student;
		
	}
	
	@ResponseBody
	@GetMapping("/update")
	public Student updateStudent() {
		// id가 3인 학생의 장래 희망을 강사로 변경
		Student student = studentService.updateStudent(3, "강사");
		
		
		return student;
	}
	
	@ResponseBody
	@GetMapping("/delete")
	public String deleteStudent() {
		// id가 3인 학생정보 삭제
		studentService.deleteStudent(3);
		return "삭제 성공!";
	}
	
	@ResponseBody
	@GetMapping("/jpa/lombok")
	public Student lombokTest() {
		
//		Student student = new Student(4, "김인규", "010-1234-5678", "lecture@hagulu.com", "프로그래머", null, null);
//		student.setDreamJob("강사");
//		student.setPhoneNumber("010-1111-2222");
		
		// builder 패턴 
		Student student = Student.builder()
				.name("김인규")
				.phoneNumber("010-1234-5678")
				.dreamJob("개발자")
				.build();
		
		return student;
		
	}

}
