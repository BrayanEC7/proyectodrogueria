package com.iesrfa.curso.clase05.controllers.dto;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class FacturacionDto {
    private UUID id=null;
    private String serieComprobante;
    private String tipoComprobante;
    private String fechaFacturacion;
    private UUID idPedido;
    private int idPedidoNumeroPedido;
}
