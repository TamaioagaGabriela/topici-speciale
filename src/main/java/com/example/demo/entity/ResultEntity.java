package com.licenta.tmmbackend.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.licenta.tmmbackend.dao.Result;
import com.licenta.tmmbackend.enums.Round;
import com.licenta.tmmbackend.enums.result;


@Entity
@Table(name = "result")

public class ResultEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false, updatable = false)
	private int id;


//	@OnDelete(action = OnDeleteAction.CASCADE)
//	@JoinColumn(name = "id", referencedColumnName = "id")
//	private Integer matchId;


	@Column(name = "winner_one_name")
	private String winner1Name;

	@Column(name = "winner_two_name")
	private String winner2Name;

	@Column(name = "duration")
	private String duration;

	@Column(name = "audience")
	private Integer audience;

	@Column(name = "round")
	@Enumerated(EnumType.STRING)
	private Round round;

	@Column(name = "match_name")
	private String matchName;


	public ResultEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultEntity(int id, String winner1Name,
			String winner2Name, String duration,
			Integer audience, Round round, String matchName) {
		super();
		this.id = id;
//		this.matchId = matchId;
		this.winner1Name = winner1Name;
		this.winner2Name = winner2Name;
		this.duration = duration;
		this.audience = audience;
		this.round = round;
		this.matchName=matchName;
	}

	public ResultEntity(Result result)
	{
		this.matchName=result.getMatchName();
		this.winner1Name=result.getWinner1Name();
		this.winner2Name=result.getWinner2Name();
		this.duration=result.getDuration();
		this.audience=result.getAudience();
		this.round=result.getRound();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public Integer getMatchId() {
//		return matchId;
//	}
//
//	public void setMatchId(Integer matchId) {
//		this.matchId = matchId;
//	}

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

	public String getMatchName() {
		return matchName;
	}

	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ResultEntity)) return false;
		ResultEntity that = (ResultEntity) o;
		return getId() == that.getId() &&

				getWinner1Name().equals(that.getWinner1Name()) &&
				getWinner2Name().equals(that.getWinner2Name()) &&
				getDuration().equals(that.getDuration()) &&
				getAudience().equals(that.getAudience()) &&
				getRound() == that.getRound() &&
				getMatchName().equals(that.getMatchName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getWinner1Name(), getWinner2Name(), getDuration(), getAudience(), getRound(), getMatchName());
	}

	@Override
	public String toString() {
		return "ResultEntity{" +
				"id=" + id +

				", winner1Name='" + winner1Name + '\'' +
				", winner2Name='" + winner2Name + '\'' +
				", duration=" + duration +
				", audience=" + audience +
				", round=" + round +
				", matchName='" + matchName + '\'' +
				'}';
	}
}
