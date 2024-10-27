package com.Backend.PACER.services.interfaces;

import java.util.List;

import com.Backend.PACER.entities.CaseAccessHistory;

public interface CaseAccessHistoryService {
	List<CaseAccessHistory> getByCaseId(Long caseId);
	CaseAccessHistory createCaseAccessHistory(CaseAccessHistory history);
}
