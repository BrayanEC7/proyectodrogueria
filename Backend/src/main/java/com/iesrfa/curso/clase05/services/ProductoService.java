package com.iesrfa.curso.clase05.services;

import com.iesrfa.curso.clase05.controllers.dto.ClienteDto;
import com.iesrfa.curso.clase05.controllers.dto.EmpleadoDto;
import com.iesrfa.curso.clase05.controllers.dto.ProductoDto;
import com.iesrfa.curso.clase05.models.ProductoEntity;
import com.iesrfa.curso.clase05.services.repository.ProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductoService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ProductoRepository producto2Repository;

    public List<ProductoDto> getAll() {
        try {
            return producto2Repository.findAll()
                    .stream()
                    .map(x -> modelMapper.map(x, ProductoDto.class))
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            return null;
        }
    }

    public ProductoDto findBusq(int codigoProducto) {
        try {
            var datos = producto2Repository.findByCodigoProducto(codigoProducto);
            ProductoDto response= modelMapper.map(datos,ProductoDto.class);
            //System.out.println("DATOS DEL RESPONSE: " + response);
            return response;
        } catch (Exception ex) {
            //log.error("Error al listar Menus 2: " + ex.getMessage());
            return null;
        }
    }
    public ProductoDto saveProducto(ProductoDto registrar){
        try{
            return this.modelMapper.map(
                    producto2Repository.save(
                            this.modelMapper.map(registrar, ProductoEntity.class)
                    ), ProductoDto.class);

        }catch(Exception ex){
            return null;
        }
    }
    public Boolean deleteProducto(UUID idProducto){
        try{

            Optional<ProductoEntity> registro=
                    producto2Repository.findById(idProducto);
            if(registro.isPresent()){
                producto2Repository.delete(registro.get());
                return true;
            }
            return false;
        }catch(Exception ex){
            return null;

        }
    }
}
