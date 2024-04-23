package com.alvaro.crud_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.alvaro.model.CapitanExterno;
import com.alvaro.repository.CapitanExternoRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CapitanExternoRepositoryTest {
	@Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CapitanExternoRepository capitanExternoRepository;

    @Test
    void testCreate() {
        CapitanExterno capitanExterno = new CapitanExterno();
        capitanExterno.setNombre("Andrés Alba");
        capitanExterno.setTelefono("+1234567890");

        CapitanExterno savedCapitanExterno = entityManager.persistAndFlush(capitanExterno);

        assertNotNull(savedCapitanExterno.getId());
        assertEquals("Andrés Alba", savedCapitanExterno.getNombre());
        assertEquals("+1234567890", savedCapitanExterno.getTelefono());
    }

    @Test
    void testRead() {
        CapitanExterno capitanExterno = new CapitanExterno();
        capitanExterno.setNombre("Andrés Alba");
        capitanExterno.setTelefono("+9876543210");
        entityManager.persistAndFlush(capitanExterno);

        CapitanExterno foundCapitanExterno = capitanExternoRepository.findById(capitanExterno.getId()).orElse(null);

        assertNotNull(foundCapitanExterno);
        assertEquals("Andrés Alba", foundCapitanExterno.getNombre());
        assertEquals("+9876543210", foundCapitanExterno.getTelefono());
    }

    @Test
    void testUpdate() {
        CapitanExterno capitanExterno = new CapitanExterno();
        capitanExterno.setNombre("Belén Huertas");
        capitanExterno.setTelefono("+1111111111");
        entityManager.persistAndFlush(capitanExterno);

        capitanExterno.setNombre("Updated Name");

        CapitanExterno updatedCapitanExterno = capitanExternoRepository.save(capitanExterno);

        assertEquals("Updated Name", updatedCapitanExterno.getNombre());
    }

    @Test
    void testDelete() {
        CapitanExterno capitanExterno = new CapitanExterno();
        capitanExterno.setNombre("Will Smith");
        capitanExterno.setTelefono("+2222222222");
        entityManager.persistAndFlush(capitanExterno);

        capitanExternoRepository.delete(capitanExterno);

        assertFalse(capitanExternoRepository.existsById(capitanExterno.getId()));
    }
}
