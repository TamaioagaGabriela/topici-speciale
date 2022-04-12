package com.licenta.tmmbackend.dao;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotNull;

import com.licenta.tmmbackend.enums.MatchType;
import com.licenta.tmmbackend.enums.Position;
import com.licenta.tmmbackend.enums.Status;

public class TournamentMatch {

	@NotNull private String namePlayer1;
	@NotNull private String namePlayer2;
			 private String namePlayer3;
			 private String namePlayer4;
	@NotNull private LocalDateTime matchDate;
	@NotNull private MatchType matchType;
	@NotNull private Integer tour;
	@NotNull private String courtName;
	@NotNull private String refereeName;
	@NotNull private Status status;
			 private String winner;
			 private String score;



	public TournamentMatch() {
		super();
		// TODO Auto-generated constructor stub
	}



	public TournamentMatch(String namePlayer1, String namePlayer2,
						   String namePlayer3, String namePlayer4, LocalDateTime matchDate,
						   MatchType matchType, Integer tour, String courtName,
						   String refereeName, Status status, String winner, String score) {
		super();

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
		this.winner =winner;
		this.score=score;
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
		if (!(o instanceof TournamentMatch)) return false;
		TournamentMatch that = (TournamentMatch) o;
		return getNamePlayer1().equals(that.getNamePlayer1()) &&
				getNamePlayer2().equals(that.getNamePlayer2()) &&
				getNamePlayer3().equals(that.getNamePlayer3()) &&
				getNamePlayer4().equals(that.getNamePlayer4()) &&
				getMatchDate().equals(that.getMatchDate()) &&
				getMatchType() == that.getMatchType() &&
				getTour().equals(that.getTour()) &&
				getCourtName().equals(that.getCourtName()) &&
				getRefereeName().equals(that.getRefereeName()) &&
				getStatus() == that.getStatus() &&
				getWinner().equals(that.getWinner()) &&
				score.equals(that.score);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getNamePlayer1(), getNamePlayer2(), getNamePlayer3(), getNamePlayer4(), getMatchDate(), getMatchType(), getTour(), getCourtName(), getRefereeName(), getStatus(), getWinner(), score);
	}

	@Override
	public String toString() {
		return "TournamentMatch{" +
				"namePlayer1='" + namePlayer1 + '\'' +
				", namePlayer2='" + namePlayer2 + '\'' +
				", namePlayer3='" + namePlayer3 + '\'' +
				", namePlayer4='" + namePlayer4 + '\'' +
				", matchDate=" + matchDate +
				", matchType=" + matchType +
				", tour=" + tour +
				", courtName='" + courtName + '\'' +
				", refereeName='" + refereeName + '\'' +
				", status=" + status +
				", winner='" + winner + '\'' +
				", score='" + score + '\'' +
				'}';
	}
}
