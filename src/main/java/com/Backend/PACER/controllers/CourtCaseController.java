package com.Backend.PACER.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.PACER.entities.CourtCase;
import com.Backend.PACER.services.CourtCaseService;

@RestController

public class CourtCaseController {
	
	private CourtCaseService courtCaseService;

	public CourtCaseController(CourtCaseService courtCaseService) {
		this.courtCaseService = courtCaseService;
	}
	
	@GetMapping("/lawyer/name")
	public ResponseEntity<String> getLawyer(){
		return ResponseEntity.ok("this lawyer");
	}

	
	@GetMapping("/court-cases")
	public List<CourtCase> getAllCourtCases(){
		return courtCaseService.getAllCourtCases();
	}
	
	@GetMapping("/court-cases/lawyer/{name}")
	public List<CourtCase> getByLawyerName(@PathVariable String name){
		return courtCaseService.getByLawyerName(name);
	}
	
	@GetMapping("/court-cases/court/{name}")
	public List<CourtCase> getByCourtName(@PathVariable String name){
		return courtCaseService.getByCourtName(name);
	}
	
	@GetMapping("/court-cases/judge/{name}")
	public List<CourtCase> getByJudgeName(@PathVariable String name){
		return courtCaseService.getByJudgeName(name);
	}
	
	@GetMapping("/court-cases/defendent/{name}")
	public List<CourtCase> getByDefendentName(@PathVariable String name){
		return courtCaseService.getByDefendentName(name);
	}
	
	@GetMapping("/court-cases/public-prosecutor/{name}")
	public List<CourtCase> getByPublicProsecutorName(@PathVariable String name){
		return courtCaseService.getByPublicProsecutorName(name);
	}
	
	@GetMapping("/court-cases/arresting-officer/{name}")
	public List<CourtCase> getByArrestingOfficerName(@PathVariable String name){
		return courtCaseService.getByArrestingOfficerName(name);
	}
	
	@GetMapping("/court-cases/crime-type/{type}")
	public List<CourtCase> getByCrimeType(@PathVariable String type){
		return courtCaseService.getByCrimeType(type);
	}
	
	@GetMapping("/court-cases/crime-date/{datestr}")
	public ResponseEntity<List<CourtCase>> getByCrimeDate(@PathVariable String datestr) {
	    try {
	        LocalDate date = LocalDate.parse(datestr); 
	        List<CourtCase> courtCases = courtCaseService.getByCrimeDate(date);

	        if (courtCases.isEmpty()) {
	            return ResponseEntity.noContent().build(); 
	        }
	        return ResponseEntity.ok(courtCases); 
	    } catch (DateTimeParseException e) {
	        return ResponseEntity.badRequest().body(null); 
	    }
	}

}
