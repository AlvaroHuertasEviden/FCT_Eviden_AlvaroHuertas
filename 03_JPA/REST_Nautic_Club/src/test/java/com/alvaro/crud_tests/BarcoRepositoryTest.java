package com.alvaro.crud_tests;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.alvaro.model.Barco;
import com.alvaro.model.Socio;
import com.alvaro.repository.BarcoRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BarcoRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private BarcoRepository barcoRepository;

	@Test
	void testCreateAndRead() {
        Socio socio = new Socio();
        socio.setNombre("Nombre Socio");
        socio.setTelefono("123456789");
        socio.setCuota(BigDecimal.TEN);
        entityManager.persist(socio);

        Barco barco = new Barco();
        barco.setMatricula("ABC123");
        barco.setNombre("Mi Barco");
        barco.setNamarre("A1");
        barco.setCuota(BigDecimal.TEN);
        barco.setSocio(socio);

        entityManager.persist(barco);
        entityManager.flush();

        Barco createdBarco = barcoRepository.findById(barco.getMatricula()).orElse(null);
        assertNotNull(createdBarco);
        assertEquals(barco.getMatricula(), createdBarco.getMatricula());
        assertEquals(barco.getNombre(), createdBarco.getNombre());
        assertEquals(barco.getNamarre(), createdBarco.getNamarre());
        assertEquals(barco.getCuota(), createdBarco.getCuota());
        assertEquals(barco.getSocio(), createdBarco.getSocio());
    }
	
	@Test
    void testUpdate() {
		Barco barco = new Barco();
        barco.setMatricula("ABC123");
        barco.setNombre("Mi Barco");
        barco.setNamarre("A1");
        barco.setCuota(BigDecimal.TEN);

        entityManager.persist(barco);
        entityManager.flush();

        barco.setNombre("Nuevo Nombre");
        barco.setNamarre("B2");
        barco.setCuota(BigDecimal.valueOf(20));

        Barco updatedBarco = barcoRepository.save(barco);

        assertNotNull(updatedBarco);
        assertEquals(barco.getMatricula(), updatedBarco.getMatricula());
        assertEquals("Nuevo Nombre", updatedBarco.getNombre());
        assertEquals("B2", updatedBarco.getNamarre());
        assertEquals(BigDecimal.valueOf(20), updatedBarco.getCuota());
    }
	
	@Test
	void testDelete() {
		Barco barco = new Barco();
        barco.setMatricula("ABC123");
        barco.setNombre("Mi Barco");
        barco.setNamarre("A1");
        barco.setCuota(BigDecimal.TEN);

        entityManager.persist(barco);
        entityManager.flush();

        barcoRepository.delete(barco);

        assertFalse(barcoRepository.existsById(barco.getMatricula()));
    }

}
