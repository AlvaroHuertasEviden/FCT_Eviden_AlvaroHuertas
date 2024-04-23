package com.alvaro.model;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.RepresentationModel;

@Entity
public class Socio extends RepresentationModel<Socio> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Name cannot be null")
	private String nombre;
	private String telefono;
	private BigDecimal cuota;

	@Value("some.key:true")
	private boolean dadoDeAlta;

	@JsonManagedReference
	@OneToMany(fetch = FetchType.EAGER)
	private List<Barco> barcos;

	@JsonBackReference()
	@OneToMany(fetch = FetchType.EAGER)
	private List<Salida> salidas;
	
	public String getNombre() {
		return nombre;
	}

	public boolean isDadoDeAlta() {
		return dadoDeAlta;
	}

	public void setDadoDeAlta(boolean dadoDeAlta) {
		this.dadoDeAlta = dadoDeAlta;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public BigDecimal getCuota() {
		return cuota;
	}
	
	public void setCuota(BigDecimal cuota) {
		this.cuota = cuota;
	}
	
	public Long getId() {
		return id;
	}

	public List<Barco> getBarcos() {
		return barcos;
	}

	public List<Salida> getSalidas() {
		return salidas;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBarcos(List<Barco> barcos) {
		this.barcos = barcos;
	}
	
	public void setBarco(Barco barco) {
		this.barcos.add(barco);
	}

	public void setSalidas(List<Salida> salidas) {
		this.salidas = salidas;
	}

	@Override
	public String toString() {
		return "Socio{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				", telefono='" + telefono + '\'' +
				", cuota=" + cuota +
				", dadoDeAlta=" + dadoDeAlta +
				", barcos=" + barcos +
				", salidas=" + salidas +
				'}';
	}
}
