package com.licenta.tmmbackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.licenta.tmmbackend.dao.Report;
import com.licenta.tmmbackend.enums.result;


@Entity
@Table(name = "report")

public class ReportEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false, updatable = false)
	private int id;


	@Column(name = "player_name")
	private String playerName;

	@Column(name = "result")
	@Enumerated(EnumType.STRING)
	private result Result;

	@Column(name = "aches")
	private Integer aches;

//	@Column(name = "nationality")
//	private String nationality;


	@Column(name = "double_fault")
	private Integer doubleFault;

	@Column(name = "forhend_hits")
	private Integer forhendHits;

	@Column(name = "winner_points")
	private Integer winnerPoints;

	@Column(name = "unforced_erros")
	private Integer unforcedErros;

	@Column(name = "backend_hits")
	private Integer backendHits;

	@Column(name = "voles")
	private Integer voles;

	@Column(name = "challanges")
	private Integer challanges;

	@Column(name = "winner_points_first_service")
	private Integer winnerPointsFirstService;

	@Column(name = "winner_points_second_service")
	private Integer winnerPointsSecondService;


	public ReportEntity() {
	}



	public ReportEntity(Report report){
		this.playerName=report.getPlayerName();
		this.aches=report.getAches();
		this.backendHits=report.getBackendHits();
		this.challanges=report.getChallanges();
		this.doubleFault=report.getDoubleFault();
		this.forhendHits=report.getForhendHits();
		this.unforcedErros=report.getUnforcedErros();
		this.voles=report.getVoles();
		this.winnerPointsFirstService=report.getWinnerPointsFirstService();
		this.winnerPointsSecondService=report.getWinnerPointsSecondService();
		this.winnerPoints=report.getWinnerPoints();
		this.Result=report.getResult();

	}

	public ReportEntity(int id, String playerId, result result, Integer aches,
		 Integer doubleFault, Integer forhendHits,
			Integer winnerPoints, Integer unforcedErros, Integer backendHits,
			Integer voles, Integer challanges,
			Integer winnerPointsFirstService, Integer winnerPointsSecondService) {
		super();
		this.id = id;
		this.playerName = playerName;
		Result = result;
		this.aches = aches;
		//this.nationality = nationality;
		this.doubleFault = doubleFault;
		this.forhendHits = forhendHits;
		this.winnerPoints = winnerPoints;
		this.unforcedErros = unforcedErros;
		this.backendHits = backendHits;
		this.voles = voles;
		this.challanges = challanges;
		this.winnerPointsFirstService = winnerPointsFirstService;
		this.winnerPointsSecondService = winnerPointsSecondService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public result getResult() {
		return Result;
	}

	public void setResult(result result) {
		Result = result;
	}

	public Integer getAches() {
		return aches;
	}

	public void setAches(Integer aches) {
		this.aches = aches;
	}

//	public String getNationality() {
//		return nationality;
//	}
//
//	public void setNationality(String nationality) {
//		this.nationality = nationality;
//	}

	public Integer getDoubleFault() {
		return doubleFault;
	}

	public void setDoubleFault(Integer doubleFault) {
		this.doubleFault = doubleFault;
	}

	public Integer getForhendHits() {
		return forhendHits;
	}

	public void setForhendHits(Integer forhendHits) {
		this.forhendHits = forhendHits;
	}

	public Integer getWinnerPoints() {
		return winnerPoints;
	}

	public void setWinnerPoints(Integer winnerPoints) {
		this.winnerPoints = winnerPoints;
	}

	public Integer getUnforcedErros() {
		return unforcedErros;
	}

	public void setUnforcedErros(Integer unforcedErros) {
		this.unforcedErros = unforcedErros;
	}

	public Integer getBackendHits() {
		return backendHits;
	}

	public void setBackendHits(Integer backendHits) {
		this.backendHits = backendHits;
	}

	public Integer getVoles() {
		return voles;
	}

	public void setVoles(Integer voles) {
		this.voles = voles;
	}

	public Integer getChallanges() {
		return challanges;
	}

	public void setChallanges(Integer challanges) {
		this.challanges = challanges;
	}

	public Integer getWinnerPointsFirstService() {
		return winnerPointsFirstService;
	}

	public void setWinnerPointsFirstService(Integer winnerPointsFirstService) {
		this.winnerPointsFirstService = winnerPointsFirstService;
	}

	public Integer getWinnerPointsSecondService() {
		return winnerPointsSecondService;
	}

	public void setWinnerPointsSecondService(Integer winnerPointsSecondService) {
		this.winnerPointsSecondService = winnerPointsSecondService;
	}





	@Override
	public String toString() {
		return "ReportEntity [id=" + id + ", playerName=" + playerName
				+ ", Result=" + Result + ", aches=" + aches + ", doubleFault=" + doubleFault
				+ ", forhendHits=" + forhendHits + ", winnerPoints="
				+ winnerPoints + ", unforcedErros=" + unforcedErros
				+ ", backendHits=" + backendHits + ", voles=" + voles
				+ ", challanges=" + challanges + ", winnerPointsFirstService="
				+ winnerPointsFirstService + ", winnerPointsSecondService="
				+ winnerPointsSecondService + "]";
	}



}
