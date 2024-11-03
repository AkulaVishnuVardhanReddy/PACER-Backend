package com.Backend.PACER.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Backend.PACER.entities.LoginHistory;

public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long>{
	List<LoginHistory> findByUserId(Long userId);
	void deleteByUserId(Long userId);
}
