package com.bezkoder.springjwt.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "kid")
public class Kid {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_kid;

	@NotBlank
	@Size(max = 20)
	private String first_name;
	
	@NotBlank
	@Size(max = 20)
	private String last_name;
	
	@NotBlank
	@Size(max = 10)
	private String sex;
	
	@NotBlank
	private Date birthday;
	
	@NotBlank
	@Size(max = 20)
	private Long phone_number;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_groupe",referencedColumnName ="id_groupe", nullable = false)
	private Groupe groupe;

	public Kid(Long id, @NotBlank @Size(max = 20) String first_name, @NotBlank @Size(max = 20) String last_name,
			@NotBlank @Size(max = 10) String sex, @NotBlank Date birthday,
			@NotBlank @Size(max = 20) Long phone_number, Groupe groupe) {
		super();
		this.id_kid = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.sex = sex;
		this.birthday = birthday;
		this.phone_number = phone_number;
		this.groupe = groupe ;
	}

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	public Long getId() {
		return id_kid;
	}

	public void setId(Long id) {
		this.id_kid = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(Long phone_number) {
		this.phone_number = phone_number;
	}
	
	
}
