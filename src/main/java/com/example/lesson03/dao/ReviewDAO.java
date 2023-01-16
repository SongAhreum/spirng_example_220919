package com.example.lesson03.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.model.Review;

@Repository
public interface ReviewDAO {
	//public Review selectReview(@Param("id")int id); 파라미터가 한개이면@Param("id")안넣어도됨
	public Review selectReview(int id);
	
	public int insertReview(Review review); //@Param없어도됨 한개임
	
	public int insertReviewAsField(
			@Param("storeId") int storeId,
			@Param("menu") String menu,
			@Param("userName") String userName,
			@Param("point") Double point,
			@Param("review") String review);
	
	public int updateReviewById(
			@Param("id")int id,
			@Param("review") String review);
	
	public void deleteReviewById(int id);
}
