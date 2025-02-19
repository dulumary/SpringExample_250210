package com.marondal.spring.ex.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.ex.mvc.domain.User;
import com.marondal.spring.ex.mvc.service.UserService;

@RequestMapping("/mvc/user")
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// 사용자 정보를 전달 받고 저장하는 기능
//	@ResponseBody
//	@RequestMapping(path="/mvc/user/create", method=RequestMethod.POST)
	@PostMapping("/create")
	public String createUser(
			@RequestParam("name") String name
			, @RequestParam("birthday") String birthday
			, @RequestParam("email") String email
			, @RequestParam("introduce") String introduce
			, Model model) {
		
		
//		int count = userService.addUser(name, birthday, email, introduce);
		
		User user = new User();
		user.setName(name);
		user.setYyyymmdd(birthday);
		user.setEmail(email);
		user.setIntroduce(introduce);
		
		userService.addUserByObject(user);		
		
		model.addAttribute("user", user);
//		return "삽입 결과 : " + count;
//		return "redirect:/mvc/user/info";
		return "mvc/userInfo";
	}
	
	@GetMapping("/input")
	public String inputUser() {
		return "mvc/userInput";	
	}
	
	@GetMapping("/info")
	public String userInfo(Model model) {
		// 가장 최근에 등록된 한 사용자 정보 얻어오기 
		User user = userService.getLastUser();
		
		model.addAttribute("user", user);
		return "mvc/userInfo";
	}

}
