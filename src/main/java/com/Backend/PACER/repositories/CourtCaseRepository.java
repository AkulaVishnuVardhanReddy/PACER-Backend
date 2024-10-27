package com.Backend.PACER.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Backend.PACER.entities.CourtCase;

public interface CourtCaseRepository extends JpaRepository<CourtCase, Long> {
	
	List<CourtCase> findByDefendentName(String defendentName);
	List<CourtCase> findByCrimeType(String crimeType);
	List<CourtCase> findByArrestingOfficerName(String arrestingOfficerName);
	List<CourtCase> findByCrimeDate(LocalDate crimeDate);
	List<CourtCase> findByJudgeName(String judgeName);
	List<CourtCase> findByPublicProsecutorName(String publicProsecutorName);
	List<CourtCase> findByLawyerName(String lawyerName);
	List<CourtCase> findByCourtName(String courtName);
	List<CourtCase> findByStatus(String status);
}
