package com.iesrfa.curso.clase05.services.repository;

import com.iesrfa.curso.clase05.models.FacturacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface FacturacionRepository extends JpaRepository<FacturacionEntity, UUID>, JpaSpecificationExecutor<FacturacionEntity> {
}