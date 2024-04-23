package com.alvaro.service;

import com.alvaro.model.*;
import com.alvaro.repository.PatronRepository;
import com.alvaro.repository.SalidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalidaServiceImpl implements SalidaService {

    @Autowired
    private SalidaRepository salidaRepository;

    @Autowired
    private SocioService socioService;

    @Autowired
    private CapitanExternoService capitanExternoService;

    @Autowired
    private PatronRepository patronRepository;

    @Autowired
    private BarcoService barcoService;

    @Override
    public List<Salida> getAllSalidas() {
        return salidaRepository.findAll();
    }

    @Override
    public Salida getSalidaById(Long id) {
        return salidaRepository.findById(id).orElse(null);
    }

    @Override
    public Salida createSalida(Salida salida) {
        Salida sal = salidaRepository.save(salida);
        Patron pat = patronRepository.findById(sal.getPatron().getId()).orElse(null);
        if (pat.getSocio() != null) {
            System.out.println("Get socio no es null");
            Socio soc = pat.getSocio();
            List<Salida> newSalidas = soc.getSalidas();
            newSalidas.add(sal);
            soc.setSalidas(newSalidas);
            socioService.updateSocio(soc.getId(), soc);
        } else if (pat.getCapitanExterno() != null) {
            CapitanExterno cap = pat.getCapitanExterno();
            cap.getSalidas().add(sal);
            capitanExternoService.updateCapitanExterno(cap.getId(), cap);
        }
        return sal;
    }

    @Override
    public Salida updateSalida(Long id, Salida salida) {
        salida.setId(id);
        return salidaRepository.save(salida);
    }

    @Override
    public void deleteSalida(Long id) {
        Salida sal = salidaRepository.findById(id).orElse(null);
        if (sal == null) {
            return;
        }
        Patron pat = patronRepository.findById(sal.getPatron().getId()).orElse(null);
        if (pat.getSocio() != null) {
            socioService.deleteSalidaCapitanExterno(pat.getSocio().getId(), id);
        } else if (pat.getCapitanExterno() != null) {
            capitanExternoService.deleteSalidaCapitanExterno(pat.getCapitanExterno().getId(), id);
        }
        salidaRepository.deleteById(id);
    }

    @Override
    public Salida updateSalidaBarco(Long id, String barcoMatricula) {
        Barco barco = barcoService.getBarcoById(barcoMatricula);
        Salida sal = salidaRepository.findById(id).orElse(null);
        if (sal == null) {
            return null;
        }
        sal.setBarco(barco);
        return salidaRepository.save(sal);
    }
}
