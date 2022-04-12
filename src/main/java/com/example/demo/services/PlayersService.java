package com.licenta.tmmbackend.services;

import com.licenta.tmmbackend.entity.CourtEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.licenta.tmmbackend.dao.Player;
import com.licenta.tmmbackend.entity.PlayerEntity;
import com.licenta.tmmbackend.repository.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayersService {
	
	private PlayerRepository playersRepository;
	private static final Logger log = LoggerFactory.getLogger(PlayersService.class);
	
	
	//constructor
	public PlayersService(PlayerRepository playerRepository) {

		this.playersRepository = playerRepository;
	}

	//post player
	public PlayerEntity processPostPlayer (Player player)
	{
		PlayerEntity playerEntity = new PlayerEntity(player);
		
		//verify age and favourite positive numbers
		if(player.getAge()<1 || player.getFavourite()<1)
		{
			throw new ResponseStatusException(
					 HttpStatus.BAD_REQUEST,  "Request body parameters Age and Favourite should be positive numbers.");
		}
	
		return playersRepository.save(playerEntity);
	}
	
	
	
	//put
	
	public PlayerEntity processPutPlayer(Integer id, Player player) {
		PlayerEntity playerEntity = playersRepository.findById(id).orElse(null);

		log.info("Value of playerEntity {} ", playerEntity);

		if (playerEntity == null) {
			return null;
		}
		

		//during a tournament the only pices of information I can modify are age(because it migth be someones birthday during the tournament) and couch
		//YOU CAN NEVER CHANGE ID 
		//You cannot modify someone's first or last name, the posibility of someone getting married during the tournament is too low
		//Even if you can change your nationality, during the tournament you cannot change the country you decided to play for
		//A player's ranking is modified ONLY after the tournaments ends
		//A player's favourite number is given at the beggining of the tournament and it cannot be modify during the tournament
		playerEntity.setAge(player.getAge());
		playerEntity.setCoach(player.getCoach());
				
		return playersRepository.save(playerEntity);
		
	}


	public Iterable<PlayerEntity> processGetPlayers() {
		return playersRepository.findAll();
	}

	public Iterable<PlayerEntity> processFindByFirstNameContaining(String firstName) {
		return playersRepository.findByFirstNameContaining(firstName);
	}

	public PlayerEntity processGetPlayer(Integer id) {
		return playersRepository.findById(id).orElse(null);
	}




}
