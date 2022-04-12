package com.licenta.tmmbackend.rest;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.licenta.tmmbackend.dao.TournamentMatch;

import com.licenta.tmmbackend.entity.TournamentMatchEntity;

import com.licenta.tmmbackend.services.TournamentMatchesService;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/tmm/api/v1/matches")
public class TournamentMatchesController {

	private static final Logger log = LoggerFactory.getLogger(PlayersController.class);
	public TournamentMatchesService tournamentMatchesService;


	public TournamentMatchesController(TournamentMatchesService tournamentMatchesService) {
		this.tournamentMatchesService = tournamentMatchesService;
	}



	//call the function from services to post a player
		@CrossOrigin(origins = "http://localhost:4200")
		@PostMapping()
		public ResponseEntity<TournamentMatchEntity> createMatch (@Valid @RequestBody TournamentMatch tournamentMatch)
		{
			//log.info shows message and the object player with its filds
			log.info("Received request to create maches: {}", tournamentMatch);
			if (tournamentMatch.getTour().equals(1)) {
                TournamentMatchEntity savedMatchEntity = tournamentMatchesService.processPostTournamentMatch(tournamentMatch);

				return new ResponseEntity<>(savedMatchEntity, HttpStatus.CREATED);
            }
			else
            {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Cannot add matches after tour 1");
            }


		}

//	@CrossOrigin(origins = "http://localhost:4200")
//	@PostMapping("/table")
//	public ResponseEntity<TournamentMatchEntity> createNewMatch (@RequestBody TournamentMatch tournamentMatch1, @RequestParam(required = false) TournamentMatch tournamentMatch2)
//	{
//		//log.info shows message and the object match with its filds
//		log.info("Received request to create maches(tablou): {}", tournamentMatch1);
//		log.info("Received request to create maches(): {}", tournamentMatch2);
//
//
//			TournamentMatchEntity savedMatchEntity = tournamentMatchesService.createMatch(tournamentMatch1,tournamentMatch2);
//			return new ResponseEntity<>(savedMatchEntity, HttpStatus.CREATED);
//
//	}


	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/table")
	public ResponseEntity<TournamentMatchEntity> createNewMatch (@Valid @RequestBody TournamentMatch match)
	{
		//log.info shows message and the object match with its filds
		log.info("Received request to create maches(tablou): {}", match);

		TournamentMatchEntity savedMatchEntity = tournamentMatchesService.createMatch(match);
		return new ResponseEntity<>(savedMatchEntity, HttpStatus.CREATED);
	}


	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping()
	public ResponseEntity<Iterable<TournamentMatchEntity>> getTournamentMatches(
			@RequestParam(required = false) String namePlayer1) {

		Iterable<TournamentMatchEntity> returnedTournamentMatchEntity;
		if (namePlayer1 == null) {
			log.info("Received request to get matches");
			returnedTournamentMatchEntity = tournamentMatchesService.processGetTournamentMatches();

		} else {
			log.info("Received request to get matches by name: " + namePlayer1);
			returnedTournamentMatchEntity = tournamentMatchesService.processFindByNamePlayer1Containing(namePlayer1);
		}
		if (returnedTournamentMatchEntity == null) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Matches not found in the database");
		}

		return new ResponseEntity<>(returnedTournamentMatchEntity, HttpStatus.OK);
	}



	//get match by id
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	public ResponseEntity<TournamentMatchEntity> getPlayer(@PathVariable Integer id) {
		log.info("Received request to get match with id: {}", id);
		TournamentMatchEntity returnedTournamentMatchEntity = tournamentMatchesService.processGetMatch(id);
		log.info("Created returnedTournamentMatchEntity with id: {}", id);
		if (returnedTournamentMatchEntity == null) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Match with campaign id: " + id + " not found in the database");
		}
		log.debug("before return");
		return new ResponseEntity<>(returnedTournamentMatchEntity, HttpStatus.OK);
	}


	//call the function from services to edit a match	//
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/{id}")
	public ResponseEntity<TournamentMatchEntity> editMatch(
			@PathVariable Integer id, @RequestBody TournamentMatch tournamentMatch) {
		log.info("Received request to edit match with id: {}", id);
		TournamentMatchEntity savedTournamentMatchEntity = tournamentMatchesService.processPutMatch(id, tournamentMatch);

		if (savedTournamentMatchEntity == null) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Match with id: " + id + " not found in the database");
		}

		return new ResponseEntity<>(savedTournamentMatchEntity, HttpStatus.OK);
	}






}
