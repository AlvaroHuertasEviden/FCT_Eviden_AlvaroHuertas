package com.alvaro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alvaro.model.CapitanExterno;
import org.springframework.stereotype.Repository;

@Repository
public interface CapitanExternoRepository extends JpaRepository<CapitanExterno, Long> {

}
