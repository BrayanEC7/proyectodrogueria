package com.iesrfa.curso.clase05.controllers;

import com.iesrfa.curso.clase05.controllers.dto.ProveedorDto;
import com.iesrfa.curso.clase05.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/proveedor")
@CrossOrigin(origins = "*")
public class ProveedorController {
    @Autowired
    ProveedorService servicio;

    @GetMapping()
    public ResponseEntity<List<ProveedorDto>> getAll() {
        try {
            List<ProveedorDto> datos = servicio.getAll();
            return new ResponseEntity<>(datos, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("buscarBy/{valor}")
    public ResponseEntity<List<ProveedorDto>> findBusquedaBy(@PathVariable(name = "valor", required = false) String valor) {
        try {
            //System.out.println("MENSAJE DE AVISO IMPORTANTE " + valor);
            return new ResponseEntity<>(servicio.findBusquedaBy(valor), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<ProveedorDto> save(@RequestBody ProveedorDto dto){
        try{
            //if(dto.getFechanacimiento().toString().is.equals("")){

            System.out.println(dto);
            return new ResponseEntity<>(servicio.saveProveedor(dto),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping()
    public ResponseEntity<ProveedorDto> update(@RequestBody ProveedorDto dto){
        try{
            return  new ResponseEntity<>(servicio.saveProveedor(dto),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id){
        try{
            String mensaje=Boolean.TRUE.equals(servicio.deleteProveedor(id))?"Registro Eliminado":"Error Al Eliminar Registro";
            return  new ResponseEntity<>(mensaje,HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
