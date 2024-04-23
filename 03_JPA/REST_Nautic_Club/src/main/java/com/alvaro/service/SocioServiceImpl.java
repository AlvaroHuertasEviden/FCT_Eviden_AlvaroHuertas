package com.alvaro.service;

import com.alvaro.model.Patron;
import com.alvaro.model.Socio;
import com.alvaro.repository.PatronRepository;
import com.alvaro.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocioServiceImpl implements SocioService {

    @Autowired
    private SocioRepository socioRepository;

    @Autowired
    private PatronRepository patronRepository;

    @Override
    public List<Socio> getAllSocios() {
        return socioRepository.findAll();
    }

    @Override
    public Socio getSocioById(Long id) {
        return socioRepository.findById(id).orElse(null);
    }

    @Override
    public Socio createSocio(Socio socio) {
        Socio newSocio = socioRepository.save(socio);
        Patron patron = new Patron();
        patron.setSocio(newSocio);
        patronRepository.save(patron);
        return newSocio;
    }

    @Override
    public Socio updateSocio(Long id, Socio socio) {
        socio.setId(id);
        return socioRepository.save(socio);
    }

    @Override
    public void deleteSocio(Long id) {
        socioRepository.deleteById(id);
    }

    @Override
    public void deleteSalidaCapitanExterno(Long id, Long idSalida) {
        Socio soc = socioRepository.findById(id).orElse(null);
        if (soc != null) {
            soc.getSalidas().removeIf(salida -> salida.getId().equals(idSalida));
            socioRepository.save(soc);
        }
    }

    @Override
    public void deleteBarcoSocioByMatricula(String matricula) {
        socioRepository.deleteSocioBarcoByMatricula(matricula);
    }
}
