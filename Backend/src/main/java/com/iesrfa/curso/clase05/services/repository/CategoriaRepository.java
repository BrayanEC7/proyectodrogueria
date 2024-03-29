package com.iesrfa.curso.clase05.services.repository;

import com.iesrfa.curso.clase05.models.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;
import java.util.UUID;
@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, UUID> {
    @Query("SELECT id AS ID, nombreCategoria AS NOMBRE, descripcion AS DESCRIP " +
            "FROM CategoriaEntity WHERE lower(nombreCategoria) LIKE ?1%")
    List<Tuple> findBusquedaBy(String nombreCategoria);
}