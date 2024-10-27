package com.Backend.PACER.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Backend.PACER.entities.CourtCase;
import com.Backend.PACER.repositories.CourtCaseRepository;
import com.Backend.PACER.services.interfaces.CourtCaseService;

@Service
public class CourtCaseServiceImpl implements CourtCaseService{
	
	private CourtCaseRepository courtCaseRepository;
	
	public CourtCaseServiceImpl(CourtCaseRepository courtCaseRepository) {
		this.courtCaseRepository = courtCaseRepository;
	}
	
	@Override
	public List<CourtCase> listPendingCases(String status){
		return courtCaseRepository.findByStatus("pending");
	}

	@Override
	public List<CourtCase> listResolvedCases(String status){
		return courtCaseRepository.findByStatus("resolved");
	}
	
	@Override
	public List<CourtCase> getByLawyerName(String lawyerName){
		return courtCaseRepository.findByLawyerName(lawyerName);
	}
	
	@Override
	public List<CourtCase> getByDefendentName(String defendentName){
		return courtCaseRepository.findByDefendentName(defendentName);
	}
	
	@Override
	public List<CourtCase> getByCourtName(String courtName){
		return courtCaseRepository.findByCourtName(courtName);
	}

	@Override
	public List<CourtCase> getByArrestingOfficerName(String arrestingOfficerName){
		return courtCaseRepository.findByArrestingOfficerName(arrestingOfficerName);
	}

	@Override
	public List<CourtCase> getByCrimeType(String crimeType){
		return courtCaseRepository.findByCrimeType(crimeType);
	}
	
	@Override
	public List<CourtCase> getByPublicProsecutorName(String prosecutorName){
		return courtCaseRepository.findByPublicProsecutorName(prosecutorName);
	}
	
	@Override
	public List<CourtCase> getByJudgeName(String judgeName){
		return courtCaseRepository.findByJudgeName(judgeName);
	}
	
	@Override
	public List<CourtCase> getByCrimeDate(LocalDate crimeDate){
		return courtCaseRepository.findByCrimeDate(crimeDate);
	}
	
	@Override
	public CourtCase createCourtCase(CourtCase courtCase) {
		return courtCaseRepository.save(courtCase);
	}
	
	@Override
	public List<CourtCase> getAllCourtCases(){
		return courtCaseRepository.findAll();
	}
	
	@Override
	public CourtCase updateStatus(Long cin ,String status) {
		Optional<CourtCase> courtCaseOptional = courtCaseRepository.findById(cin);
		if(courtCaseOptional.isPresent()) {
			CourtCase courtCase = courtCaseOptional.get();
			courtCase.setStatus(status);
			return courtCaseRepository.save(courtCase);
		}
		else {
			throw new IllegalArgumentException("CourtCase with CIN "+cin+" not found");
		}
	}
}
