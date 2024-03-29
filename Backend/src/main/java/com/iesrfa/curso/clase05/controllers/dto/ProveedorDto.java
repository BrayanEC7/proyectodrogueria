package com.iesrfa.curso.clase05.controllers.dto;
import lombok.Data;

import java.util.UUID;

@Data
public class ProveedorDto {
    private UUID id=null;
    private String nombreProveedor;
    private String ruc;
    private String telefono;
}
