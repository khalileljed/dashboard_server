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
@Entity
@Table(	name = "note")
public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_note;
	
	@NotBlank
	@Column(columnDefinition = "TEXT")
	private String body;
	
	@NotBlank
	private Date date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_kid",referencedColumnName ="id_kid", nullable = false)
	private Kid kid;

	public Note(Long id_note, @NotBlank String body,Date date, Kid kid) {
		super();
		this.id_note = id_note;
		this.body = body;
		this.date = date ;
		this.kid = kid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getId_note() {
		return id_note;
	}

	public void setId_note(Long id_note) {
		this.id_note = id_note;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Kid getKid() {
		return kid;
	}

	public void setKid(Kid kid) {
		this.kid = kid;
	}
	
}
