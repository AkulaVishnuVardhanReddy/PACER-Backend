package com.Backend.PACER.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.PACER.entities.LoginHistory;
import com.Backend.PACER.services.interfaces.LoginHistoryService;

@RestController
public class LoginHistoryController {
	
	private LoginHistoryService loginHistoryService;

	public LoginHistoryController(LoginHistoryService loginHistoryService) {
		super();
		this.loginHistoryService = loginHistoryService;
	}
	
	@PostMapping("/loginHistory")
	public LoginHistory createLoginHistory(@RequestBody LoginHistory loginHistory) {
		return loginHistoryService.createLoginHistory(loginHistory);
	}
	
	@GetMapping("/loginHistory/{userId}")
	public List<LoginHistory> getLoginHistory(@PathVariable Long userId){
		return loginHistoryService.getLoginHistoryByUserId(userId);
	}
}
