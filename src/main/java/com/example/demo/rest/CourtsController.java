package com.licenta.tmmbackend.rest;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.licenta.tmmbackend.dao.Court;
import com.licenta.tmmbackend.dao.Player;
import com.licenta.tmmbackend.entity.CourtEntity;
import com.licenta.tmmbackend.entity.PlayerEntity;
import com.licenta.tmmbackend.services.CourtsService;
import com.licenta.tmmbackend.services.PlayersService;


@RestController
@RequestMapping("/tmm/api/v1/courts")
public class CourtsController {

	//create object log (type logger) to show info about requests
		private static final Logger log = LoggerFactory.getLogger(CourtsController.class);
		public CourtsService courtsService;

		public CourtsController(CourtsService courtsService) {
			this.courtsService = courtsService;
		}

		//call the function from services to post a court
		@CrossOrigin(origins = "http://localhost:4200")
		@PostMapping()
		public ResponseEntity<CourtEntity> createCourt (@Valid @RequestBody Court court)
		{
			//log.info shows message and the object player with its filds
			log.info("Received request to create court: {}", court);
			CourtEntity savedCourtEntity = courtsService.processPostCourts(court);

			return new ResponseEntity<>(savedCourtEntity, HttpStatus.CREATED);
		}

		//get court by name
		 @CrossOrigin(origins = "http://localhost:4200")
		  @GetMapping()
		  public ResponseEntity<Iterable<CourtEntity>> getCourts(
		      @RequestParam(required = false) String name) {

		    Iterable<CourtEntity> returnedCourtEntity;
		    if (name == null) {
		      log.info("Received request to get courts");
		      returnedCourtEntity = courtsService.processGetCourts();
		    } else {
		      log.info("Received request to get courts by name: " + name);
		      returnedCourtEntity = courtsService.processFindByCourtNameContaining(name);
		    }
		    if (returnedCourtEntity == null) {
		      throw new ResponseStatusException(
		          HttpStatus.NOT_FOUND, "Court not found in the database");
		    }

		    return new ResponseEntity<>(returnedCourtEntity, HttpStatus.OK);
		  }


	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/{id}")
	public ResponseEntity<CourtEntity> editCourt(
			@PathVariable Integer id, @RequestBody Court court) {
		log.info("Received request to edit court with id: {}", id);
		CourtEntity savedCourtEntity = courtsService.processPutCourt(id, court);

		if (savedCourtEntity == null) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Court with id: " + id + " not found in the database");
		}

		return new ResponseEntity<>(savedCourtEntity, HttpStatus.OK);
	}


}
