package com.example.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;


@RequestMapping("/lesson06")
@Controller //화면도 사용하고 @ResponsBody도같이 사용해야해서 @Controller
public class Lesson06Controller {
	
	@Autowired
	private UserBO userBO;
	
	//회원가입 화면
	//http://localhost/lesson06/ex01/add_user_view
	@GetMapping("/ex01/add_user_view")
	public String addUserView() {
		return"lesson06/ex01/addUser";
	}
	
	//회원가입(form)
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
		//db insert(lesson04에 있음)
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		//비동기 호출-데이터로내려감
		return"success"; //AJAX는 항상 String으로 return!!(규칙)
		          //AJAX에서 request보낸후 response로 return한 String값을 받음
		          //success함수의 파라미터, date값으로 받음
		          //회원가입한다음 view페이지로넘어가고 싶다면 javaScript의 location.href="naver.com";사용
	}
	
	@GetMapping("/ex01/after_add_user_view")
	public String afterAddUserView() {
		return"lesson06/ex01/afterAddUser";
	}
	
	@GetMapping("/ex02/add_name_view")
	public String addNameView() {
		return"lesson06/ex02/addName";
	}
	
	@ResponseBody //이거없이 ajax응답내리면 어떻게되는지->404
	@GetMapping("/ex02/is_duplication")
	public Map<String,Boolean> isDuplication(
			@RequestParam("name") String name) {
		
		Map<String,Boolean> result = new HashMap<>();
		result.put("is_duplication",userBO.existUserByName(name));
		
		return result;
	}
	
}
