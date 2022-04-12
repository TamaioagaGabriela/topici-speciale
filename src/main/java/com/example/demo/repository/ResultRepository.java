package com.licenta.tmmbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.licenta.tmmbackend.entity.RefereeEntity;
import com.licenta.tmmbackend.entity.ResultEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<ResultEntity, Integer> {

	Iterable<ResultEntity> findByWinner1NameContaining(String winner1Name);

}
