package com.alvaro.crud_tests;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.alvaro.model.Patron;
import com.alvaro.model.Salida;
import com.alvaro.model.Socio;
import com.alvaro.repository.SalidaRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SalidaRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private SalidaRepository salidaRepository;
	
	@Test
    void testCreateAndRead() {
		Socio socio = new Socio();
        socio.setNombre("Álvaro Heurtas");
        socio.setTelefono("+34 646309325");
        socio.setCuota(BigDecimal.TEN);
        entityManager.persist(socio);
        entityManager.flush();
		
		
	    Patron patron = new Patron();
	    patron.setSocio(socio);
	    entityManager.persist(patron);
	    entityManager.flush();
	    
		Salida salida = new Salida();
        salida.setFechaHoraSalida(LocalDateTime.now());
        salida.setDestino("Destiono test");
        salida.setPatron(patron);

        entityManager.persist(salida);
        entityManager.flush();

        Salida savedSalida = salidaRepository.findById(salida.getId()).orElse(null);
        assertNotNull(savedSalida);
        assertEquals(salida.getFechaHoraSalida(), savedSalida.getFechaHoraSalida());
        assertEquals(salida.getDestino(), savedSalida.getDestino());
        assertEquals(patron, savedSalida.getPatron());
    }

    @Test
    void testUpdate() {
        Salida salida = new Salida();
        salida.setFechaHoraSalida(LocalDateTime.now());
        salida.setDestino("Test Destination");
        entityManager.persist(salida);
        entityManager.flush();

        salida.setDestino("Updated Destination");
        entityManager.persistAndFlush(salida);

        Salida updatedSalida = salidaRepository.findById(salida.getId()).orElse(null);

        assertNotNull(updatedSalida);
        assertEquals("Updated Destination", updatedSalida.getDestino());
    }

    @Test
    void testDelete() {
        Salida salida = new Salida();
        salida.setFechaHoraSalida(LocalDateTime.now());
        salida.setDestino("Test Destination");
        entityManager.persist(salida);
        entityManager.flush();
        assertTrue(salidaRepository.findById(salida.getId()).isPresent());
        salidaRepository.delete(salida);

        assertFalse(salidaRepository.findById(salida.getId()).isPresent());
    }

}
