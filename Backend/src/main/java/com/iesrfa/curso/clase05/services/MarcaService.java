package com.iesrfa.curso.clase05.services;

import com.iesrfa.curso.clase05.controllers.dto.ClienteDto;
import com.iesrfa.curso.clase05.controllers.dto.MarcaDto;
import com.iesrfa.curso.clase05.models.MarcaEntity;
import com.iesrfa.curso.clase05.services.repository.MarcaRepository;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class MarcaService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    MarcaRepository marcaRepository;

    public List<MarcaDto> getAll() {
        try {
            return marcaRepository.findAll()
                    .stream()
                    .map(x -> modelMapper.map(x, MarcaDto.class))
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            return null;
        }
    }
    public List<MarcaDto> findBusquedaBy(String busq) {
        try {
            var datos = marcaRepository.findBusquedaBy(busq);
            var response = this.listaBusq(datos);
            //System.out.println("DATOS DEL RESPONSE: " + response);
            return response;
        } catch (Exception ex) {
            //log.error("Error al listar Menus 2: " + ex.getMessage());
            return null;
        }
    }
    private List<MarcaDto> listaBusq(List<Tuple> datos) {
        List<MarcaDto> lista = new ArrayList<>();
        for (Tuple ele : datos) {
            MarcaDto dtotmp = new MarcaDto();
            dtotmp.setId(ele.get("ID") == null ? null : (UUID) ele.get("ID"));
            dtotmp.setNombreMarca(ele.get("NOMBREMARCA") == null ? null : (String) ele.get("NOMBREMARCA"));
            lista.add(dtotmp);
        }
        return lista;
    }

    public MarcaDto saveMarca(MarcaDto registrar){
        try{
            return this.modelMapper.map(
                    marcaRepository.save(
                            this.modelMapper.map(registrar, MarcaEntity.class)
                    ),MarcaDto.class);

        }catch(Exception ex){
            return null;
        }
    }
    public Boolean deleteMarca(UUID idMarca){
        try{

            Optional<MarcaEntity> registro=
                    marcaRepository.findById(idMarca);
            if(registro.isPresent()){
                marcaRepository.delete(registro.get());
                return true;
            }
            return false;
        }catch(Exception ex){
            return null;

        }
    }
}
