package com.alvaro.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Salida {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonManagedReference
	@ManyToOne(fetch = FetchType.EAGER)
	private Barco barco;

	@JsonManagedReference
	@ManyToOne(fetch = FetchType.EAGER)
	@NotNull(message = "No se puede realizar una salida sin un patrón")
	private Patron patron;
	
	private LocalDateTime fechaHoraSalida;
	private String destino;

	public LocalDateTime getFechaHoraSalida() {
		return fechaHoraSalida;
	}

	public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Long getId() {
		return id;
	}

	public Barco getBarco() {
		return barco;
	}

	public Patron getPatron() {
		return patron;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBarco(Barco barco) {
		this.barco = barco;
	}

	public void setPatron(Patron patron) {
		this.patron = patron;
	}

	@Override
	public String toString() {
		return "Salida [id=" + id + ", barco=" + barco + ", patron=" + patron + ", fechaHoraSalida=" + fechaHoraSalida
				+ ", destino=" + destino + "]";
	}
    
}

