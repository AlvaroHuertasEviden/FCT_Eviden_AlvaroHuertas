package com.alvaro.controller;

import com.alvaro.model.CapitanExterno;
import com.alvaro.service.CapitanExternoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/capitanes-externos")
public class CapitanExternoController {
    
    @Autowired
    private CapitanExternoService capitanExternoService;

    @GetMapping
    public ResponseEntity<List<CapitanExterno>> getAllCapitanExternos() {
        return ResponseEntity.ok(capitanExternoService.getAllCapitanExternos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CapitanExterno> getCapitanExternoById(@PathVariable Long id) {
        return ResponseEntity.ok(capitanExternoService.getCapitanExternoById(id));
    }

    @PostMapping
    public ResponseEntity<CapitanExterno> createCapitanExterno(@RequestBody CapitanExterno CapitanExterno) {
        return ResponseEntity.ok(capitanExternoService.createCapitanExterno(CapitanExterno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CapitanExterno> updateCapitanExterno(@PathVariable Long id, @RequestBody CapitanExterno CapitanExterno) {
        return ResponseEntity.ok(capitanExternoService.updateCapitanExterno(id, CapitanExterno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCapitanExterno(@PathVariable Long id) {
        capitanExternoService.deleteCapitanExterno(id);
        return ResponseEntity.ok().build();
    }
    
}
