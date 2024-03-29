package com.iesrfa.curso.clase05.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name="tbFacturacion")
public class FacturacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idFacturacion", nullable = false)
    private UUID id;
    @Column(name = "serieComprobante")
    private String serieComprobante;
    @Column(name = "tipoComprobante")
    private String tipoComprobante;
    @Column(name = "fechaFacturacion")
    private String fechaFacturacion;
    @OneToOne
    @JoinColumn(name = "idPedido")
    private PedidoEntity idPedido;
}
