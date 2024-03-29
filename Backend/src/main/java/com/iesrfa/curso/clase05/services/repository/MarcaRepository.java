package com.iesrfa.curso.clase05.services.repository;

import com.iesrfa.curso.clase05.models.ClienteEntity;
import com.iesrfa.curso.clase05.models.MarcaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;
import java.util.UUID;
@Repository
public interface MarcaRepository extends JpaRepository<MarcaEntity, UUID> {
    @Query("SELECT id AS ID, nombreMarca AS NOMBREMARCA " +
            "FROM MarcaEntity WHERE lower(nombreMarca) LIKE ?1%")
    List<Tuple> findBusquedaBy(String nombreMarca);
}