package com.Backend.PACER.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Backend.PACER.entities.Hearing;

public interface HearingRepository extends JpaRepository<Hearing,Long>{
	
	List<Hearing> findByCourtCase_Cin(Long courtCaseCin);
}
