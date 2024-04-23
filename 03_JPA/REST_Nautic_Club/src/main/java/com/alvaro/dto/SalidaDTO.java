package com.alvaro.dto;

import com.alvaro.model.Salida;
import com.alvaro.service.PatronService;
import com.alvaro.service.SalidaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class SalidaDTO {
    private Long id;
    private LocalDateTime fechaHoraSalida;
    private Long patronId;
    private String destino;

    public SalidaDTO() {}

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
}
