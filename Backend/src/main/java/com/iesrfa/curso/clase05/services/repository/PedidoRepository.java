package com.iesrfa.curso.clase05.services.repository;

import com.iesrfa.curso.clase05.models.PedidoEntity;
import com.iesrfa.curso.clase05.models.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, UUID>, JpaSpecificationExecutor<PedidoEntity> {
    PedidoEntity findByNumeroPedido(int numeroPedido);
}