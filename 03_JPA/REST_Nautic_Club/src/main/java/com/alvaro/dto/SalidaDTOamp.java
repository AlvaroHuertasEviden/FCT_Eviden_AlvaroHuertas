package com.alvaro.dto;

import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

public class SalidaDTOamp extends RepresentationModel<SalidaDTOamp> {
    private Long id;
    private LocalDateTime fechaHoraSalida;
    private Long patronId;
    private String destino;
    private BarcoDTOsimple barco;

    public SalidaDTOamp() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getPatronId() {
        return patronId;
    }

    public void setPatronId(Long patronId) {
        this.patronId = patronId;
    }

    public BarcoDTOsimple getBarco() {
        return barco;
    }

    public void setBarco(BarcoDTOsimple barco) {
        this.barco = barco;
    }
}
