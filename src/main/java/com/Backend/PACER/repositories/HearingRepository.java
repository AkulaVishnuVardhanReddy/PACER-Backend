package com.Backend.PACER.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Backend.PACER.entities.Hearing;

public interface HearingRepository extends JpaRepository<Hearing,Long>{

}
