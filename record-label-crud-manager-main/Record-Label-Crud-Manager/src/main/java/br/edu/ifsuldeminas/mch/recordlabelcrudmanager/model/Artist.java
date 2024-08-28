package br.edu.ifsuldeminas.mch.recordlabelcrudmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "artists")
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotBlank(message = "O nome do artista não pode ser vazio!")
	private String name;

	@NotBlank(message = "O e-mail de não pode ser vazio!")
	@Email(message = "E-mail inválido!")
	private String email;

	@NotBlank(message = "O gênero musical não pode ser vazio!")
	private String genre;

	@ManyToOne(optional = false)
	@Valid
	@NotNull(message = "A Gravadora não pode ser vazia!")
	private RecordLabel recordlabel;

	public Artist() {

	}

	public Artist(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	

	public RecordLabel getRecordlabel() {
		return recordlabel;
	}

	public void setRecordlabel(RecordLabel recordlabel) {
		this.recordlabel = recordlabel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
