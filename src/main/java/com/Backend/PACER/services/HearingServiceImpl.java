package com.Backend.PACER.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Backend.PACER.entities.CourtCase;
import com.Backend.PACER.entities.Hearing;
import com.Backend.PACER.repositories.HearingRepository;
import com.Backend.PACER.services.interfaces.HearingService;

@Service
public class HearingServiceImpl implements HearingService{

	private HearingRepository hearingRepository;

	public HearingServiceImpl(HearingRepository hearingRepository) {
		this.hearingRepository = hearingRepository;
	}
	
	@Override
	public List<Hearing> hearingListOfCase(Long courtCaseCin){
		return hearingRepository.findByCourtCase_Cin(courtCaseCin);
	}
	
	@Override
	public Hearing addHearing(Hearing hearing) {
		return hearingRepository.save(hearing);
	}
}
