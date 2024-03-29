package com.iesrfa.curso.clase05.models;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name="tbCliente")
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCliente", nullable = false)
    private UUID id;
    @Column(name = "tipoDocumento", nullable = false)
    private String tipoDocumento;
    @Column(name = "numDocCliente", nullable = false)
    private String numDocCliente;
    @Column(name = "nombreCliente", nullable = false)
    private String nombreCliente;
    @Column(name = "celularCliente", nullable = false)
    private String celularCliente;
    @Column(name = "correoCliente", nullable = false)
    private String correoCliente;
    @Column(name = "direccionCliente", nullable = false)
    private String direccionCliente;
}
