package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.model.Student;

import ch.qos.logback.core.net.SyslogOutputStream;

@RequestMapping("/lesson04/ex02")
@Controller
public class Lesson04Ex02Controller {
	
	@Autowired
	private StudentBO studentBO;
	
	//학생추가화면
	//http://localhost/lesson04/ex02/add_student_view
	@GetMapping("/add_student_view")
	public String addStudentView() {
		return "lesson04/addStudent";
	}

	@PostMapping("/add_student")
	public String addStudent( //한개일때는 @ModelAttribute생략가능
			//@RequestParam으로 여러개받을 수 있지만, 객체로 한번에 받을 수 있다.
			@ModelAttribute Student student, //name(request param)과 일치하는 것이 담긴다
			Model model) {
		//db insert
		studentBO.addStudent(student);
		
		//db select (방금 가입된사람)
		System.out.println("student Id : "+ student.getId());
		//뿌리기위해 방금가입된사람정보필요함,insert태그안에서 방금insert된 key(keyproperty)가지고올게 설정,파라미터타입으로 가지고온 객체에 심어짐
		//student가 가지고있음
		Student student1 = studentBO.getStudentById(student.getId());
		model.addAttribute("result", student1);
		model.addAttribute("subject", "학생정보");
		//view페이지 응답값
		return "lesson04/afterAddStudent";
	}

}
