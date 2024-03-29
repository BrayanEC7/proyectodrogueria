package com.iesrfa.curso.clase05.controllers.dto;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class EmpleadoDto {
    private UUID id=null;
    private String nombreEmpleado;
    private String documentoEmpleado=null;
    private String cargo;
    private String telefono;
    private String correo;
    private String fechanacimiento;
}
