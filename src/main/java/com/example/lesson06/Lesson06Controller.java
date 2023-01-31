package com.example.lesson06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {
	
	//회원가입 화면
	//http://localhost/lesson06/ex01/add_user_view
	@GetMapping("/ex01/add_user_view")
	public String addUserView() {
		return"lesson06/ex01/addUser";
	}
	
	//회원가입
//	@PostMapping("/ex01/add_user")
//	public String addUser(
//			@RequestParam("name") String name,
//			@RequestParam("yyyymmdd") String yyyymmdd,
//			@RequestParam(value="email", required=false) String email,
//			@RequestParam(value="introduce",required=false) String introduce
//			) {
//		
//		//db insert생략
//		 
//		return"lesson06/ex01/afterAddUser";
//	}
	//회원가입 - AJAX통신으로 오는 요청
	@ResponseBody
	@PostMapping("/ex01/add_user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam(value="email", required=false) String email,
			@RequestParam(value="introduce",required=false) String introduce
			) {
		return"";
	}

}
