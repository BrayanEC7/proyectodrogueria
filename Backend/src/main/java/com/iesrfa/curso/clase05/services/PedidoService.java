package com.iesrfa.curso.clase05.services;

import com.iesrfa.curso.clase05.controllers.dto.PedidoDto;
import com.iesrfa.curso.clase05.controllers.dto.ProductoDto;
import com.iesrfa.curso.clase05.models.PedidoEntity;
import com.iesrfa.curso.clase05.services.repository.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PedidoService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    PedidoRepository pedidoRepository;

    public List<PedidoDto> getAll() {
        try {
            return pedidoRepository.findAll()
                    .stream()
                    .map(x -> modelMapper.map(x, PedidoDto.class))
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            return null;
        }
    }
    public PedidoDto findBusq(int numeroPedido) {
        try {
            var datos = pedidoRepository.findByNumeroPedido(numeroPedido);
            PedidoDto response= modelMapper.map(datos,PedidoDto.class);
            //System.out.println("DATOS DEL RESPONSE: " + response);
            return response;
        } catch (Exception ex) {
            //log.error("Error al listar Menus 2: " + ex.getMessage());
            return null;
        }
    }
    public PedidoDto savePedido(PedidoDto registrar){
        try{
            return this.modelMapper.map(
                    pedidoRepository.save(
                            this.modelMapper.map(registrar, PedidoEntity.class)
                    ),PedidoDto.class);

        }catch(Exception ex){
            return null;
        }
    }
    public Boolean deletePedido(UUID idPedido){
        try{

            Optional<PedidoEntity> registro=
                    pedidoRepository.findById(idPedido);
            if(registro.isPresent()){
                pedidoRepository.delete(registro.get());
                return true;
            }
            return false;
        }catch(Exception ex){
            return null;

        }
    }
}
