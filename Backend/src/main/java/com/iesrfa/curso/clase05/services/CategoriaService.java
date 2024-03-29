package com.iesrfa.curso.clase05.services;

import com.iesrfa.curso.clase05.controllers.dto.CategoriaDto;
import com.iesrfa.curso.clase05.models.CategoriaEntity;
import com.iesrfa.curso.clase05.services.repository.CategoriaRepository;
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
public class CategoriaService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CategoriaRepository categoriaRepository;

    public List<CategoriaDto> getAll() {
        try {
            return categoriaRepository.findAll()
                    .stream()
                    .map(x -> modelMapper.map(x, CategoriaDto.class))
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            return null;
        }
    }
    public List<CategoriaDto> findBusquedaBy(String busq) {
        try {
            var datos = categoriaRepository.findBusquedaBy(busq);
            var response = this.listaBusq(datos);
            //System.out.println("DATOS DEL RESPONSE: " + response);
            return response;
        } catch (Exception ex) {
            //log.error("Error al listar Menus 2: " + ex.getMessage());
            return null;
        }
    }
    private List<CategoriaDto> listaBusq(List<Tuple> datos) {
        List<CategoriaDto> lista = new ArrayList<>();
        for (Tuple ele : datos) {
            CategoriaDto dtotmp = new CategoriaDto();
            dtotmp.setId(ele.get("ID") == null ? null : (UUID) ele.get("ID"));
            dtotmp.setNombreCategoria(ele.get("NOMBRE") == null ? null : (String) ele.get("NOMBRE"));
            dtotmp.setDescripcion(ele.get("DESCRIP") == null ? null : (String) ele.get("DESCRIP"));
            lista.add(dtotmp);
        }
        return lista;
    }
    public CategoriaDto saveCategoria(CategoriaDto registrar){
        try{
            return this.modelMapper.map(
                    categoriaRepository.save(
                            this.modelMapper.map(registrar, CategoriaEntity.class)
                    ),CategoriaDto.class);

        }catch(Exception ex){
            return null;
        }
    }
    public Boolean deleteCategoria(UUID idCategoria){
        try{

            Optional<CategoriaEntity> registro=
                    categoriaRepository.findById(idCategoria);
            if(registro.isPresent()){
                categoriaRepository.delete(registro.get());
                return true;
            }
            return false;
        }catch(Exception ex){
            return null;

        }
    }
}
