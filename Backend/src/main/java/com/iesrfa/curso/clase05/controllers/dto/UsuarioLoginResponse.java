package com.iesrfa.curso.clase05.controllers.dto;

import lombok.Data;

@Data
public class UsuarioLoginResponse {
    private int codigo=200;
    private String mensaje="";
    private String token="";
}