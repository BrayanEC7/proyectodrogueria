package com.iesrfa.curso.clase05.controllers;
import com.iesrfa.curso.clase05.controllers.dto.PedidoDto;
import com.iesrfa.curso.clase05.controllers.dto.ProductoDto;
import com.iesrfa.curso.clase05.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/pedido")
@CrossOrigin(origins = "*")
public class PedidoController {
    @Autowired
    PedidoService servicio;

    @GetMapping()
    public ResponseEntity<List<PedidoDto>> getAll() {
        try {
            List<PedidoDto> datos = servicio.getAll();
            return new ResponseEntity<>(datos, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("buscarPorNum/{numeroPedido}")
    public ResponseEntity<PedidoDto> findBusq(@PathVariable(name = "numeroPedido", required = false) int nom) {
        try {
            return new ResponseEntity<>(servicio.findBusq(nom), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping()
    public ResponseEntity<PedidoDto> save(@RequestBody PedidoDto dto){
        try{
            //if(dto.getFechanacimiento().toString().is.equals("")){

            System.out.println(dto);
            return new ResponseEntity<>(servicio.savePedido(dto),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping()
    public ResponseEntity<PedidoDto> update(@RequestBody PedidoDto dto){
        try{
            return  new ResponseEntity<>(servicio.savePedido(dto),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id){
        try{
            String mensaje=Boolean.TRUE.equals(servicio.deletePedido(id))?"Registro Eliminado":"Error Al Eliminar Registro";
            return  new ResponseEntity<>(mensaje,HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
