package com.alvaro.utils;

import com.alvaro.dto.SocioDTO;
import com.alvaro.dto.SocioDTOamp;
import com.alvaro.model.Salida;
import com.alvaro.model.Socio;
import com.alvaro.service.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class SocioUtil {

    @Autowired
    private SocioService socioService;


    public SocioDTO convertToDTO(Socio socio) {
        SocioDTO socioDTO = new SocioDTO();
        socioDTO.setId(socio.getId());
        socioDTO.setNombre(socio.getNombre());
        socioDTO.setTelefono(socio.getTelefono());
        socioDTO.setCuota(socio.getCuota());
        socioDTO.setDadoDeAlta(socio.isDadoDeAlta());
        return socioDTO;
    }

    public Socio convertToEntity(SocioDTO socioDTO) {
        Socio socio = new Socio();
        if (socioDTO.getId() != null) {
            socio.setId(socioDTO.getId());
        } else {
            Long newSocioId = socioService.getAllSocios().stream()
                    .mapToLong(Socio::getId)
                    .max()
                    .orElse(0L) + 1;
            socio.setId(newSocioId);
            socioDTO.setId(newSocioId);
        }
        socio.setNombre(socioDTO.getNombre());
        socio.setTelefono(socioDTO.getTelefono());
        socio.setCuota(socioDTO.getCuota());
        socio.setDadoDeAlta(socioDTO.isDadoDeAlta());
        if ((socioService.getSocioById(socioDTO.getId()) != null)) {
            socio.setSalidas(socioService.getSocioById(socioDTO.getId()).getSalidas());
            socio.setBarcos(socioService.getSocioById(socioDTO.getId()).getBarcos());
        } else {
            socio.setBarcos(new ArrayList<>());
            socio.setSalidas(new ArrayList<>());
        }
        return socio;
    }

    public SocioDTOamp convertToDTOamp(Socio socio) {
        SocioDTOamp socioDTO = new SocioDTOamp();
        socioDTO.setId(socio.getId());
        socioDTO.setNombre(socio.getNombre());
        socioDTO.setTelefono(socio.getTelefono());
        socioDTO.setCuota(socio.getCuota());
        socioDTO.setDadoDeAlta(socio.isDadoDeAlta());
        socioDTO.setBarcos(socio.getBarcos().stream()
                .map(barco -> BarcoUtil.convertToDTOsimple(barco))
                .collect(Collectors.toList()));
        socioDTO.setSalidas(socio.getSalidas().stream()
                .map(Salida::getId).collect(Collectors.toList()));
        return socioDTO;
    }
}
