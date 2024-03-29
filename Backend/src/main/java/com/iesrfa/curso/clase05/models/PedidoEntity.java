package com.iesrfa.curso.clase05.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name="tbPedido")
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPedido", nullable = false)
    private UUID id;
    @Column(name = "numeroPedido")
    private int numeroPedido;
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private ClienteEntity idCliente;
    @ManyToOne
    @JoinColumn(name = "idProducto")
    private ProductoEntity idProducto;
    @Column(name = "fechaPedido")
    private String fechaPedido;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "subtotal")
    private double subtotal;
    @Column(name = "descuento")
    private double descuento;
    @Column(name = "totalPagar")
    private String totalPagar;
    @Column(name = "estado")
    private String estado;
}
