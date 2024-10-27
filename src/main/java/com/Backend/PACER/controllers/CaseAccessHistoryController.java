package com.Backend.PACER.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.PACER.entities.CaseAccessHistory;
import com.Backend.PACER.services.interfaces.CaseAccessHistoryService;

@RestController
public class CaseAccessHistoryController {
	
	private CaseAccessHistoryService caseAccessHistoryService;

	public CaseAccessHistoryController(CaseAccessHistoryService caseAccessHistoryService) {
		this.caseAccessHistoryService = caseAccessHistoryService;
	}
	
	@GetMapping("/case-history/{userId}")
	public List<CaseAccessHistory> getCaseAccessHistory(@PathVariable Long userId){
		return caseAccessHistoryService.getByCaseId(userId);
	}
	
	@PostMapping("/case-history")
	public CaseAccessHistory createHistory(@RequestBody CaseAccessHistory history) {
		return caseAccessHistoryService.createCaseAccessHistory(history);
	}
}
