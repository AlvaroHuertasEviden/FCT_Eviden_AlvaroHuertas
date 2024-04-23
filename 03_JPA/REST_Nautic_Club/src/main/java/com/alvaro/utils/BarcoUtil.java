package com.alvaro.utils;

import com.alvaro.dto.BarcoDTOamp;
import com.alvaro.dto.BarcoDTOsimple;
import com.alvaro.model.Barco;
import com.alvaro.service.BarcoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BarcoUtil {

    @Autowired
    private BarcoService barcoService;

    @Autowired
    private SocioUtil socioUtil;

    public BarcoDTOamp convertToDTO(Barco barco) {
        BarcoDTOamp barcoDTO = new BarcoDTOamp();
        barcoDTO.setMatricula(barco.getMatricula());
        barcoDTO.setCuota(barco.getCuota());
        barcoDTO.setNamarre(barco.getNamarre());
        barcoDTO.setNombre(barco.getNombre());
        if (barco.getSocio() != null) barcoDTO.setSocio(socioUtil.convertToDTO(barco.getSocio()));
        return barcoDTO;
    }

    public static BarcoDTOsimple convertToDTOsimple(Barco barco) {
        BarcoDTOsimple barcoDTO = new BarcoDTOsimple();
        barcoDTO.setMatricula(barco.getMatricula());
        barcoDTO.setCuota(barco.getCuota());
        barcoDTO.setNamarre(barco.getNamarre());
        barcoDTO.setNombre(barco.getNombre());
        return barcoDTO;
    }

    public Barco convertToEntity(BarcoDTOsimple barcoDTO, String id) {
        Barco barco = new Barco();
        if (barcoDTO.getMatricula() == null) {
            barco = barcoService.getBarcoById(id);
        } else {
            barcoDTO.setMatricula(id);
            barco.setMatricula(barcoDTO.getMatricula());
        }
        barco.setCuota(barcoDTO.getCuota());
        barco.setNamarre(barcoDTO.getNamarre());
        barco.setNombre(barcoDTO.getNombre());

        return barco;
    }
}
