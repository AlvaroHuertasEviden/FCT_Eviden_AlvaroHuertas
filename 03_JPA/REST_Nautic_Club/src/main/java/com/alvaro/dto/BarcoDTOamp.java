package com.alvaro.dto;

import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;

public class BarcoDTOamp extends RepresentationModel<BarcoDTOamp> {
    private String matricula;
    private BigDecimal cuota;
    private SocioDTO socio;
    private String namarre;
    private String nombre;

    public BarcoDTOamp() {}

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public BigDecimal getCuota() {
        return cuota;
    }

    public void setCuota(BigDecimal cuota) {
        this.cuota = cuota;
    }

    public SocioDTO getSocio() {
        return socio;
    }

    public void setSocio(SocioDTO socio) {
        this.socio = socio;
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

    @Override
    public String toString() {
        return "BarcoDTOamp{" +
                "matricula='" + matricula + '\'' +
                ", cuota=" + cuota +
                ", socio=" + socio +
                ", namarre='" + namarre + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
