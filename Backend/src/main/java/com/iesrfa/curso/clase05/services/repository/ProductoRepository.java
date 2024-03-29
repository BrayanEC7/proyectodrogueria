package com.iesrfa.curso.clase05.services.repository;

import com.iesrfa.curso.clase05.models.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;
import java.util.UUID;
@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, UUID> {
    ProductoEntity findByCodigoProducto(int codigoProducto);

}