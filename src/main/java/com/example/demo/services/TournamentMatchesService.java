package com.licenta.tmmbackend.services;

import com.licenta.tmmbackend.enums.MatchType;
import com.licenta.tmmbackend.enums.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.licenta.tmmbackend.dao.TournamentMatch;
import com.licenta.tmmbackend.entity.TournamentMatchEntity;
import com.licenta.tmmbackend.repository.TournamentMatchRepository;

import java.time.LocalDateTime;

@Service
public class TournamentMatchesService {

	private TournamentMatchRepository tournamentMatchRepository;


	public TournamentMatchesService(TournamentMatchRepository tournamentMatchRepository) {
		this.tournamentMatchRepository = tournamentMatchRepository;
	}

	private static final Logger log = LoggerFactory.getLogger(PlayersService.class);


	public TournamentMatchEntity processPostTournamentMatch (TournamentMatch tournamentMatch)
	{
		TournamentMatchEntity tournamentMatchEntity = new TournamentMatchEntity(tournamentMatch);

		//verify tour is 1
		if(tournamentMatch.getTour()!=1)
		{
			throw new ResponseStatusException(
					 HttpStatus.BAD_REQUEST,  "You cannot add matches after tour 1.");
		}

		return tournamentMatchRepository.save(tournamentMatchEntity);
	}



//	public TournamentMatchEntity createMatch (TournamentMatch tournamentMatch1, TournamentMatch tournamentMatch2){
//		TournamentMatchEntity tournamentMatch = new TournamentMatchEntity(tournamentMatch1);
//		log.info("primesc"+tournamentMatch1,tournamentMatch2);
//		tournamentMatch.setNamePlayer1(tournamentMatch1.getWinner());
//		tournamentMatch.setNamePlayer2(tournamentMatch2.getWinner());
//		LocalDateTime generatedDate = LocalDateTime.now();
//		tournamentMatch.setMatchDate(generatedDate);
//		MatchType simpleMatch = MatchType.SIMPLE;
//		tournamentMatch.setMatchType(simpleMatch);
//		tournamentMatch.setTour(tournamentMatch1.getTour()+1);
//		tournamentMatch.setCourtName("courtName");
//		tournamentMatch.setRefereeName("refereeName");
//		Status status = Status.SCHEDULED;
//		tournamentMatch.setStatus(status);
//		tournamentMatch.setWinner(null);
//
//		return tournamentMatchRepository.save(tournamentMatch);
//
//	}

	public TournamentMatchEntity createMatch (TournamentMatch match){
		TournamentMatchEntity tournamentMatch = new TournamentMatchEntity();
		log.info("primesc"+match);
//		tournamentMatch.setNamePlayer1(match.getTournamentMatch1().getWinner());
//		tournamentMatch.setNamePlayer2(match.getTournamentMatch2().getWinner());
		LocalDateTime generatedDate = LocalDateTime.now();
		tournamentMatch.setMatchDate(generatedDate);
		MatchType simpleMatch = MatchType.SIMPLE;
		tournamentMatch.setMatchType(simpleMatch);
//		tournamentMatch.setTour(match.getTournamentMatch1().getTour()+1);
		tournamentMatch.setCourtName("courtName");
		tournamentMatch.setRefereeName("refereeName");
		Status status = Status.SCHEDULED;
		tournamentMatch.setStatus(status);
		tournamentMatch.setWinner(null);

		return tournamentMatchRepository.save(tournamentMatch);

	}

	//get one match by id
	public TournamentMatchEntity processGetMatch(Integer id) {
		return tournamentMatchRepository.findById(id).orElse(null);
	}

	public Iterable<TournamentMatchEntity> processGetTournamentMatches() {
		return tournamentMatchRepository.findAll();
	}

	public Iterable<TournamentMatchEntity> processFindByNamePlayer1Containing(String playerName) {
		return tournamentMatchRepository.findByNamePlayer1Containing(playerName);
	}




	//put

	public TournamentMatchEntity processPutMatch(Integer id, TournamentMatch tournamentMatch) {
		TournamentMatchEntity tournamentMatchEntity = tournamentMatchRepository.findById(id).orElse(null);

		log.info("Value of tournamentMatchEntity {} ", tournamentMatchEntity);

		if (tournamentMatchEntity == null) {
			return null;
		}

		tournamentMatchEntity.setStatus(tournamentMatch.getStatus());
		tournamentMatchEntity.setWinner(tournamentMatch.getWinner());

		return tournamentMatchRepository.save(tournamentMatchEntity);

	}


}
