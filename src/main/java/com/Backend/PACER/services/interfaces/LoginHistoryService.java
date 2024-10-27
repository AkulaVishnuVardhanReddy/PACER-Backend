package com.Backend.PACER.services.interfaces;

import java.util.List;

import com.Backend.PACER.entities.LoginHistory;

public interface LoginHistoryService {
	List<LoginHistory> getLoginHistoryByUserId(Long userId);
	LoginHistory createLoginHistory(LoginHistory loginHistroy);
}
