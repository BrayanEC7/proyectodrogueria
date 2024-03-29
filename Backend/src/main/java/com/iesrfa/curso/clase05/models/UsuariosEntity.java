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
@Table(name="tbUsuarios")
public class UsuariosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idUsuario", nullable = false)
    private UUID id;
    @Column(name = "", nullable = false)
    private String user;
    @Column(name = "clave", nullable = false)
    private String password;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @OneToOne
    @JoinColumn(name="cr")
    private EmpleadoEntity idEmpleado;
}