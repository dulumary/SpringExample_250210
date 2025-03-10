package com.marondal.spring.ex.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.spring.ex.mvc.domain.User;
import com.marondal.spring.ex.mvc.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	// 사용자 정보를 전달 받고 저장기능
	public int addUser(String name
			, String birthday
			, String email
			, String introduce) {
		
		int count = userRepository.insertUser(name, birthday, email, introduce);
		
		return count;
	}
	
	public int addUserByObject(User user) {
		int count = userRepository.insertUserByObject(user);
		return count;
	}
	
	// 가장 최근에 등록된 사용자 정보 얻어오기 
	public User getLastUser() {
		User user = userRepository.selectLastUser();
		
		return user;
	}
	
	// 이메일을 전달 받고 중복 여부를 확인하는 기능
	public boolean isDuplicateEmail(String email) {
		int count = userRepository.selectCountByEmail(email);
		
		if(count == 0) {
			return false;
		} else {
			return true;
		}
		
	}
	
	
	
	
	
	
	
	

}
