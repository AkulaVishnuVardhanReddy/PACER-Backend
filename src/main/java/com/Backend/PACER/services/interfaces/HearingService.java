package com.Backend.PACER.services.interfaces;

import java.util.List;

import com.Backend.PACER.entities.Hearing;

public interface HearingService {
	List<Hearing> hearingListOfCase(Long courtCaseCin);
	Hearing addHearing(Hearing hearing);
}
