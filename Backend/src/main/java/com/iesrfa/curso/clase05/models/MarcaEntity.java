package com.iesrfa.curso.clase05.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbMarca")
public class MarcaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idMarca", nullable = false)
    private UUID id;
    @Column(name = "nombreMarca", nullable = false)
    private String nombreMarca;
}
