package com.iesrfa.curso.clase05.controllers;

import com.iesrfa.curso.clase05.controllers.dto.ClienteDto;
import com.iesrfa.curso.clase05.controllers.dto.MarcaDto;
import com.iesrfa.curso.clase05.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/marca")
@CrossOrigin(origins = "*")
public class MarcaController {
    @Autowired
    MarcaService servicio;

    @GetMapping()
    public ResponseEntity<List<MarcaDto>> getAll() {
        try {
            List<MarcaDto> datos = servicio.getAll();
            return new ResponseEntity<>(datos, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("buscarBy/{valor}")
    public ResponseEntity<List<MarcaDto>> findBusquedaBy(@PathVariable(name = "valor", required = false) String valor) {
        try {
            //System.out.println("MENSAJE DE AVISO IMPORTANTE " + valor);
            return new ResponseEntity<>(servicio.findBusquedaBy(valor), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping()
    public ResponseEntity<MarcaDto> save(@RequestBody MarcaDto dto){
        try{
            //if(dto.getFechanacimiento().toString().is.equals("")){

            System.out.println(dto);
            return new ResponseEntity<>(servicio.saveMarca(dto),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping()
    public ResponseEntity<MarcaDto> update(@RequestBody MarcaDto dto){
        try{
            return  new ResponseEntity<>(servicio.saveMarca(dto),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id){
        try{
            String mensaje=Boolean.TRUE.equals(servicio.deleteMarca(id))?"Registro Eliminado":"Error Al Eliminar Registro";
            return  new ResponseEntity<>(mensaje,HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
