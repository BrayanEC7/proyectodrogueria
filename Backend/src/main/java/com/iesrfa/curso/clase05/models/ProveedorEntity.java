package com.iesrfa.curso.clase05.models;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name="tbProveedor")
public class ProveedorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idProveedor", nullable = false)
    private UUID id;
    @Column(name = "nombreProveedor", nullable = false)
    private String nombreProveedor;
    @Column(name = "RUC", nullable = false)
    private String ruc;
    @Column(name = "telefono", nullable = false)
    private String telefono;
}
