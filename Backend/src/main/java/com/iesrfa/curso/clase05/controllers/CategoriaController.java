package com.iesrfa.curso.clase05.controllers;
import com.iesrfa.curso.clase05.controllers.dto.CategoriaDto;
import com.iesrfa.curso.clase05.controllers.dto.ClienteDto;
import com.iesrfa.curso.clase05.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/categoria")
@CrossOrigin(origins = "*")
public class CategoriaController {
    @Autowired
    CategoriaService servicio;

    @GetMapping()
    public ResponseEntity<List<CategoriaDto>> getAll() {
        try {
            List<CategoriaDto> datos = servicio.getAll();
            return new ResponseEntity<>(datos, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("buscarBy/{valor}")
    public ResponseEntity<List<CategoriaDto>> findBusquedaBy(@PathVariable(name = "valor", required = false) String valor) {
        try {
            //System.out.println("MENSAJE DE AVISO IMPORTANTE " + valor);
            return new ResponseEntity<>(servicio.findBusquedaBy(valor), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping()
    public ResponseEntity<CategoriaDto> save(@RequestBody CategoriaDto dto){
        try{
            //if(dto.getFechanacimiento().toString().is.equals("")){

            System.out.println(dto);
            return new ResponseEntity<>(servicio.saveCategoria(dto),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping()
    public ResponseEntity<CategoriaDto> update(@RequestBody CategoriaDto dto){
        try{
            return  new ResponseEntity<>(servicio.saveCategoria(dto),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id){
        try{
            String mensaje=Boolean.TRUE.equals(servicio.deleteCategoria(id))?"Registro Eliminado":"Error Al Eliminar Registro";
            return  new ResponseEntity<>(mensaje,HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
