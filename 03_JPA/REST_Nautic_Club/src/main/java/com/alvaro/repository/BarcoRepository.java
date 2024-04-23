package com.alvaro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alvaro.model.Barco;
import org.springframework.stereotype.Repository;

@Repository
public interface BarcoRepository extends JpaRepository<Barco, String> {
	
}
