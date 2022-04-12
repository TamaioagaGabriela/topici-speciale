package com.licenta.tmmbackend.rest;

import javax.validation.Valid;

import com.licenta.tmmbackend.entity.CourtEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.ResponseEntity;
import com.licenta.tmmbackend.dao.Player;
import com.licenta.tmmbackend.entity.PlayerEntity;
import com.licenta.tmmbackend.services.PlayersService;


@RestController
@RequestMapping("/tmm/api/v1/players")
public class PlayersController {
	
	//create object log (type logger) to show info about requests
	private static final Logger log = LoggerFactory.getLogger(PlayersController.class);
	public PlayersService playersService;

	public PlayersController(PlayersService playersService) {
		this.playersService = playersService;
	}
	
	//call the function from services to post a player
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping()
	public ResponseEntity<PlayerEntity> createPlayer (@Valid @RequestBody Player player)
	{
		//log.info shows message and the object player with its filds
		log.info("Received request to create players: {}", player);
		PlayerEntity savedPlayerEntity = playersService.processPostPlayer(player);

		return new ResponseEntity<>(savedPlayerEntity, HttpStatus.CREATED);
	}
	
	//call the function from services to edit a player	//
	 @CrossOrigin(origins = "http://localhost:4200")
	 @PutMapping("/{id}")
	  public ResponseEntity<PlayerEntity> editPlayer(
	      @PathVariable Integer id, @RequestBody Player player) {
	    log.info("Received request to edit player with id: {}", id);
	    PlayerEntity savedPlayerEntity = playersService.processPutPlayer(id, player);

	    if (savedPlayerEntity == null) {
	      throw new ResponseStatusException(
	          HttpStatus.NOT_FOUND, "Player with id: " + id + " not found in the database");
	    }

	    return new ResponseEntity<>(savedPlayerEntity, HttpStatus.OK);
	  }
	 
	 
	 //get player by name
	 //schimb numele cu getPlayersByName si getPlayersById
	 //get court by name
	 @CrossOrigin(origins = "http://localhost:4200")
	 @GetMapping()
	 public ResponseEntity<Iterable<PlayerEntity>> getPlayers(
			 @RequestParam(required = false) String name) {

		 Iterable<PlayerEntity> returnedPlayerEntity;
		 if (name == null) {
			 log.info("Received request to get players");
			 returnedPlayerEntity = playersService.processGetPlayers();
		 } else {
			 log.info("Received request to get players by name: " + name);
			 returnedPlayerEntity = playersService.processFindByFirstNameContaining(name);
		 }
		 if (returnedPlayerEntity == null) {
			 throw new ResponseStatusException(
					 HttpStatus.NOT_FOUND, "Player not found in the database");
		 }

		 return new ResponseEntity<>(returnedPlayerEntity, HttpStatus.OK);
	 }

	//get player by id
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	public ResponseEntity<PlayerEntity> getPlayer(@PathVariable Integer id) {
		log.info("Received request to get player with id: {}", id);
		PlayerEntity returnedPlayerEntity = playersService.processGetPlayer(id);
		log.info("Created returnedPlayerEntity with id: {}", id);
		if (returnedPlayerEntity == null) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Player with campaign id: " + id + " not found in the database");
		}
		log.debug("before return");
		return new ResponseEntity<>(returnedPlayerEntity, HttpStatus.OK);
	}


}
