package com.iesrfa.curso.clase05.controllers.dto;
import lombok.Data;

import java.util.UUID;

@Data
public class ProductoDto {
    private UUID id=null;
    private int codigoProducto;
    private String nombreProducto;
    private String fechaVencimiento;
    private int stock;
    private double precioCompra;
    private double precioVenta;
    private UUID idMarca;
    private UUID idCategoria;
    private UUID idProveedor;
    private UUID idPresentacion;
    private String idMarcaNombreMarca;
    private String idCategoriaNombreCategoria;
    private String idProveedorNombreProveedor;
    private String idPresentacionNombrePresentacion;
}
