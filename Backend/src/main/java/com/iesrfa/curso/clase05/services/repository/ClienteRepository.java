package com.iesrfa.curso.clase05.services.repository;


import com.iesrfa.curso.clase05.models.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;
import java.util.UUID;
@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, UUID> {

    @Query("SELECT id, tipoDocumento, numDocCliente, " +
            "nombreCliente, celularCliente, " +
            "correoCliente, " +
            "direccionCliente " +
            "FROM ClienteEntity WHERE numDocCliente LIKE ?1%  ")
    List<Tuple> finAllClienteSearch(String numDocCliente);
    //@Query("select nombreCliente from ClienteEntity where numDocCliente Like :numDocCliente% ")
    @Query("SELECT id AS ID, nombreCliente AS NOMBRE FROM ClienteEntity WHERE numDocCliente LIKE ?1%")
    List<Tuple> findBusqId(String numDocCliente);
    @Query("SELECT id AS ID, tipoDocumento AS TIPO, numDocCliente AS NUM," +
            " nombreCliente AS NOMBRE, celularCliente AS CELULAR," +
            " correoCliente AS CORREO, direccionCliente AS DIRECCION " +
            " FROM ClienteEntity WHERE numDocCliente LIKE '?1%'")
    List<Tuple> findBusquedaBy(String numDocCliente);
    ClienteEntity findByNumDocCliente(String numDocCliente);
}