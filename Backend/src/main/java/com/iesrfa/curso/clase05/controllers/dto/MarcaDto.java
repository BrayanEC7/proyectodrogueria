package com.iesrfa.curso.clase05.controllers.dto;
import lombok.Data;

import java.util.UUID;

@Data
public class MarcaDto {
    private UUID id=null;
    private String nombreMarca;
}
