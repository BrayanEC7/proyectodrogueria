package com.iesrfa.curso.clase05.services.repository;

import com.iesrfa.curso.clase05.models.PresentacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;
import java.util.UUID;
@Repository
public interface PresentacionRepository extends JpaRepository<PresentacionEntity, UUID> {
    @Query("SELECT id AS ID, nombrePresentacion AS NOMBRE " +
            "FROM PresentacionEntity WHERE lower(nombrePresentacion) LIKE ?1%")
    List<Tuple> findBusquedaBy(String nombrePresentacion);
}