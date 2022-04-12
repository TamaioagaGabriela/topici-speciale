package com.licenta.tmmbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.licenta.tmmbackend.entity.CourtEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CourtRepository extends JpaRepository<CourtEntity, Integer> {

	Iterable<CourtEntity> findByCourtNameContaining(String courtName);
}
