package com.Backend.PACER.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Backend.PACER.entities.Hearing;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HearingRepository extends JpaRepository<Hearing,Long>{
	
	List<Hearing> findByCourtCase_Cin(Long courtCaseCin);

	@Query("SELECT h FROM Hearing h WHERE h.procedingSummary LIKE CONCAT('%', :keyword, '%')")
	List<Hearing> findByProcedingSummaryContainingKeyword(@Param("keyword") String keyword);
}
