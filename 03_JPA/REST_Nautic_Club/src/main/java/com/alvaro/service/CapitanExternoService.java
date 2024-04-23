package com.alvaro.service;

import com.alvaro.model.CapitanExterno;

import java.util.List;

public interface CapitanExternoService {
    List<CapitanExterno> getAllCapitanExternos();
    CapitanExterno getCapitanExternoById(Long id);
    CapitanExterno createCapitanExterno(CapitanExterno CapitanExterno);
    CapitanExterno updateCapitanExterno(Long id, CapitanExterno CapitanExterno);
    void deleteCapitanExterno(Long id);
    void deleteSalidaCapitanExterno(Long id, Long idSalida);
}
