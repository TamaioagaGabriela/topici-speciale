package com.licenta.tmmbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.licenta.tmmbackend.entity.PlayerEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Integer> {

	Iterable<PlayerEntity> findByFirstNameContaining(String firstName);

}
