package com.Backend.PACER.services.interfaces;

import java.time.LocalDate;
import java.util.List;

import com.Backend.PACER.entities.CourtCase;

public interface CourtCaseService {
	List<CourtCase> listPendingCases(String status);
	List<CourtCase> listResolvedCases(String status);
	List<CourtCase> getByLawyerName(String lawyerName);
	List<CourtCase> getByDefendentName(String defendentName);
	List<CourtCase> getByCourtName(String courtName);
	List<CourtCase> getByArrestingOfficerName(String arrestingOfficerName);
	List<CourtCase> getByCrimeType(String crimeType);
	List<CourtCase> getByPublicProsecutorName(String prosecutorName);
	List<CourtCase> getByJudgeName(String judgeName);
	List<CourtCase> getByCrimeDate(LocalDate crimeDate);
	CourtCase createCourtCase(CourtCase courtCase);
	List<CourtCase> getAllCourtCases();
	CourtCase updateStatus(Long cin ,String status);
	
}
