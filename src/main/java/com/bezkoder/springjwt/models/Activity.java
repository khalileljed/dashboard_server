package com.bezkoder.springjwt.models;
import java.util.Date;

import javax.persistence.Column;
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
@Table(	name = "activity")
public class Activity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_activity;

	@NotBlank
	@Size(max = 20)
	private String title;
	
	@NotBlank
	@Column(columnDefinition = "TEXT")
	private String body;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_groupe",referencedColumnName ="id_groupe", nullable = false)
	private Groupe groupe;

	public Activity(@NotBlank @Size(max = 20) String title, @NotBlank String body, Groupe groupe) {
		super();
		this.title = title;
		this.body = body;
		this.groupe = groupe;
	}

	public Long getId_activity() {
		return id_activity;
	}

	public void setId_activity(Long id_activity) {
		this.id_activity = id_activity;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}
	
}
