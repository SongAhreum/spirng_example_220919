package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.model.Review;

@RestController //바로 빈으로만드는 어노테이션 추가
public class Lesson03Ex01RestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	//http://localhost/lesson03/ex01?id=2
	@RequestMapping("/lesson03/ex01")
	//한행만 받을거라 Review라 이름지음
	public Review ex01(
			@RequestParam("id")int id){ //required나다른 설정들이 있을때 value필요
			//@RequestParam(value="id")int id //int네,필수 파라미터네~
			//@RequestParam(value="id",required=true)int id){	
			//@RequestParam(value="id",required=false)Integer id){
			//@RequestParam(value="id",required=false, defaultValue="1")int id){//비필수 파라미터,디폴트값 1,null이 아니어서 int
		
//		if(id == null) {
//			return null;
//		} else {
		return reviewBO.getReview(id);
//		}
	}	
}

