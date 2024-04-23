package com.alvaro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alvaro.model.Socio;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SocioRepository extends JpaRepository<Socio, Long> {
	@Query("SELECT s FROM Socio s JOIN s.barcos b WHERE b.matricula = :matricula")
    Socio findSocioByMatriculaBarco(@Param("matricula") String matricula);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE FROM socio_barcos WHERE barcos_matricula = :matricula")
    void deleteSocioBarcoByMatricula(@Param("matricula") String matricula);
}
