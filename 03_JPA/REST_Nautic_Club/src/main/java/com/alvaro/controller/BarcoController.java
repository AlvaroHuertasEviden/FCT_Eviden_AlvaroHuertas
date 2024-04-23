package com.alvaro.controller;

import com.alvaro.dto.BarcoDTOamp;
import com.alvaro.dto.BarcoDTOsimple;
import com.alvaro.model.Barco;
import com.alvaro.model.Socio;
import com.alvaro.service.BarcoService;
import com.alvaro.service.SocioService;
import com.alvaro.utils.BarcoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/barcos")
public class BarcoController {

    @Autowired
    private BarcoService barcoService;

    @Autowired
    private BarcoUtil barcoUtil;

    @Autowired
    private SocioService socioservice;

    @GetMapping
    public ResponseEntity<List<BarcoDTOamp>> getAllBarcos() {
        List<Barco> barcos = barcoService.getAllBarcos();
        List<BarcoDTOamp> barcosDTO = new ArrayList<>();
        for (Barco barco : barcos) {
            barcosDTO.add(barcoUtil.convertToDTO(barco).add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BarcoController.class)
                    .getBarcoById(barco.getMatricula())).withSelfRel()));
        }
        return ResponseEntity.ok(barcosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarcoDTOamp> getBarcoById(@PathVariable String id) {
        BarcoDTOamp barcoDTOamp = barcoUtil.convertToDTO(barcoService.getBarcoById(id));
        return ResponseEntity.ok(barcoDTOamp);
    }

    @PostMapping
    public ResponseEntity<Barco> createBarco(@RequestBody BarcoDTOsimple barcoDTO) {
        Barco barco = barcoUtil.convertToEntity(barcoDTO, barcoDTO.getMatricula());
        int id = 0;
        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BarcoController.class)
                .postBarcoSocio(barcoDTO.getMatricula(), id)).withRel("postSocioBarco");
        Barco nuevoBarco = barcoService.createBarco(barco);
        nuevoBarco.add(link);
        return ResponseEntity.ok().body(nuevoBarco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BarcoDTOamp> updateBarco(@PathVariable String id, @RequestBody BarcoDTOsimple barcoDTO) {
        barcoDTO.setMatricula(null);
        Barco barco = barcoUtil.convertToEntity(barcoDTO, id);
        barcoService.updateBarco(id, barco);
        BarcoDTOamp barcoDTOamp = barcoUtil.convertToDTO(barcoService.updateBarco(id, barco));
        return ResponseEntity.ok(barcoDTOamp);
    }

    @PostMapping("/{id}/socio")
    public ResponseEntity<BarcoDTOamp> postBarcoSocio(@PathVariable String id, @RequestBody int socioid) {
        if (barcoService.getBarcoById(id).getSocio() != null) {
            BarcoDTOamp barcoDTOamp = barcoUtil.convertToDTO(barcoService.getBarcoById(id));
            Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BarcoController.class)
                    .updateBarcoSocio(id, socioid)).withRel("updateSocioBarco");
            barcoDTOamp.add(link);
            return new ResponseEntity<>(barcoDTOamp, HttpStatus.CONFLICT);
        }
        Socio socio = socioservice.getSocioById((long) socioid);
        socio.setBarco(barcoService.getBarcoById(id));
        socioservice.updateSocio((long) socioid, socio);
        Barco barco = barcoService.updateBarcoSocio(id, socioid);
        BarcoDTOamp barcoDTOamp = barcoUtil.convertToDTO(barco);
        return ResponseEntity.ok(barcoDTOamp);
    }

    @PutMapping("/{id}/socio")
    public ResponseEntity<BarcoDTOamp> updateBarcoSocio(@PathVariable String id, @RequestBody int socioid) {
        if (barcoService.getBarcoById(id).getSocio() == null) {
            BarcoDTOamp barcoDTOamp = barcoUtil.convertToDTO(barcoService.getBarcoById(id));
            Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BarcoController.class)
                    .postBarcoSocio(id, socioid)).withRel("postSocioBarco");
            return new ResponseEntity<>(barcoDTOamp, HttpStatus.CONFLICT);
        }
        Socio socio = socioservice.getSocioById((long) socioid);
        socio.setBarcos(new ArrayList<>());
        Barco barco = barcoService.updateBarcoSocio(id, socioid);
        socioservice.updateSocio((long) socioid, socio);
        socioservice.deleteBarcoSocioByMatricula(barco.getMatricula());
        socio.setBarco(barcoService.getBarcoById(id));

        socioservice.updateSocio((long) socioid, socio);
        BarcoDTOamp barcoDTOamp = barcoUtil.convertToDTO(barco);
        return ResponseEntity.ok(barcoDTOamp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBarco(@PathVariable String id) {
        socioservice.deleteBarcoSocioByMatricula(id);
        barcoService.deleteBarco(id);
        return ResponseEntity.ok().build();
    }

}
