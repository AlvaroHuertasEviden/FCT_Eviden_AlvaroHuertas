package com.alvaro.criteria_tests;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.alvaro.model.Barco;
import com.alvaro.model.CapitanExterno;
import com.alvaro.model.Patron;
import com.alvaro.model.Salida;
import com.alvaro.model.Socio;
import com.alvaro.repository.SalidaRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SalidaCriteriaTest {
	
	@Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SalidaRepository salidaRepository;

	@Test
	void testCountSalidasByBarcoAndCapitainNoSocio() {
		// 1 Socio
		Socio socio = new Socio();
	    socio.setNombre("Álvaro Huertas");
	    socio.setTelefono("+34 646309325");
	    socio.setCuota(BigDecimal.TEN);
	    socio.setBarcos(new ArrayList<Barco>());
	    entityManager.persist(socio);
	    
	    // Que tiene 1 barco
	    Barco barco1 = new Barco();
	    barco1.setMatricula("ABC123");
	    barco1.setNombre("Motor Yatch");
	    barco1.setNamarre("A1");
	    barco1.setCuota(BigDecimal.TEN);
	    barco1.setSocio(socio);
	    socio.setBarco(barco1);
	    entityManager.persist(barco1);
	    
	    // Que ha hecho 1 salida siendo el el patrón
	    Patron patron = new Patron();
	    patron.setSocio(socio);
	    entityManager.persist(patron);
	    
		Salida salida = new Salida();
        salida.setFechaHoraSalida(LocalDateTime.now());
        salida.setDestino("Destiono test salida 1, por dueño");
        salida.setBarco(barco1);
        salida.setPatron(patron);
        entityManager.persist(salida);
        
        // Y 1 capitán externo
        CapitanExterno capitanExterno = new CapitanExterno();
        capitanExterno.setNombre("Andrés Alba");
        capitanExterno.setTelefono("+1234567890");
        entityManager.persist(capitanExterno);
        
        Patron patron2 = new Patron();
	    patron2.setCapitanExterno(capitanExterno);
	    entityManager.persist(patron2);
        
        // Que realiza 2 salidas
        Salida salida2 = new Salida();
        salida2.setFechaHoraSalida(LocalDateTime.now());
        salida2.setDestino("Destiono test salida 2, por capitan externo");
        salida2.setBarco(barco1);
        salida2.setPatron(patron2);
        entityManager.persist(salida2);
        
        Salida salida3 = new Salida();
        salida3.setFechaHoraSalida(LocalDateTime.now());
        salida3.setDestino("Destiono test salida 3, por capitan externo");
        salida3.setBarco(barco1);
        salida3.setPatron(patron2);
        entityManager.persist(salida3);
        
        entityManager.flush();
        
        System.out.println(salidaRepository.findAll());
        
        
        // Número de salidas que ha realizado un barco el cuál su dueño no era el capitán
        long count = salidaRepository.countSalidasByBarcoAndCapitanNoSocio("ABC123");
        assertEquals(2, count);
	}

}
