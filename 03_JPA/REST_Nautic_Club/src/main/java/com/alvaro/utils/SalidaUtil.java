package com.alvaro.utils;

import com.alvaro.dto.SalidaDTO;
import com.alvaro.dto.SalidaDTOamp;
import com.alvaro.model.Salida;
import com.alvaro.service.BarcoService;
import com.alvaro.service.PatronService;
import com.alvaro.service.SalidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalidaUtil {

    @Autowired
    private SalidaService salidaService;

    @Autowired
    private PatronService patronService;

    @Autowired
    private BarcoUtil barcoUtil;

    public Salida convertToEntity(SalidaDTO salidaDTO) {
        Salida salida = new Salida();
        if (salidaDTO.getId() != null) {
            salida.setId(salidaDTO.getId());
        } else {
            Long newSalidaId = salidaService.getAllSalidas().stream()
                    .mapToLong(Salida::getId)
                    .max()
                    .orElse(0L) + 1;
            salida.setId(newSalidaId);
            salidaDTO.setId(newSalidaId);
        }
        salida.setDestino(salidaDTO.getDestino());
        salida.setFechaHoraSalida(salidaDTO.getFechaHoraSalida());
        salida.setPatron(patronService.getPatronById(salidaDTO.getPatronId()));

        if ((salidaService.getSalidaById(salidaDTO.getId()) != null)) {
            salida.setBarco(salidaService.getSalidaById(salidaDTO.getId()).getBarco());
        } else {
            salida.setBarco(null);
        }
        return salida;
    }

    public SalidaDTOamp convertToDTOamp(Salida salida) {
        SalidaDTOamp salidaDTOamp = new SalidaDTOamp();
        salidaDTOamp.setId(salida.getId());
        salidaDTOamp.setDestino(salida.getDestino());
        salidaDTOamp.setFechaHoraSalida(salida.getFechaHoraSalida());
        salidaDTOamp.setPatronId(salida.getPatron().getId());
        if (salida.getBarco() != null) {
            salidaDTOamp.setBarco(barcoUtil.convertToDTOsimple(salida.getBarco()));
        }
        return salidaDTOamp;
    }
}
