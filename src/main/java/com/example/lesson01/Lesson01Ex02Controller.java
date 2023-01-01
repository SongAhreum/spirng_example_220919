package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //@RestController 아님 @ResponseBody업어야함
public class Lesson01Ex02Controller {
	
	//http://localhost/lesson01/ex02/1
	@RequestMapping("/lesson01/ex02/1")
	//jsp로 리턴하는 경우는 String으로..!!
	//String이라는게 controller이면 뷰의경로를 찾으려하지만 @responsebody가있으면 값이라고 생각하고 body에 내용을 넣어버림
	public String ex02() {
		//ResponseBody가 아닌 상태로 String을 리턴하면 (ResponseBody -> HttpMessageConverter작동)
		//ViewResolver에 의해, 리턴된 String이름의 view경로를 찾고 화면이 구성된다
		
		//   prefix : /WEB-INF/jsp/ (lesson01/ex02) surfix : .jsp
		//return "/WEB-INF/jsp/lesson01/ex02.jsp"; //webapp이전은 자동인식 그이후로 적기
		return "lesson01/ex02"; //application.properties에서 prefix,surfix제외
	}
}
