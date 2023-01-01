package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/ex01")
@Controller
public class Lesson01Ex01Controller {
//컨트롤러 역할 클래스는 new등으로 내가 객체로 만들어서 사용하지 않음, 스프링이 bean을만들어서 사용하도록 맡김
	//->Spring bean등록 : @Controller
	
	//String 출력하기 - content type html
	//http://localhost:8080/lesson01/ex01/1
	@ResponseBody //리턴되는 값을 html response body에 넣어 보낸다
	@RequestMapping("1") //주소 매핑
	public String printString() {
		String text = "예제1번<br>문자열을 response body로 보내는 예제";
		return text;		
	}
	
	//http://localhost:8080/lesson01/ex01/2
	@ResponseBody
	@RequestMapping("/2")
	public Map<String,Object> printMap(){
		//java에선 map출력시 {"aaaa"=1111,"bbbb"=1111....} (jason은 출력시에 {"aaaa":1111})
		Map<String,Object> map = new HashMap<>();
		map.put("aaaa", 1111);
		map.put("bbbb", 1111);
		map.put("cccc", 2222);
		map.put("dddd", 3333);
		//spring web starter때문에 jackson이라는 라이브러리가 포함되어있음
		return map; //map을 return하면 jason으로 출력된다
		
		//dependencies에서 잭슨이라는 라이브러리가 @ResponseBody에 key value로 이루어진데이터는 jason으로 출력
	}
}
 