package com.alvaro.service;

import com.alvaro.model.Socio;

import java.util.List;

public interface SocioService {
    List<Socio> getAllSocios();
    Socio getSocioById(Long id);
    Socio createSocio(Socio socio);
    Socio updateSocio(Long id, Socio socio);
    void deleteSocio(Long id);
    void deleteSalidaCapitanExterno(Long id, Long idSalida);
    void deleteBarcoSocioByMatricula(String matricula);
}
