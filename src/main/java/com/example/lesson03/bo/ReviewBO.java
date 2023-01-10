package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.dao.ReviewDAO;
import com.example.lesson03.model.Review;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewDAO reviewDAO;
	
	public Review getReview(int id) { //필수일때 int, null도가능하면 Integer
		return reviewDAO.selectReview(id);
	}
	
	//insert 메서드
	//input : Review객체
	//output : int(인서트가 성공된 행 수) 또는 없음 ->mybatis가 자체적으로 제어,리턴받을 수 있음
	public int addReview(Review review) {
		//public void addReview(Review review) 가능
		return reviewDAO.insertReview(review);
	}
	//addReviewAsField(4,"콤비네이션R","신바다",5.0,"역시맛이따!")
	public int addReviewAsField(int storeId,String menu,String userName,Double point,String review) {		
		return reviewDAO.insertReviewAsField(storeId, menu, userName, point, review);
	}//자동완성믿지말것, 복붙하기, 순서확인
}
