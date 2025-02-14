package com.marondal.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.ex.mybatis.domain.Review;
import com.marondal.spring.ex.mybatis.service.ReviewService;

@RequestMapping("/mybatis/review")
@Controller
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	// 전달받은 id와 일치하는 리뷰정보를 json으로 response에 담는다 
	@ResponseBody
	@RequestMapping("")
	public Review review(@RequestParam int id) {
		// String idString = request.getParameter("id");
		// int id = Integer.parseInt(idString);
		
		// 전달한 id와 일치하는 리뷰정보 얻어오기
		Review review = reviewService.getReview(id);
		
		return review;
	}
	
	// 리뷰내용을 저장하는 기능
	@ResponseBody
	@RequestMapping("/create")
	public String createReview() {
		// 4, 치즈피자, 김인규, 4.5 치즈피자 존맛!
//		int count = reviewService.addReview(4, "치즈피자", "김인규", 4.5, "치즈피자 존맛!");
		
		// 2, 뿌링클, 김인규, 4.0, 역시 뿌링클은 진리입니다!!
		Review review = new Review();
		review.setStoreId(2);
		review.setMenu("뿌링클");
		review.setUserName("김인규");
		review.setPoint(4.0);
		review.setReview("역시 뿌링클은 진리입니다!!");
		// review 객체의 멤버변수 값을 리뷰내용으로 저장한다. 
		int count = reviewService.addReviewByObject(review);
		
		return "삽입 결과 " + count;
	}
	

}
