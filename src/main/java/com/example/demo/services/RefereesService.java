package com.licenta.tmmbackend.services;

import com.licenta.tmmbackend.dao.Player;
import com.licenta.tmmbackend.dao.Referee;
import com.licenta.tmmbackend.entity.PlayerEntity;
import com.licenta.tmmbackend.entity.RefereeEntity;
import com.licenta.tmmbackend.repository.RefereeRepository;
import org.springframework.stereotype.Service;

@Service
public class RefereesService {

	private RefereeRepository refereeRepository;

	public RefereesService(RefereeRepository refereeRepository) {
		this.refereeRepository = refereeRepository;
	}

	public RefereeEntity processPostReferee(Referee referee)
	{
		RefereeEntity refereeEntity= new RefereeEntity(referee);

		return refereeRepository.save(refereeEntity);

	}

	public RefereeEntity processPutReferee(Integer id, Referee referee) {
		RefereeEntity refereeEntity = refereeRepository.findById(id).orElse(null);

		//log.info("Value of playerEntity {} ", playerEntity);

		if (refereeEntity == null) {
			return null;
		}
		refereeEntity.setAge(referee.getAge());


		return refereeRepository.save(refereeEntity);

	}

	public RefereeEntity processGetReferee(Integer id) {
		return refereeRepository.findById(id).orElse(null);
	}

	public Iterable<RefereeEntity> processGetReferee() {
		return refereeRepository.findAll();
	}

	public Iterable<RefereeEntity> processFindByFirstNameContaining(String courtName) {
		return refereeRepository.findByFirstNameContaining(courtName);
	}



}
