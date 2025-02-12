package com.marondal.spring.ex.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex02Controller {
	
	@RequestMapping("/lifecycle/ex02")
	public String thymeleafResponse() {
		// html 파일 경로 
		// src/main/resources/templetes 생략
		// .html 생략
		return "lifecycle/ex02";
	}

}
