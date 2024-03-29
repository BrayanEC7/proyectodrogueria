package com.iesrfa.curso.clase05.controllers;
import com.iesrfa.curso.clase05.controllers.dto.FacturacionDto;
import com.iesrfa.curso.clase05.services.FacturacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/facturacion")
@CrossOrigin(origins = "*")
public class FacturacionController {
    @Autowired
    FacturacionService servicio;

    @GetMapping()
    public ResponseEntity<List<FacturacionDto>> getAll() {
        try {
            List<FacturacionDto> datos = servicio.getAll();
            return new ResponseEntity<>(datos, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping()
    public ResponseEntity<FacturacionDto> save(@RequestBody FacturacionDto dto){
        try{
            //if(dto.getFechanacimiento().toString().is.equals("")){

            System.out.println(dto);
            return new ResponseEntity<>(servicio.saveFacturacion(dto),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping()
    public ResponseEntity<FacturacionDto> update(@RequestBody FacturacionDto dto){
        try{
            return  new ResponseEntity<>(servicio.saveFacturacion(dto),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id){
        try{
            String mensaje=Boolean.TRUE.equals(servicio.deleteFacturacion(id))?"Registro Eliminado":"Error Al Eliminar Registro";
            return  new ResponseEntity<>(mensaje,HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
