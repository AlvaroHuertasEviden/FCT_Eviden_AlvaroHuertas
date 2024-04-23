package com.alvaro.service;

import com.alvaro.model.Barco;
import com.alvaro.repository.BarcoRepository;
import com.alvaro.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarcoServiceImpl implements BarcoService {

    @Autowired
    private BarcoRepository barcoRepository;

    @Autowired
    SocioRepository socioRepository;

    @Override
    public List<Barco> getAllBarcos() {
        return barcoRepository.findAll();
    }

    @Override
    public Barco getBarcoById(String id) {
        return barcoRepository.findById(id).orElse(null);
    }

    @Override
    public Barco createBarco(Barco Barco) {
        return barcoRepository.save(Barco);
    }

    @Override
    public Barco updateBarco(String id, Barco Barco) {
        Barco.setMatricula(id);
        return barcoRepository.save(Barco);
    }

    @Override
    public void deleteBarco(String id) {
        barcoRepository.deleteById(id);
    }

    @Override
    public Barco updateBarcoSocio(String id, int socioid) {
        Barco barco = barcoRepository.findById(id).orElse(null);
        if (barco != null) {
            barco.setSocio(socioRepository.findById((long) socioid).orElse(null));
            return barcoRepository.save(barco);
        }
        return null;
    }
}
