package com.iesrfa.curso.clase05.controllers;

import com.iesrfa.curso.clase05.controllers.dto.ClienteDto;
import com.iesrfa.curso.clase05.controllers.dto.EmpleadoDto;
import com.iesrfa.curso.clase05.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/cliente")
@CrossOrigin(origins = "*")
public class ClienteController {
    @Autowired
    ClienteService servicio;

    @GetMapping()
    public ResponseEntity<List<ClienteDto>> getAll() {
        try {
            List<ClienteDto> datos = servicio.getAll();
            return new ResponseEntity<>(datos, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    //agregue nuevo
    @GetMapping("buscarPorDoc/{numDocCliente}")
    public ResponseEntity<ClienteDto> findBusq(@PathVariable(name = "numDocCliente", required = false) String nom) {
        try {
            return new ResponseEntity<>(servicio.findBusq(nom), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("buscarBy/{valor}")
    public ResponseEntity<List<ClienteDto>> findBusquedaBy(@PathVariable(name = "valor", required = false) String valor) {
        try {
            return new ResponseEntity<>(servicio.findBusquedaBy(valor), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<ClienteDto> save(@RequestBody ClienteDto dto) {
        try {
            //if(dto.getFechanacimiento().toString().is.equals("")){

            System.out.println(dto);
            return new ResponseEntity<>(servicio.saveCliente(dto), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping()
    public ResponseEntity<ClienteDto> update(@RequestBody ClienteDto dto) {
        try {
            return new ResponseEntity<>(servicio.saveCliente(dto), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        try {
            String mensaje = Boolean.TRUE.equals(servicio.deleteCliente(id)) ? "Registro Eliminado" : "Error Al Eliminar Registro";
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
