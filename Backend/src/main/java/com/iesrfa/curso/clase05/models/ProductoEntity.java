package com.iesrfa.curso.clase05.models;

import lombok.Data;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name="tbProducto")
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idProducto", nullable = false)
    private UUID id;
    @Column(name = "codigoProducto", nullable = false)
    private int codigoProducto;
    @Column(name = "nombreProducto", nullable = false)
    private String nombreProducto;
    @Column(name = "fechaVencimiento", nullable = false)
    private String fechaVencimiento;
    @Column(name = "stock", nullable = false)
    private int stock;
    @Column(name = "precioCompra", nullable = false)
    private double precioCompra;
    @Column(name = "precioVenta", nullable = false)
    private double precioVenta;
    @ManyToOne
    @JoinColumn(name = "idMarca")
    private MarcaEntity idMarca;
    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private CategoriaEntity idCategoria;
    @ManyToOne
    @JoinColumn(name = "idProveedor")
    private ProveedorEntity idProveedor;
    @ManyToOne
    @JoinColumn(name = "idPresentacion")
    private PresentacionEntity idPresentacion;
}
