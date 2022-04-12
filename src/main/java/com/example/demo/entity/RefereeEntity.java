package com.licenta.tmmbackend.entity;

import javax.persistence.*;

import com.licenta.tmmbackend.dao.Referee;
import com.licenta.tmmbackend.enums.Position;


@Entity
@Table(name = "referee")
public class RefereeEntity {

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

	@Column(name = "nationality")
	private String nationality;

	@Column(name = "age")
	private Integer age;

	@Column(name = "position")
	@Enumerated(EnumType.STRING)
	private Position position;

	public RefereeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RefereeEntity(int id, String firstName, String lastName,
			String gender, String nationality, Integer age, Position position) {
	;
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.nationality = nationality;
		this.age = age;
		this.position = position;
	}

	public RefereeEntity(Referee referee)
	{
		this.firstName=referee.getFirstName();
		this.lastName=referee.getLastName();
		this.gender=referee.getGender();
		this.nationality=referee.getNationality();
		this.age=referee.getAge();
		this.position=referee.getPosition();
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

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((nationality == null) ? 0 : nationality.hashCode());
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
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
		RefereeEntity other = (RefereeEntity) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
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
		if (position != other.position)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RefereeEntity [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender
				+ ", nationality=" + nationality + ", age=" + age
				+ ", position=" + position + "]";
	}



}
