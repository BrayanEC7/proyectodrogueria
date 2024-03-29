package com.iesrfa.curso.clase05.models;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name="tbCategoria")
public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCategoria", nullable = false)
    private UUID id;
    @Column(name = "nombreCategoria", nullable = false)
    private String nombreCategoria;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
}
