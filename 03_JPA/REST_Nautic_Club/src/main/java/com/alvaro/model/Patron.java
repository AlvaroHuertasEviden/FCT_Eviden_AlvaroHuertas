package com.alvaro.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Patron {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonManagedReference
	@OneToOne(fetch = FetchType.EAGER)
	@Nullable
	private Socio socio;

	@JsonManagedReference
	@OneToOne(fetch = FetchType.EAGER)
	@Nullable
	private CapitanExterno capitanExterno;

	public Patron() {}

	public Long getId() {
		return id;
	}

	public Socio getSocio() {
		return socio;
	}

	public CapitanExterno getCapitanExterno() {
		return capitanExterno;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public void setCapitanExterno(CapitanExterno capitanExterno) {
		this.capitanExterno = capitanExterno;
	}

}
