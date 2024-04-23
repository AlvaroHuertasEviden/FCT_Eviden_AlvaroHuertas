package com.alvaro.crud_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.alvaro.model.Socio;
import com.alvaro.repository.SocioRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SocioRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private SocioRepository socioRepository;
	
	@Test
	void testCreate() {
        Socio socio = new Socio();
        socio.setNombre("Álvaro Heurtas");
        socio.setTelefono("+34 646309325");
        socio.setCuota(BigDecimal.TEN);

        Socio savedSocio = socioRepository.save(socio);

        assertEquals(socio, savedSocio);
        assertTrue(savedSocio.getId() > 0);
    }
	
	@Test
    void testRead() {
        Socio socio = new Socio();
        socio.setNombre("Álvaro Heurtas");
        socio.setTelefono("+34 646309325");
        socio.setCuota(BigDecimal.TEN);

        entityManager.persist(socio);
        entityManager.flush();
        
        Socio socioFromDb = socioRepository.findById(socio.getId()).orElse(null);

        assertNotNull(socioFromDb);
        assertEquals(socio.getNombre(), socioFromDb.getNombre());
        assertEquals(socio.getTelefono(), socioFromDb.getTelefono());
        assertEquals(socio.getCuota(), socioFromDb.getCuota());
	}
	
	@Test
    void testUpdate() {
        Socio socio = new Socio();
        socio.setNombre("Álvaro Heurtas");
        socio.setTelefono("+34 646309325");
        socio.setCuota(BigDecimal.TEN);

        entityManager.persist(socio);

        socio.setNombre("Nuevo Nombre");
        socio.setTelefono("+34 600000000");
        socio.setCuota(BigDecimal.valueOf(20));

        Socio updatedSocio = socioRepository.save(socio);

        assertNotNull(updatedSocio);
        assertEquals(socio.getId(), updatedSocio.getId());
        assertEquals("Nuevo Nombre", updatedSocio.getNombre());
        assertEquals("+34 600000000", updatedSocio.getTelefono());
        assertEquals(BigDecimal.valueOf(20), updatedSocio.getCuota());
    }
	
	@Test
	void testDelete() {
        Socio socio = new Socio();
        socio.setNombre("Álvaro Heurtas");
        socio.setTelefono("+34 646309325");
        socio.setCuota(BigDecimal.TEN);

        Socio savedSocio = entityManager.persistFlushFind(socio);
        socioRepository.delete(savedSocio);

        assertTrue(socioRepository.findById(savedSocio.getId()).isEmpty());
    }

}
