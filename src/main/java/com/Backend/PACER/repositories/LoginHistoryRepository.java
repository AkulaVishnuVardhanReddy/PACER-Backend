package com.Backend.PACER.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Backend.PACER.entities.LoginHistory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long>{
	List<LoginHistory> findByUserId(Long userId);
	@Modifying
	@Transactional
	void deleteByUser_Id(Long userId);
}
