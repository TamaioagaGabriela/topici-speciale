package com.licenta.tmmbackend.entity;

import javax.persistence.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.licenta.tmmbackend.dao.Court;
import com.licenta.tmmbackend.enums.Avalability;
import com.licenta.tmmbackend.enums.Surface;

@Entity
@Table(name = "court")
public class CourtEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false, updatable = false)
	private int id;

	@Column(name = "court_name")
	private String courtName;

	@Column(name = "surface")
	@Enumerated(EnumType.STRING)
	private Surface surface;

	@Column(name = "capacity")
	private Integer capacity;

	@Column(name = "avalability")
	@Enumerated(EnumType.STRING)
	private Avalability avalability;

	public CourtEntity() {
		// TODO Auto-generated constructor stub
	}

	public CourtEntity(Court court)
	{
		this.courtName=court.getCourtName();
		this.surface=court.getSurface();
		this.capacity=court.getCapacity();
		this.avalability=court.getAvalability();
	}

	public CourtEntity(int id, String courtName, Surface surface,
			Integer capacity, Avalability avalability) {
		this.id = id;
		this.courtName = courtName;
		this.surface = surface;
		this.capacity = capacity;
		this.avalability = avalability;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		this.capacity = capacity;
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
				+ ((avalability == null) ? 0 : avalability.hashCode());
		result = prime * result
				+ ((capacity == null) ? 0 : capacity.hashCode());
		result = prime * result
				+ ((courtName == null) ? 0 : courtName.hashCode());
		result = prime * result + id;
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
		CourtEntity other = (CourtEntity) obj;
		if (avalability != other.avalability)
			return false;
		if (capacity == null) {
			if (other.capacity != null)
				return false;
		} else if (!capacity.equals(other.capacity))
			return false;
		if (courtName == null) {
			if (other.courtName != null)
				return false;
		} else if (!courtName.equals(other.courtName))
			return false;
		if (id != other.id)
			return false;
		if (surface != other.surface)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CourtEntity [id=" + id + ", courtName=" + courtName
				+ ", surface=" + surface + ", capacity=" + capacity
				+ ", avalability=" + avalability + "]";
	}




}
