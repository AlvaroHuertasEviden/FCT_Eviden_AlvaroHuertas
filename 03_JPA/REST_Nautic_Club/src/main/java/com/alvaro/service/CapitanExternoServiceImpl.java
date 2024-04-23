package com.alvaro.service;

import com.alvaro.model.CapitanExterno;
import com.alvaro.model.Patron;
import com.alvaro.model.Socio;
import com.alvaro.repository.CapitanExternoRepository;
import com.alvaro.repository.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapitanExternoServiceImpl implements CapitanExternoService {

    @Autowired
    private CapitanExternoRepository capitanExternoRepository;

    @Autowired
    private PatronRepository patronRepository;

    @Override
    public List<CapitanExterno> getAllCapitanExternos() {
        return capitanExternoRepository.findAll();
    }

    @Override
    public CapitanExterno getCapitanExternoById(Long id) {
        return capitanExternoRepository.findById(id).orElse(null);
    }

    @Override
    public CapitanExterno createCapitanExterno(CapitanExterno CapitanExterno) {
        CapitanExterno newCap = capitanExternoRepository.save(CapitanExterno);
        Patron patron = new Patron();
        patron.setCapitanExterno(newCap);
        patronRepository.save(patron);
        return newCap;
    }

    @Override
    public CapitanExterno updateCapitanExterno(Long id, CapitanExterno CapitanExterno) {
        CapitanExterno.setId(id);
        return capitanExternoRepository.save(CapitanExterno);
    }

    @Override
    public void deleteCapitanExterno(Long id) {
        capitanExternoRepository.deleteById(id);
    }

    @Override
    public void deleteSalidaCapitanExterno(Long id, Long idSalida) {
        CapitanExterno cap = capitanExternoRepository.findById(id).orElse(null);
        if (cap != null) {
            cap.getSalidas().removeIf(salida -> salida.getId().equals(idSalida));
            capitanExternoRepository.save(cap);
        }
    }
}
