package com.alvaro.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.hateoas.RepresentationModel;

@Entity
public class Barco extends RepresentationModel<Barco> {
	@Id
	private String matricula;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_duegno" )
	private Socio socio;
	
	private BigDecimal cuota;
	private String namarre;
	private String nombre;
	
	public Socio getSocio() {
		return socio;
	}
	
	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public BigDecimal getCuota() {
		return cuota;
	}
	
	public void setCuota(BigDecimal cuota) {
		this.cuota = cuota;
	}
	
	public String getNamarre() {
		return namarre;
	}
	
	public void setNamarre(String namarre) {
		this.namarre = namarre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
}
