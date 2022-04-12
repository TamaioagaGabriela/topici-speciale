package com.licenta.tmmbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.licenta.tmmbackend.entity.TournamentMatchEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentMatchRepository extends JpaRepository<TournamentMatchEntity, Integer> {

	Iterable<TournamentMatchEntity> findByNamePlayer1Containing(String namePlayer1);



}
