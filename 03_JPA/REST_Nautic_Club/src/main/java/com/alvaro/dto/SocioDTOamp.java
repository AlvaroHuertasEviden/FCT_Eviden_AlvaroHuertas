package com.alvaro.dto;

import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SocioDTOamp extends RepresentationModel<SocioDTOamp> {
    private Long id;
    private String nombre;
    private String telefono;
    private BigDecimal cuota;
    private boolean dadoDeAlta;
    private List<BarcoDTOsimple> barcos;
    private List<Long> salidas;

    public SocioDTOamp() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
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

    public boolean isDadoDeAlta() {
        return dadoDeAlta;
    }

    public void setDadoDeAlta(boolean dadoDeAlta) {
        this.dadoDeAlta = dadoDeAlta;
    }

    public List<BarcoDTOsimple> getBarcos() {
        return barcos;
    }

    public void setBarcos(List<BarcoDTOsimple> barcos) {
        this.barcos = barcos;
    }

    public void setSalidas(List<Long> salidas) {
        this.salidas = salidas;
    }

    public List<Long> getSalidas() {
        return salidas;
    }

    public void setSalidas(ArrayList<Long> salidas) {
        this.salidas = salidas;
    }


}
