package com.licenta.tmmbackend.dao;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.licenta.tmmbackend.enums.Round;

public class Result {
//	@NotNull private Integer matchId;
	@NotNull private String winner1Name;
			 private String winner2Name;
	@NotNull private String duration;
			 private Integer audience;
	@NotNull private Round round;
	@NotNull private String matchName;

	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Result( String winner1Name, String winner2Name,
			String duration, Integer audience, Round round, String matchName) {
	
//		this.matchId = matchId;
		this.winner1Name = winner1Name;
		this.winner2Name = winner2Name;
		this.duration = duration;
		this.audience = audience;
		this.round = round;
		this.matchName = matchName;
	}
	public String getMatchName() {
		return matchName;
	}
	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}
	public String getWinner1Name() {
		return winner1Name;
	}
	public void setWinner1Name(String winner1Name) {
		this.winner1Name = winner1Name;
	}
	public String getWinner2Name() {
		return winner2Name;
	}
	public void setWinner2Name(String winner2Name) {
		this.winner2Name = winner2Name;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Integer getAudience() {
		return audience;
	}
	public void setAudience(Integer audience) {
		this.audience = audience;
	}
	public Round getRound() {
		return round;
	}
	public void setRound(Round round) {
		this.round = round;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Result)) return false;
		Result result = (Result) o;
		return
				getWinner1Name().equals(result.getWinner1Name()) &&
				getWinner2Name().equals(result.getWinner2Name()) &&
				getDuration().equals(result.getDuration()) &&
				getAudience().equals(result.getAudience()) &&
				getRound() == result.getRound() &&
				getMatchName().equals(result.getMatchName());
	}

	@Override
	public int hashCode() {
		return Objects.hash( getWinner1Name(), getWinner2Name(), getDuration(), getAudience(), getRound(), getMatchName());
	}

	@Override
	public String toString() {
		return "Result{" +
				", winner1Name='" + winner1Name + '\'' +
				", winner2Name='" + winner2Name + '\'' +
				", duration=" + duration +
				", audience=" + audience +
				", round=" + round +
				", matchName='" + matchName + '\'' +
				'}';
	}
}
