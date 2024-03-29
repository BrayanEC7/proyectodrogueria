package com.iesrfa.curso.clase05.controllers.dto;
import lombok.Data;

import java.util.UUID;

@Data
public class UsuarioDto {
    private UUID id;
    private String user;

    private String password;

    private String nombre;

    private UUID idEmpleado;
    private String idEmpleadoNombreEmpleado;
    private boolean rescribirclave=false;

}
