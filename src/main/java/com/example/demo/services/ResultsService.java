package com.licenta.tmmbackend.services;

import com.licenta.tmmbackend.dao.Referee;
import com.licenta.tmmbackend.dao.Result;
import com.licenta.tmmbackend.entity.CourtEntity;
import com.licenta.tmmbackend.entity.RefereeEntity;
import com.licenta.tmmbackend.entity.ResultEntity;
import com.licenta.tmmbackend.repository.RefereeRepository;
import com.licenta.tmmbackend.repository.ResultRepository;
import org.springframework.stereotype.Service;

@Service
public class ResultsService {

	private ResultRepository resultRepository;

	public ResultsService(ResultRepository resultRepository) {
		this.resultRepository = resultRepository;
	}

	public ResultEntity processPostResult(Result result)
	{
		ResultEntity resultEntity= new ResultEntity(result);

		return resultRepository.save(resultEntity);

	}

	public Iterable<ResultEntity> processGetResults() {
		return resultRepository.findAll();
	}

	public Iterable<ResultEntity> processFindByWinner1NameContaining(String winner1Name) {
		return resultRepository.findByWinner1NameContaining(winner1Name);
	}

}
