package com.iesrfa.curso.clase05.models;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name="tbPresentacion")
public class PresentacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPresentacion", nullable = false)
    private UUID id;
    @Column(name = "nombrePresentacion", nullable = false)
    private String nombrePresentacion;
}
