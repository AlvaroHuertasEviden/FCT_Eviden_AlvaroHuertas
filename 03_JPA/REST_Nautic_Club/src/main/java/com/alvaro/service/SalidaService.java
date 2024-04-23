package com.alvaro.service;

import com.alvaro.model.Barco;
import com.alvaro.model.Salida;

import java.util.List;

public interface SalidaService {
    List<Salida> getAllSalidas();
    Salida getSalidaById(Long id);
    Salida createSalida(Salida salida);
    Salida updateSalida(Long id, Salida salida);
    void deleteSalida(Long id);
    Salida updateSalidaBarco(Long id, String barcoMatricula);
}
