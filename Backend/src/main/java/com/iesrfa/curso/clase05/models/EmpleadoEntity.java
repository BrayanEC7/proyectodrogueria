package com.iesrfa.curso.clase05.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name="tbEmpleado")
public class EmpleadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idEmpleado", nullable = false)
    private UUID id;
    @Column(name = "nombreEmpleado", nullable = false)
    private String nombreEmpleado;
    @Column(name = "documentoEmpleado")
    private String documentoEmpleado;
    @Column(name = "cargo", nullable = false)
    private String cargo;
    @Column(name = "telefono", nullable = false)
    private String telefono;
    @Column(name = "correo", nullable = false)
    private String correo;
    @Column(name = "fechanacimiento", nullable = false)
    private String fechanacimiento;
}
