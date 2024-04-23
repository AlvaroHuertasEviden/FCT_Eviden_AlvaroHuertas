package com.alvaro.controller;

import com.alvaro.dto.SalidaDTO;
import com.alvaro.dto.SalidaDTOamp;
import com.alvaro.model.Salida;
import com.alvaro.service.SalidaService;
import com.alvaro.utils.SalidaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/salidas")
public class SalidaController {

    @Autowired
    private SalidaService salidaService;

    @Autowired
    private SalidaUtil salidaUtil;


    @GetMapping
    public ResponseEntity<List<SalidaDTOamp>> getAllSalidas() {
        List<Salida> salidas = salidaService.getAllSalidas();
        List<SalidaDTOamp> salidasDTO = new ArrayList<>();
        for (Salida salida : salidas) {
            salidasDTO.add(salidaUtil.convertToDTOamp(salida));
        }
        return ResponseEntity.ok(salidasDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalidaDTOamp> getSalidaById(@PathVariable Long id) {
        Salida salida = salidaService.getSalidaById(id);
        return ResponseEntity.ok(salidaUtil.convertToDTOamp(salida));
    }

    @PostMapping
    public ResponseEntity<SalidaDTOamp> createSalida(@RequestBody SalidaDTO salidaDTO) {
        Salida salida = salidaUtil.convertToEntity(salidaDTO);
        SalidaDTOamp salidaDTOamp = salidaUtil.convertToDTOamp(salidaService.createSalida(salida));
        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SalidaController.class)
                .updateSalidaBarco(salidaDTOamp.getId(), null)).withRel("addBarco");
        return ResponseEntity.ok(salidaDTOamp.add(link));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalidaDTOamp> updateSalida(@PathVariable Long id, @RequestBody SalidaDTO salidaDTO) {
        salidaDTO.setId(id);
        Salida salida = salidaUtil.convertToEntity(salidaDTO);
        SalidaDTOamp salidaDTOamp = salidaUtil.convertToDTOamp(salidaService.updateSalida(id, salida));
        return ResponseEntity.ok(salidaDTOamp);
    }

    @PutMapping("/{id}/barco")
    public ResponseEntity<SalidaDTOamp> updateSalidaBarco(@PathVariable Long id, @RequestBody String barcomatricula) {
        salidaService.updateSalidaBarco(id, barcomatricula);
        Salida salida = salidaService.getSalidaById(id);
        return ResponseEntity.ok(salidaUtil.convertToDTOamp(salida));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalida(@PathVariable Long id) {
        salidaService.deleteSalida(id);
        return ResponseEntity.ok().build();
    }


}
