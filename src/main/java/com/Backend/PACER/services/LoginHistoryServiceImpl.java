package com.Backend.PACER.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Backend.PACER.entities.LoginHistory;
import com.Backend.PACER.repositories.LoginHistoryRepository;
import com.Backend.PACER.services.interfaces.LoginHistoryService;

@Service
public class LoginHistoryServiceImpl implements LoginHistoryService{
	
	private LoginHistoryRepository loginHistoryRepository;

	public LoginHistoryServiceImpl(LoginHistoryRepository loginHistoryRepository) {
		this.loginHistoryRepository = loginHistoryRepository;
	}
	
	
	@Override
	public List<LoginHistory> getLoginHistoryByUserId(Long userId){
		return loginHistoryRepository.findByUserId(userId);
	}
	
	
	@Override
	public LoginHistory createLoginHistory(LoginHistory loginHistroy) {
		return loginHistoryRepository.save(loginHistroy);
	}
}
