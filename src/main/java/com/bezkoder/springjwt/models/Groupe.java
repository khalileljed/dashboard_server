package com.bezkoder.springjwt.models;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "groupe")
public class Groupe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_groupe;

	@NotBlank
	@Size(max = 20)
	private String name;
	
	@NotBlank
	@Size(max = 20)
	private String age_interval;
	
	@NotBlank
	@Size(max = 10)
	private int number_kids;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="groupe")
	private List<Kid> kids ;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="groupe")
	private List<Activity> activities ;
	public Groupe(@NotBlank @Size(max = 20) String name, @NotBlank @Size(max = 20) String age_interval,
			@NotBlank @Size(max = 10) int number_kids, List<Kid> kids,List<Activity> activities) {
		super();
		this.name = name;
		this.age_interval = age_interval;
		this.number_kids = number_kids;
		this.kids = kids;
		this.activities = activities ;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge_interval() {
		return age_interval;
	}
	public void setAge_interval(String age_interval) {
		this.age_interval = age_interval;
	}
	public int getNumber_kids() {
		return number_kids;
	}
	public void setNumber_kids(int number_kids) {
		this.number_kids = number_kids;
	}
	public List<Kid> getKids() {
		return kids;
	}
	public void setKids(List<Kid> kids) {
		this.kids = kids;
	}
	public Long getId_groupe() {
		return id_groupe;
	}
	public void setId_groupe(Long id_groupe) {
		this.id_groupe = id_groupe;
	}
	public List<Activity> getActivities() {
		return activities;
	}
	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
	
}
