package com.alvaro.dto;

import com.alvaro.model.Barco;
import com.alvaro.service.BarcoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BarcoDTOsimple {
    private String matricula;
    private BigDecimal cuota;
    private String namarre;
    private String nombre;

    public BarcoDTOsimple() {}

    public BigDecimal getCuota() {
        return cuota;
    }

    public void setCuota(BigDecimal cuota) {
        this.cuota = cuota;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
        return "BarcoDTOsimple{" +
                "matricula='" + matricula + '\'' +
                ", cuota=" + cuota +
                ", namarre='" + namarre + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
