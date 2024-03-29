package com.iesrfa.curso.clase05.controllers.dto;
import lombok.Data;

import java.util.UUID;

@Data
public class CategoriaDto {
    private UUID id;
    private String nombreCategoria;
    private String descripcion;
}
