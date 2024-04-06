package ru.zinovev.springboot.project.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "troute")
public class RouteString {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "id_dse")
	private int idDse;
	
	@Column(name = "name")
	private String name;
	
	@Min(value = 1, message = "Numoper should be between 10 and 10000")
    @Max(value = 10000, message = "Numoper should be between 10 and 10000")
	@Column(name = "numoper")
	private int numOper;

	public RouteString() {}

	public RouteString(int idDse, String name, int numOper) {
		this.idDse = idDse;
		this.name = name;
		this.numOper = numOper;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_dse() {
		return idDse;
	}

	public void setId_dse(int idDse) {
		this.idDse = idDse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumOper() {
		return numOper;
	}

	public void setNumOper(int numoper) {
		this.numOper = numoper;
	}

}
