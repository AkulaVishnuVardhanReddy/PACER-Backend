package com.Backend.PACER.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Backend.PACER.entities.ScheduleSlot;

public interface ScheduleSlotRepository extends JpaRepository<ScheduleSlot, Long> {

}
