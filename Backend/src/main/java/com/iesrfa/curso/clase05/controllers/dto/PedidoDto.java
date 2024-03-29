package com.iesrfa.curso.clase05.controllers.dto;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class PedidoDto {
    private UUID id=null;
    private int numeroPedido;
    private UUID idCliente;
    private UUID idProducto;
    private String fechaPedido;
    private int cantidad;
    private double subtotal;
    private double descuento;
    private double totalPagar;
    private String estado;
    private String idClienteNumDocCliente;
    private String idClienteNombreCliente;
    private String idProductoCodigoProducto;
    private String idProductoNombreProducto;
    private String idProductoPrecioVenta;
}
