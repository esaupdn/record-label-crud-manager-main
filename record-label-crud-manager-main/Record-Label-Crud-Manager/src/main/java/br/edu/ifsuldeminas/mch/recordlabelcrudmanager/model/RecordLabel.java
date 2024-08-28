package br.edu.ifsuldeminas.mch.recordlabelcrudmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "recordlabels")
public class RecordLabel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotBlank(message = "O nome da gravadora não pode ser vazio!")
	private String name;

	@NotBlank(message = "O endereço da gravadora não pode ser vazio!")
	private String adress;

	@NotBlank(message = "A gênero musical não pode ser vazio!")
	private String genre;


	public RecordLabel() {

	}

	public RecordLabel(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id){
	this.id = id;
	}

}
