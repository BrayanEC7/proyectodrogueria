package com.iesrfa.curso.clase05.services.repository;

import com.iesrfa.curso.clase05.models.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;
import java.util.UUID;
@Repository
public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, UUID> {
    @Query("SELECT id AS ID, nombreEmpleado AS NOMBRE, cargo AS CARG, " +
            " telefono AS TELEF, correo AS COR,  fechanacimiento AS FECHA " +
            " FROM EmpleadoEntity WHERE lower(nombreEmpleado) LIKE ?1%")
    List<Tuple> findBusquedaBy(String nombreEmpleado);
}