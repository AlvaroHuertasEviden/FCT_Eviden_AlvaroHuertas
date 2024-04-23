package com.alvaro.dto;

import com.alvaro.model.Socio;
import com.alvaro.service.SocioService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;

public class SocioDTO {
    private Long id;
    private String nombre;
    private String telefono;
    private BigDecimal cuota;
    private boolean dadoDeAlta;

    public SocioDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getCuota() {
        return cuota;
    }

    public void setCuota(BigDecimal cuota) {
        this.cuota = cuota;
    }

    public boolean isDadoDeAlta() {
        return dadoDeAlta;
    }

    public void setDadoDeAlta(boolean dadoDeAlta) {
        this.dadoDeAlta = dadoDeAlta;
    }

    @Override
    public String toString() {
        return "SocioDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", cuota=" + cuota +
                ", dadoDeAlta=" + dadoDeAlta +
                '}';
    }
}
