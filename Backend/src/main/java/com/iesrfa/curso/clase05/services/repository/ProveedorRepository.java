package com.iesrfa.curso.clase05.services.repository;

import com.iesrfa.curso.clase05.models.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;
import java.util.UUID;
@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntity, UUID>, JpaSpecificationExecutor<ProveedorEntity> {
    @Query("SELECT id AS ID, nombreProveedor AS NOMBRE, ruc AS RUC, telefono AS TELEFONO  " +
            "FROM ProveedorEntity WHERE lower(nombreProveedor) LIKE ?1%")
    List<Tuple> findBusquedaBy(String nombreProveedor);
}