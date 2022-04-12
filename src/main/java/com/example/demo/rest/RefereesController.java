package com.licenta.tmmbackend.rest;

import javax.validation.Valid;

import com.licenta.tmmbackend.entity.PlayerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.licenta.tmmbackend.dao.Player;
import com.licenta.tmmbackend.dao.Referee;
import com.licenta.tmmbackend.entity.RefereeEntity;
import com.licenta.tmmbackend.services.RefereesService;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/tmm/api/v1/referees")
public class RefereesController {

	private static final Logger log = LoggerFactory.getLogger(RefereesController.class);
	public RefereesService refereeService;
	public RefereesController(RefereesService refereeService) {
		super();
		this.refereeService = refereeService;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping()
	public ResponseEntity<RefereeEntity> createReferee(@Valid @RequestBody Referee referee)
	{
		log.info("Received request to create referee: {}", referee);
		RefereeEntity savedRefereeEntity=refereeService.processPostReferee(referee);
		return new ResponseEntity<>(savedRefereeEntity, HttpStatus.CREATED);
	}
	//get court by name
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping()
	public ResponseEntity<Iterable<RefereeEntity>> getReferees(
			@RequestParam(required = false) String name) {

		Iterable<RefereeEntity> returnedRefereeEntity;
		if (name == null) {
			log.info("Received request to get referees");
			returnedRefereeEntity = refereeService.processGetReferee();
		} else {
			log.info("Received request to get referees by name: " + name);
			returnedRefereeEntity = refereeService.processFindByFirstNameContaining(name);
		}
		if (returnedRefereeEntity == null) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Court not found in the database");
		}

		return new ResponseEntity<>(returnedRefereeEntity, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/{id}")
	public ResponseEntity<RefereeEntity> editReferee(
			@PathVariable Integer id, @RequestBody Referee referee) {
		log.info("Received request to edit referee with id: {}", id);
		RefereeEntity savedRefereeEntity = refereeService.processPutReferee(id, referee);

		if (savedRefereeEntity == null) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Referee with id: " + id + " not found in the database");
		}

		return new ResponseEntity<>(savedRefereeEntity, HttpStatus.OK);
	}


	//get player by id
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	public ResponseEntity<RefereeEntity> getReferee(@PathVariable Integer id) {
		log.info("Received request to get referee with id: {}", id);
		RefereeEntity returnedRefereeEntity = refereeService.processGetReferee(id);
		log.info("Created returnedRefereeEntity with id: {}", id);
		if (returnedRefereeEntity == null) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Referee with campaign id: " + id + " not found in the database");
		}
		log.debug("before return");
		return new ResponseEntity<>(returnedRefereeEntity, HttpStatus.OK);
	}

}
