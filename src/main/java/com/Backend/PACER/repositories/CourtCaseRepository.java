package com.Backend.PACER.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Backend.PACER.entities.CourtCase;

public interface CourtCaseRepository extends JpaRepository<CourtCase, Long> {

}
