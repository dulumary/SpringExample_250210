package com.marondal.spring.ex.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.spring.ex.mybatis.domain.Review;
import com.marondal.spring.ex.mybatis.repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	// 전달받은 id와 일치하는 리뷰정보 얻어오기 
	public Review getReview(int id) {
		// new_review 테이블에서 전달한 id가 일치하는 행 조회 
		Review review = reviewRepository.selectReview(id);
		
		return review;
	}
	
	// 작성할 내용을 전달 받고 리뷰를 저장하는 기능
	public int addReview(
			int storeId
			, String menu
			, String userName
			, double point
			, String review) {
		
		int count = reviewRepository.insertReview(storeId, menu, userName, point, review);
		
		return count;
	}
	
	public int addReviewByObject(Review review) {
		// Review 객체의 멤버변수 값을 new_review 테이블에 저장 
		int count = reviewRepository.insertReviewByObject(review);
		
		return count;
	}
	

}
