package com.alvaro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alvaro.model.Salida;
import org.springframework.stereotype.Repository;

@Repository
public interface SalidaRepository extends JpaRepository<Salida, Long>, SalidaRepositoryCustom {
	
}
