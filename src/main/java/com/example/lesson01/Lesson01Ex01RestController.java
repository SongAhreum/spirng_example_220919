package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/ex01")
@RestController
public class Lesson01Ex01RestController {

	// 요청 URL: http://localhost:8080/lesson01/ex01/3
	@RequestMapping("/3")
	public String printString() {
		return "@RestController를 사용해서 String을 retrun한다";
	}
	
	@RequestMapping("/4")
	public Map<String,String> printMap(){
		Map<String,String> map = new HashMap<>();
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "333");
		return map;
	}
	
	@RequestMapping("/5")
	public Data ex01_5() {
		Data data = new Data();
		data.setId(1);
		data.setName("신보람"); // 일반 bean 객체로 json으로 반환된다.
		return data;
	}
	
	@RequestMapping("/6")
	public ResponseEntity<Data> ex01_06(){
		Data data = new Data();
		data.setId(1);
		data.setName("신보람");
		return new ResponseEntity<>(data,HttpStatus.INTERNAL_SERVER_ERROR);
		//HttpStatus.INTERNAL_SERVER_ERROR는 500에러
		//서버를켜서 들어가보면 500이뜨지만(서버에서 지정한대로 브라우저에뜸) 응답은 잘내려옴
	}
}
