package com.iesrfa.curso.clase05.controllers;
import com.iesrfa.curso.clase05.controllers.dto.ClienteDto;
import com.iesrfa.curso.clase05.controllers.dto.EmpleadoDto;
import com.iesrfa.curso.clase05.controllers.dto.ProductoDto;
import com.iesrfa.curso.clase05.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/producto")
@CrossOrigin(origins = "*")
public class ProductoController {
    @Autowired
    ProductoService servicio;

    @GetMapping()
    public ResponseEntity<List<ProductoDto>> getAll() {
        try {
            List<ProductoDto> datos = servicio.getAll();
            return new ResponseEntity<>(datos, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("buscarPorCod/{codigoProducto}")
    public ResponseEntity<ProductoDto> findBusq(@PathVariable(name = "codigoProducto", required = false) int nom) {
        try {
            return new ResponseEntity<>(servicio.findBusq(nom), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<ProductoDto> save(@RequestBody ProductoDto dto){
        try{
            //if(dto.getFechanacimiento().toString().is.equals("")){

            System.out.println(dto);
            return new ResponseEntity<>(servicio.saveProducto(dto),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping()
    public ResponseEntity<ProductoDto> update(@RequestBody ProductoDto dto){
        try{
            return  new ResponseEntity<>(servicio.saveProducto(dto),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id){
        try{
            String mensaje=Boolean.TRUE.equals(servicio.deleteProducto(id))?"Registro Eliminado":"Error Al Eliminar Registro";
            return  new ResponseEntity<>(mensaje,HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
