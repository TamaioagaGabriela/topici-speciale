package com.licenta.tmmbackend.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.licenta.tmmbackend.dao.Player;


@Entity
@Table(name = "player")

public class PlayerEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false, updatable = false)
	private int id;

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;

	@Column(name = "gender")
	private String gender;

	@Column(name = "age")
	private Integer age;

	@Column(name = "nationality")
	private String nationality;
	
	@Column(name = "ranking")
	private Integer ranking;
	
	@Column(name = "favourite")
	private Integer favourite;
	
	@Column(name = "coach")
	private String coach;

	public PlayerEntity() {
		// TODO Auto-generated constructor stub
	}

	public PlayerEntity(int id, String firstName, String lastName,
			String gender, Integer age, String nationality, Integer ranking,
			Integer favourite, String coach) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.nationality = nationality;
		this.ranking = ranking;
		this.favourite = favourite;
		this.coach = coach;
	}
	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	public Integer getFavourite() {
		return favourite;
	}

	public void setFavourite(Integer favourite) {
		this.favourite = favourite;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}
	
	public PlayerEntity(Player player)
	{
		
		this.firstName = player.getFirstName();
		this.lastName = player.getLastName();
		this.gender = player.getGender();
		this.age = player.getAge();
		this.nationality = player.getNationality();
		this.ranking = player.getRanking();
		this.favourite = player.getFavourite();
		this.coach = player.getCoach();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((coach == null) ? 0 : coach.hashCode());
		result = prime * result
				+ ((favourite == null) ? 0 : favourite.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((nationality == null) ? 0 : nationality.hashCode());
		result = prime * result + ((ranking == null) ? 0 : ranking.hashCode());
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
		PlayerEntity other = (PlayerEntity) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (coach == null) {
			if (other.coach != null)
				return false;
		} else if (!coach.equals(other.coach))
			return false;
		if (favourite == null) {
			if (other.favourite != null)
				return false;
		} else if (!favourite.equals(other.favourite))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (nationality == null) {
			if (other.nationality != null)
				return false;
		} else if (!nationality.equals(other.nationality))
			return false;
		if (ranking == null) {
			if (other.ranking != null)
				return false;
		} else if (!ranking.equals(other.ranking))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PlayerEntity [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender + ", age="
				+ age + ", nationality=" + nationality + ", ranking=" + ranking
				+ ", favourite=" + favourite + ", coach=" + coach + "]";
	}
	
	
	
	
}
