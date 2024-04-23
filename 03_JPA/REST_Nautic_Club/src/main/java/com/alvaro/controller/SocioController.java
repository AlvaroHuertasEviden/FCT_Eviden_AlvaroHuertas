package com.alvaro.controller;

import com.alvaro.dto.SocioDTO;
import com.alvaro.dto.SocioDTOamp;
import com.alvaro.model.Socio;
import com.alvaro.service.SocioService;
import com.alvaro.utils.SocioUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/socios")
public class SocioController {

    @Autowired
    private SocioService socioService;

    @Autowired
    private SocioUtil socioUtil;

    @GetMapping
    public ResponseEntity<List<SocioDTOamp>> getAllSocios() {
        List<Socio> socios = socioService.getAllSocios();
        List<SocioDTOamp> sociosDTO = new ArrayList<>();
        for (Socio socio : socios) {
            SocioDTOamp socioDTO = socioUtil.convertToDTOamp(socio);
            sociosDTO.add(socioDTO);
        }
        return ResponseEntity.ok(sociosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SocioDTOamp> getSocioById(@PathVariable Long id) {
        Socio socio = socioService.getSocioById(id);
        SocioDTOamp socioDTO = socioUtil.convertToDTOamp(socio);
        return ResponseEntity.ok(socioDTO);
    }

    @PostMapping
    public ResponseEntity<Socio> createSocio(@RequestBody SocioDTO socioDTO) {
        Socio socio = socioUtil.convertToEntity(socioDTO);
        return ResponseEntity.ok(socioService.createSocio(socio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SocioDTOamp> updateSocio(@PathVariable Long id, @RequestBody SocioDTO socioDTO) {
        socioDTO.setId(id);
        Socio socio = socioUtil.convertToEntity(socioDTO);
        socioService.updateSocio(id, socio);
        SocioDTOamp socioDTOamp = socioUtil.convertToDTOamp(socio);
        return ResponseEntity.ok(socioDTOamp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSocio(@PathVariable Long id) {
        Socio socio = socioService.getSocioById(id);
        if (socio == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Socio not found");
        }
        if (!socio.getSalidas().isEmpty()) {
            SocioDTOamp socioDTOamp = socioUtil.convertToDTOamp(socio);
            SocioDTO socioDTO = socioUtil.convertToDTO(socio);
            Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SocioController.class)
                    .updateSocio(id, socioDTO)).withRel("setDadoDeAltaToFalse");
            socioDTOamp.add(link);
            return new ResponseEntity<>(socioDTOamp, HttpStatus.CONFLICT);
        }
        socioService.deleteSocio(id);
        return ResponseEntity.ok().build();
    }
}
