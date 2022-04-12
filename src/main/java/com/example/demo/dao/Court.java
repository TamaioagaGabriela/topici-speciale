package com.licenta.tmmbackend.dao;


import javax.validation.constraints.NotNull;

import com.licenta.tmmbackend.enums.Surface;
import com.licenta.tmmbackend.enums.Avalability;

public class Court {

	@NotNull private String courtName;
	@NotNull private Surface surface;
	@NotNull private Integer capacity;
	@NotNull private Avalability avalability;
	
	


	public Court(String courtName, Surface surface, Integer capacity,
			Avalability avalability) {
		super();
		this.courtName = courtName;
		this.surface = surface;
		this.capacity = capacity;
		this.avalability = avalability;
	}


	public String getCourtName() {
		return courtName;
	}


	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}


	public Surface getSurface() {
		return surface;
	}


	public void setSurface(Surface surface) {
		this.surface = surface;
	}


	public Integer getCapacity() {
		return capacity;
	}


	public void setCapacity(Integer capacity) {
		capacity = capacity;
	}


	public Avalability getAvalability() {
		return avalability;
	}


	public void setAvalability(Avalability avalability) {
		this.avalability = avalability;
	}


	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((capacity == null) ? 0 : capacity.hashCode());
		result = prime * result
				+ ((avalability == null) ? 0 : avalability.hashCode());
		result = prime * result
				+ ((courtName == null) ? 0 : courtName.hashCode());
		result = prime * result + ((surface == null) ? 0 : surface.hashCode());
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
		Court other = (Court) obj;
		if (capacity == null) {
			if (other.capacity != null)
				return false;
		} else if (!capacity.equals(other.capacity))
			return false;
		if (avalability != other.avalability)
			return false;
		if (courtName == null) {
			if (other.courtName != null)
				return false;
		} else if (!courtName.equals(other.courtName))
			return false;
		if (surface != other.surface)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Court [courtName=" + courtName + ", surface=" + surface
				+ ", Capacity=" + capacity + ", avalability=" + avalability
				+ "]";
	}
	
	
}

