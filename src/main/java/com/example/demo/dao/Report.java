package com.licenta.tmmbackend.dao;

import javax.validation.constraints.NotNull;

import com.licenta.tmmbackend.enums.Position;
import com.licenta.tmmbackend.enums.result;

public class Report {
	@NotNull private String playerName;
	@NotNull private result Result;
	@NotNull private Integer aches;
	@NotNull private Integer doubleFault;
	@NotNull private Integer forhendHits;
	@NotNull private Integer winnerPoints;
	@NotNull private Integer unforcedErros;
	@NotNull private Integer backendHits;
	@NotNull private Integer voles;
	@NotNull private Integer challanges;
	@NotNull private Integer winnerPointsFirstService;
	@NotNull private Integer winnerPointsSecondService;
	
	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Report(String playerName, result result, Integer aches,
			Integer doubleFault, Integer forhendHits, Integer winnerPoints,
			Integer unforcedErros, Integer backendHits, Integer voles,
			Integer challanges, Integer winnerPointsFirstService,
			Integer winnerPointsSecondService) {
		super();
		this.playerName = playerName;
		Result = result;
		this.aches = aches;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Result == null) ? 0 : Result.hashCode());
		result = prime * result + ((aches == null) ? 0 : aches.hashCode());
		result = prime * result
				+ ((backendHits == null) ? 0 : backendHits.hashCode());
		result = prime * result
				+ ((challanges == null) ? 0 : challanges.hashCode());
		result = prime * result
				+ ((doubleFault == null) ? 0 : doubleFault.hashCode());
		result = prime * result
				+ ((forhendHits == null) ? 0 : forhendHits.hashCode());
		result = prime * result
				+ ((playerName == null) ? 0 : playerName.hashCode());
		result = prime * result
				+ ((unforcedErros == null) ? 0 : unforcedErros.hashCode());
		result = prime * result + ((voles == null) ? 0 : voles.hashCode());
		result = prime * result
				+ ((winnerPoints == null) ? 0 : winnerPoints.hashCode());
		result = prime
				* result
				+ ((winnerPointsFirstService == null) ? 0
						: winnerPointsFirstService.hashCode());
		result = prime
				* result
				+ ((winnerPointsSecondService == null) ? 0
						: winnerPointsSecondService.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Report other = (Report) obj;
		if (Result != other.Result)
			return false;
		if (aches == null) {
			if (other.aches != null)
				return false;
		} else if (!aches.equals(other.aches))
			return false;
		if (backendHits == null) {
			if (other.backendHits != null)
				return false;
		} else if (!backendHits.equals(other.backendHits))
			return false;
		if (challanges == null) {
			if (other.challanges != null)
				return false;
		} else if (!challanges.equals(other.challanges))
			return false;
		if (doubleFault == null) {
			if (other.doubleFault != null)
				return false;
		} else if (!doubleFault.equals(other.doubleFault))
			return false;
		if (forhendHits == null) {
			if (other.forhendHits != null)
				return false;
		} else if (!forhendHits.equals(other.forhendHits))
			return false;
		if (playerName == null) {
			if (other.playerName != null)
				return false;
		} else if (!playerName.equals(other.playerName))
			return false;
		if (unforcedErros == null) {
			if (other.unforcedErros != null)
				return false;
		} else if (!unforcedErros.equals(other.unforcedErros))
			return false;
		if (voles == null) {
			if (other.voles != null)
				return false;
		} else if (!voles.equals(other.voles))
			return false;
		if (winnerPoints == null) {
			if (other.winnerPoints != null)
				return false;
		} else if (!winnerPoints.equals(other.winnerPoints))
			return false;
		if (winnerPointsFirstService == null) {
			if (other.winnerPointsFirstService != null)
				return false;
		} else if (!winnerPointsFirstService
				.equals(other.winnerPointsFirstService))
			return false;
		if (winnerPointsSecondService == null) {
			if (other.winnerPointsSecondService != null)
				return false;
		} else if (!winnerPointsSecondService
				.equals(other.winnerPointsSecondService))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Report [playerName=" + playerName + ", Result=" + Result
				+ ", aches=" + aches + ", doubleFault=" + doubleFault
				+ ", forhendHits=" + forhendHits + ", winnerPoints="
				+ winnerPoints + ", unforcedErros=" + unforcedErros
				+ ", backendHits=" + backendHits + ", voles=" + voles
				+ ", challanges=" + challanges + ", winnerPointsFirstService="
				+ winnerPointsFirstService + ", winnerPointsSecondService="
				+ winnerPointsSecondService + "]";
	}
	
	
	
	
	
	
	
	

	

}
