package com.licenta.tmmbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.licenta.tmmbackend.entity.PlayerEntity;
import com.licenta.tmmbackend.entity.RefereeEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface RefereeRepository extends JpaRepository<RefereeEntity, Integer> {

	Iterable<RefereeEntity> findByFirstNameContaining(String firstName);

}
