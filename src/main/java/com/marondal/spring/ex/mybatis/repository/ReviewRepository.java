package com.marondal.spring.ex.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.marondal.spring.ex.mybatis.domain.Review;

@Mapper
public interface ReviewRepository {
	
	// 전달 받은 id와 일치하는 행 조회 
	public Review selectReview(@Param("id") int id);

	// 내용을 전달 받고 new_review 테이블에 저장
	public int insertReview(
			@Param("storeId") int storeId
			, @Param("menu") String menu
			, @Param("userName") String userName
			, @Param("point") double point
			, @Param("review") String review);
	
//	Review 객체의 멤버변수 값을 new_review 테이블에 저장
	public int insertReviewByObject(Review review);
	
	
}
