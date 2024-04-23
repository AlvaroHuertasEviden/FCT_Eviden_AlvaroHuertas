package com.alvaro.jpql_tests;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.alvaro.model.Barco;
import com.alvaro.model.Socio;
import com.alvaro.repository.BarcoRepository;
import com.alvaro.repository.SocioRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SocioJPQLTests {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private SocioRepository socioRepository;
	
	@Autowired
	private BarcoRepository barcoRepository;

	@Test
	void testFindBoatsBySocio() {
	    Socio socio = new Socio();
	    socio.setNombre("Álvaro Huertas");
	    socio.setTelefono("+34 646309325");
	    socio.setCuota(BigDecimal.TEN);
	    socio.setBarcos(new ArrayList<Barco>());
	    entityManager.persist(socio);

	    	    
	    Socio socio2 = new Socio();
	    socio2.setNombre("Andrés Alba");
	    socio2.setTelefono("+12 1248534343");
	    socio2.setCuota(BigDecimal.TEN);
	    socio2.setBarcos(new ArrayList<Barco>());
	    entityManager.persist(socio2);
	    
	    Barco barco1 = new Barco();
	    barco1.setMatricula("ABC123");
	    barco1.setNombre("Motor Yatch");
	    barco1.setNamarre("A1");
	    barco1.setCuota(BigDecimal.TEN);
	    barco1.setSocio(socio);
	    socio.setBarco(barco1);
	    entityManager.persist(barco1);
	    
	    Barco barco2 = new Barco();
	    barco2.setMatricula("DEF456");
	    barco2.setNombre("Sail Boat");
	    barco2.setNamarre("B2");
	    barco2.setCuota(BigDecimal.TEN);
	    barco2.setSocio(socio2);
	    socio2.setBarco(barco2);
	    entityManager.persist(barco2);

	    entityManager.flush();
	    
	    System.out.println("find all Socio: " + socioRepository.findAll());
	    System.out.println("find all barco: " + barcoRepository.findAll());
	    
	    Socio socioEncontrado = socioRepository.findSocioByMatriculaBarco("ABC123");
	    System.out.println(socioEncontrado);
	    
	    assertEquals(socioEncontrado, socio);
	    assertNotEquals(socioEncontrado.getNombre(), socio2.getNombre());
	}

}
