package com.alvaro.repository;

import org.springframework.stereotype.Repository;

import com.alvaro.model.Barco;
import com.alvaro.model.Patron;
import com.alvaro.model.Salida;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class SalidaRepositoryImpl implements SalidaRepositoryCustom {
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public long countSalidasByBarcoAndCapitanNoSocio(String matricula) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);
        Root<Salida> root = query.from(Salida.class);

        Join<Salida, Barco> barcoJoin = root.join("barco");
        Join<Salida, Patron> patronJoin = root.join("patron");

        Predicate matriculaPredicate = criteriaBuilder.equal(barcoJoin.get("matricula"), matricula);
        Predicate noPatronPredicate = criteriaBuilder.isNull(patronJoin.get("socio"));

        query.select(criteriaBuilder.count(root));
        query.where(criteriaBuilder.and(matriculaPredicate, noPatronPredicate));

        return entityManager.createQuery(query).getSingleResult();
	}

}
