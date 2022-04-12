package com.licenta.tmmbackend.services;

import com.licenta.tmmbackend.enums.Avalability;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.licenta.tmmbackend.dao.Court;
import com.licenta.tmmbackend.dao.Player;
import com.licenta.tmmbackend.entity.CourtEntity;
import com.licenta.tmmbackend.entity.PlayerEntity;
import com.licenta.tmmbackend.repository.CourtRepository;
import org.springframework.stereotype.Service;

@Service
public class CourtsService {

	private CourtRepository courtRepository;


	//constructor
	public CourtsService(CourtRepository courtRepository) {
		this.courtRepository = courtRepository;
	}

	//post court
		public CourtEntity processPostCourts (Court court)
		{
			CourtEntity courtEntity = new CourtEntity(court);

			//verify capacity positive number
			if(court.getCapacity()<0)
			{
				throw new ResponseStatusException(
						 HttpStatus.BAD_REQUEST,  "Request body parameter Capacity should be positive number.");
			}

			return courtRepository.save(courtEntity);
		}



		public Iterable<CourtEntity> processGetCourts() {
			return courtRepository.findAll();
		}

		public Iterable<CourtEntity> processFindByCourtNameContaining(String courtName) {
			return courtRepository.findByCourtNameContaining(courtName);
		}


	//put

	public CourtEntity processPutCourt(Integer id, Court court) {
		CourtEntity courtEntity = courtRepository.findById(id).orElse(null);

		//log.info("Value of playerEntity {} ", courtEntity);

		if (courtEntity == null) {
			return null;
		}

		Avalability avalability = Avalability.avalable;
		Avalability unavalability = Avalability.unavalable;
		if(court.getAvalability()== avalability)
		{
			courtEntity.setAvalability(unavalability);
		}
		else
		{
			courtEntity.setAvalability(avalability);
		}


		return courtRepository.save(courtEntity);

	}



}
