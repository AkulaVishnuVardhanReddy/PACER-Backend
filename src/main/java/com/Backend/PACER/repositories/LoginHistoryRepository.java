package com.Backend.PACER.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Backend.PACER.entities.LoginHistory;

public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long>{

}
