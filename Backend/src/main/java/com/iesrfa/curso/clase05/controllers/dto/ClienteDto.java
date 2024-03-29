package com.iesrfa.curso.clase05.controllers.dto;
import lombok.Data;

import java.util.UUID;

@Data
public class ClienteDto {
    private UUID id=null;
    private String tipoDocumento;
    private String numDocCliente;
    private String nombreCliente;
    private String celularCliente;
    private String correoCliente;
    private String direccionCliente;
}
