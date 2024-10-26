package com.Backend.PACER.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Backend.PACER.entities.CaseAccessHistory;

public interface CaseAccessHistoryRepository extends JpaRepository<CaseAccessHistory,Long> {

}
