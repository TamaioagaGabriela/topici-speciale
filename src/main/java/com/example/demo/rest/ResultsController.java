package com.licenta.tmmbackend.rest;

import javax.validation.Valid;

import com.licenta.tmmbackend.entity.CourtEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.licenta.tmmbackend.dao.Referee;
import com.licenta.tmmbackend.dao.Result;
import com.licenta.tmmbackend.entity.RefereeEntity;
import com.licenta.tmmbackend.entity.ResultEntity;
import com.licenta.tmmbackend.services.RefereesService;
import com.licenta.tmmbackend.services.ResultsService;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/tmm/api/v1/results")
public class ResultsController {

	private static final Logger log = LoggerFactory.getLogger(ResultsController.class);
	public ResultsService resultService;

	public ResultsController(ResultsService resultsService) {
		this.resultService = resultsService;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping()
	public ResponseEntity<ResultEntity> createReferee(@Valid @RequestBody Result result)
	{
		log.info("Received request to create result: {}", result);
		ResultEntity savedResultEntity=resultService.processPostResult(result);
		return new ResponseEntity<>(savedResultEntity, HttpStatus.CREATED);
	}


	//get court by name
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping()
	public ResponseEntity<Iterable<ResultEntity>> getResults(
			@RequestParam(required = false) String winner1Name) {

		Iterable<ResultEntity> returnedResultEntity;
		if (winner1Name == null) {
			log.info("Received request to get results");
			returnedResultEntity = resultService.processGetResults();
			log.info("rez" + returnedResultEntity);
		} else {
			log.info("Received request to get courts by winner name: " + winner1Name);
			returnedResultEntity = resultService.processFindByWinner1NameContaining(winner1Name);
		}
		if (returnedResultEntity == null) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Court not found in the database");
		}

		return new ResponseEntity<>(returnedResultEntity, HttpStatus.OK);
	}




}