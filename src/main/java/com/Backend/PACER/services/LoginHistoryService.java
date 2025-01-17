package com.Backend.PACER.services;

import java.util.List;

import com.Backend.PACER.entities.LoginHistory;
import com.Backend.PACER.repositories.LoginHistoryRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginHistoryService{

	private final LoginHistoryRepository loginHistoryRepository;

	public LoginHistoryService(LoginHistoryRepository loginHistoryRepository) {
		this.loginHistoryRepository = loginHistoryRepository;
	}

	public void deleteLoginHistoryByUserId(Long userId) {
		loginHistoryRepository.deleteByUser_Id(userId);
	}

	public List<LoginHistory> getLoginHistoryByUserId(Long userId){
		return loginHistoryRepository.findByUserId(userId);
	}

	public LoginHistory createLoginHistory(LoginHistory loginHistory) {
		return loginHistoryRepository.save(loginHistory);
	}
}

