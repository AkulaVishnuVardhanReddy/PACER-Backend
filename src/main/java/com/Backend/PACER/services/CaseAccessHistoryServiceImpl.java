package com.Backend.PACER.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Backend.PACER.entities.CaseAccessHistory;
import com.Backend.PACER.repositories.CaseAccessHistoryRepository;
import com.Backend.PACER.services.interfaces.CaseAccessHistoryService;

@Service
public class CaseAccessHistoryServiceImpl implements CaseAccessHistoryService {

	private CaseAccessHistoryRepository caseAccessHistoryRepository;

	public CaseAccessHistoryServiceImpl(CaseAccessHistoryRepository caseAccessHistoryRepository) {
		this.caseAccessHistoryRepository = caseAccessHistoryRepository;
	}
	
	@Override
	public List<CaseAccessHistory> getByCaseId(Long caseId){
		return caseAccessHistoryRepository.findByUserId(caseId);
	}
	
	@Override
	public CaseAccessHistory createCaseAccessHistory(CaseAccessHistory history) {
		return caseAccessHistoryRepository.save(history);
	}
}
