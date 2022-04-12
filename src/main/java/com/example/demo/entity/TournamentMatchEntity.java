package com.licenta.tmmbackend.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.*;

import com.licenta.tmmbackend.dao.TournamentMatch;
import com.licenta.tmmbackend.enums.MatchType;
import com.licenta.tmmbackend.enums.Status;


@Entity
@Table(name = "tournament_match")
public class TournamentMatchEntity {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false, updatable = false)
	private int id;


	@Column(name = "name_player_one")
	private String namePlayer1;


	@Column(name = "name_player_two")
	private String namePlayer2;

	@Column(name = "name_player_three")
	private String namePlayer3;

	@Column(name = "name_player_four")
	private String namePlayer4;

	@Column(name = "match_date")
	private LocalDateTime matchDate;

	@Column(name = "match_type")
	@Enumerated(EnumType.STRING)
	private MatchType matchType;

	@Column(name = "tour")
	private Integer tour;

	@Column(name = "court_name")
	private String  courtName;

	@Column(name = "referee_name")
	private String refereeName;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status status;

	@Column(name = "winner")
	private String winner;

	@Column(name="score")
	private String score;

	public TournamentMatchEntity() {
		// TODO Auto-generated constructor stub
	}

	public TournamentMatchEntity(TournamentMatch tournamentMatch){
		//this.id=tournamentMatch.getId();
		this.courtName=tournamentMatch.getCourtName();
		this.namePlayer1=tournamentMatch.getNamePlayer1();
		this.namePlayer2=tournamentMatch.getNamePlayer2();
		this.namePlayer3=tournamentMatch.getNamePlayer3();
		this.namePlayer4=tournamentMatch.getNamePlayer4();
		this.matchDate=tournamentMatch.getMatchDate();
		this.matchType=tournamentMatch.getMatchType();
		this.refereeName=tournamentMatch.getRefereeName();
		this.status=tournamentMatch.getStatus();
		this.tour=tournamentMatch.getTour();
		this.winner=tournamentMatch.getWinner();
		this.score=tournamentMatch.getScore();
	}


	public TournamentMatchEntity(int id, String namePlayer1, String namePlayer2, String namePlayer3, String namePlayer4, LocalDateTime matchDate, MatchType matchType, Integer tour, String courtName, String refereeName, Status status, String winner, String score) {
		this.id = id;
		this.namePlayer1 = namePlayer1;
		this.namePlayer2 = namePlayer2;
		this.namePlayer3 = namePlayer3;
		this.namePlayer4 = namePlayer4;
		this.matchDate = matchDate;
		this.matchType = matchType;
		this.tour = tour;
		this.courtName = courtName;
		this.refereeName = refereeName;
		this.status = status;
		this.winner = winner;
		this.score=score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNamePlayer1() {
		return namePlayer1;
	}

	public void setNamePlayer1(String namePlayer1) {
		this.namePlayer1 = namePlayer1;
	}

	public String getNamePlayer2() {
		return namePlayer2;
	}

	public void setNamePlayer2(String namePlayer2) {
		this.namePlayer2 = namePlayer2;
	}

	public String getNamePlayer3() {
		return namePlayer3;
	}

	public void setNamePlayer3(String namePlayer3) {
		this.namePlayer3 = namePlayer3;
	}

	public String getNamePlayer4() {
		return namePlayer4;
	}

	public void setNamePlayer4(String namePlayer4) {
		this.namePlayer4 = namePlayer4;
	}

	public LocalDateTime getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(LocalDateTime matchDate) {
		this.matchDate = matchDate;
	}

	public MatchType getMatchType() {
		return matchType;
	}

	public void setMatchType(MatchType matchType) {
		this.matchType = matchType;
	}

	public Integer getTour() {
		return tour;
	}

	public void setTour(Integer tour) {
		this.tour = tour;
	}

	public String getCourtName() {
		return courtName;
	}

	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}

	public String getRefereeName() {
		return refereeName;
	}

	public void setRefereeName(String refereeName) {
		this.refereeName = refereeName;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TournamentMatchEntity)) return false;
		TournamentMatchEntity that = (TournamentMatchEntity) o;
		return getId() == that.getId() &&
				getNamePlayer1().equals(that.getNamePlayer1()) &&
				getNamePlayer2().equals(that.getNamePlayer2()) &&
				getNamePlayer3().equals(that.getNamePlayer3()) &&
				getNamePlayer4().equals(that.getNamePlayer4()) &&
				getMatchDate().equals(that.getMatchDate()) &&
				getMatchType() == that.getMatchType() &&
				getTour().equals(that.getTour()) &&
				getCourtName().equals(that.getCourtName()) &&
				getRefereeName().equals(that.getRefereeName()) &&
				getStatus() == that.getStatus() &&
				getWinner().equals(that.getWinner());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getNamePlayer1(), getNamePlayer2(), getNamePlayer3(), getNamePlayer4(), getMatchDate(), getMatchType(), getTour(), getCourtName(), getRefereeName(), getStatus(), getWinner(), score);
	}
}
