package com.Backend.PACER.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.PACER.entities.Hearing;
import com.Backend.PACER.services.interfaces.HearingService;

@RestController
public class HearingController {

	private HearingService hearingService;

	public HearingController(HearingService hearingService) {
		this.hearingService = hearingService;
	}
	
	@PostMapping("/cases/hearing")
	public Hearing addHearing(@RequestBody Hearing hearing) {
		return hearingService.addHearing(hearing);
	}
	
	@GetMapping("/cases/hearing/{cin}")
	public List<Hearing> getByCin(@PathVariable Long cin){
		return hearingService.hearingListOfCase(cin);
	}
	
	
}
