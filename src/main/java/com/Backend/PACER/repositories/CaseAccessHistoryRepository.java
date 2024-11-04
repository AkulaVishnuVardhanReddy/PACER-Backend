package com.Backend.PACER.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Backend.PACER.entities.CaseAccessHistory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CaseAccessHistoryRepository extends JpaRepository<CaseAccessHistory,Long> {
	List<CaseAccessHistory> findByCourtCaseCin(Long cin);

	@Transactional
	@Modifying
	@Query("DELETE FROM CaseAccessHistory c WHERE c.user.id = :userId")
	void deleteByUserId(Long userId);
}
