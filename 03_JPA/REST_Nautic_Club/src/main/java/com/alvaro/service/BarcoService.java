package com.alvaro.service;

import com.alvaro.model.Barco;

import java.util.List;

public interface BarcoService {
    List<Barco> getAllBarcos();
    Barco getBarcoById(String id);
    Barco createBarco(Barco Barco);
    Barco updateBarco(String id, Barco Barco);
    void deleteBarco(String id);
    Barco updateBarcoSocio(String id, int socioid);
}
