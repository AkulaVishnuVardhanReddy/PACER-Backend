package com.Backend.PACER.services;

import java.util.List;

import com.Backend.PACER.entities.CaseAccessHistory;
import com.Backend.PACER.repositories.CaseAccessHistoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CaseAccessHistoryService {

	private final CaseAccessHistoryRepository caseAccessHistoryRepository;

	public CaseAccessHistoryService(CaseAccessHistoryRepository caseAccessHistoryRepository) {
		this.caseAccessHistoryRepository = caseAccessHistoryRepository;
	}

	public List<CaseAccessHistory> getByCaseId(Long caseId){
		return caseAccessHistoryRepository.findByUserId(caseId);
	}

	public CaseAccessHistory createCaseAccessHistory(CaseAccessHistory history) {
		return caseAccessHistoryRepository.save(history);
	}

	public void deleteCaseAccessHistoryByUserId(long userId) {
		caseAccessHistoryRepository.deleteByUserId(userId);
	}
}