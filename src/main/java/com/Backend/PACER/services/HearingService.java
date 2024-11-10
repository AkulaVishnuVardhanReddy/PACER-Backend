package com.Backend.PACER.services;

import java.util.List;

import com.Backend.PACER.entities.Hearing;
import com.Backend.PACER.repositories.HearingRepository;
import org.springframework.stereotype.Service;

@Service
public class HearingService{

	private final HearingRepository hearingRepository;

	public HearingService(HearingRepository hearingRepository) {
		this.hearingRepository = hearingRepository;
	}

	public List<Hearing> hearingListOfCase(Long courtCaseCin){
		return hearingRepository.findByCourtCase_Cin(courtCaseCin);
	}

	public Hearing addHearing(Hearing hearing) {
		return hearingRepository.save(hearing);
	}

	public List<Hearing> findByKeyword(String keyword){
		return hearingRepository.findByProcedingSummaryContainingKeyword(keyword);
	}
}