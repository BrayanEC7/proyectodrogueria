package com.iesrfa.curso.clase05.services;

import com.iesrfa.curso.clase05.controllers.dto.CategoriaDto;
import com.iesrfa.curso.clase05.controllers.dto.PresentacionDto;
import com.iesrfa.curso.clase05.models.PresentacionEntity;
import com.iesrfa.curso.clase05.services.repository.PresentacionRepository;
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
public class PresentacionService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    PresentacionRepository presentacionRepository;

    public List<PresentacionDto> getAll() {
        try {
            return presentacionRepository.findAll()
                    .stream()
                    .map(x -> modelMapper.map(x, PresentacionDto.class))
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            return null;
        }
    }
    public List<PresentacionDto> findBusquedaBy(String busq) {
        try {
            var datos = presentacionRepository.findBusquedaBy(busq);
            var response = this.listaBusq(datos);
            //System.out.println("DATOS DEL RESPONSE: " + response);
            return response;
        } catch (Exception ex) {
            //log.error("Error al listar Menus 2: " + ex.getMessage());
            return null;
        }
    }
    private List<PresentacionDto> listaBusq(List<Tuple> datos) {
        List<PresentacionDto> lista = new ArrayList<>();
        for (Tuple ele : datos) {
            PresentacionDto dtotmp = new PresentacionDto();
            dtotmp.setId(ele.get("ID") == null ? null : (UUID) ele.get("ID"));
            dtotmp.setNombrePresentacion(ele.get("NOMBRE") == null ? null : (String) ele.get("NOMBRE"));
            lista.add(dtotmp);
        }
        return lista;
    }
    public PresentacionDto savePresentacion(PresentacionDto registrar){
        try{
            return this.modelMapper.map(
                    presentacionRepository.save(
                            this.modelMapper.map(registrar, PresentacionEntity.class)
                    ),PresentacionDto.class);

        }catch(Exception ex){
            return null;
        }
    }
    public Boolean deletePresentacion(UUID idPresentacion){
        try{

            Optional<PresentacionEntity> registro=
                    presentacionRepository.findById(idPresentacion);
            if(registro.isPresent()){
                presentacionRepository.delete(registro.get());
                return true;
            }
            return false;
        }catch(Exception ex){
            return null;

        }
    }
}
