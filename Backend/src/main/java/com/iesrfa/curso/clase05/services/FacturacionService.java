package com.iesrfa.curso.clase05.services;

import com.iesrfa.curso.clase05.controllers.dto.FacturacionDto;
import com.iesrfa.curso.clase05.models.FacturacionEntity;
import com.iesrfa.curso.clase05.services.repository.FacturacionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FacturacionService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    FacturacionRepository facturacionRepository;

    public List<FacturacionDto> getAll() {
        try {
            return facturacionRepository.findAll()
                    .stream()
                    .map(x -> modelMapper.map(x, FacturacionDto.class))
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            return null;
        }
    }

    public FacturacionDto saveFacturacion(FacturacionDto registrar){
        try{
            return this.modelMapper.map(
                    facturacionRepository.save(
                            this.modelMapper.map(registrar, FacturacionEntity.class)
                    ),FacturacionDto.class);

        }catch(Exception ex){
            return null;
        }
    }
    public Boolean deleteFacturacion(UUID idFacturacion){
        try{

            Optional<FacturacionEntity> registro=
                    facturacionRepository.findById(idFacturacion);
            if(registro.isPresent()){
                facturacionRepository.delete(registro.get());
                return true;
            }
            return false;
        }catch(Exception ex){
            return null;

        }
    }
}
