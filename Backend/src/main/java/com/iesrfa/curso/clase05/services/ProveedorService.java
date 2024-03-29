package com.iesrfa.curso.clase05.services;

import com.iesrfa.curso.clase05.controllers.dto.ProveedorDto;
import com.iesrfa.curso.clase05.models.ProveedorEntity;
import com.iesrfa.curso.clase05.services.repository.ProveedorRepository;
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
public class ProveedorService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ProveedorRepository proveedorRepository;

    public List<ProveedorDto> getAll() {
        try {
            return proveedorRepository.findAll()
                    .stream()
                    .map(x -> modelMapper.map(x, ProveedorDto.class))
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            return null;
        }
    }
    public List<ProveedorDto> findBusquedaBy(String busq) {
        try {
            var datos = proveedorRepository.findBusquedaBy(busq);
            var response = this.listaBusq(datos);
            //System.out.println("DATOS DEL RESPONSE: " + response);
            return response;
        } catch (Exception ex) {
            //log.error("Error al listar Menus 2: " + ex.getMessage());
            return null;
        }
    }
    private List<ProveedorDto> listaBusq(List<Tuple> datos) {
        List<ProveedorDto> lista = new ArrayList<>();
        for (Tuple ele : datos) {
            ProveedorDto dtotmp = new ProveedorDto();
            dtotmp.setId(ele.get("ID") == null ? null : (UUID) ele.get("ID"));
            dtotmp.setNombreProveedor(ele.get("NOMBRE") == null ? null : (String) ele.get("NOMBRE"));
            dtotmp.setRuc(ele.get("RUC") == null ? null : (String) ele.get("RUC"));
            dtotmp.setTelefono(ele.get("TELEFONO") == null ? null : (String) ele.get("TELEFONO"));
            lista.add(dtotmp);
        }
        return lista;
    }
    public ProveedorDto saveProveedor(ProveedorDto registrar){
        try{
            return this.modelMapper.map(
                    proveedorRepository.save(
                            this.modelMapper.map(registrar, ProveedorEntity.class)
                    ),ProveedorDto.class);

        }catch(Exception ex){
            return null;
        }
    }
    public Boolean deleteProveedor(UUID idProveedor){
        try{

            Optional<ProveedorEntity> registro=
                    proveedorRepository.findById(idProveedor);
            if(registro.isPresent()){
                proveedorRepository.delete(registro.get());
                return true;
            }
            return false;
        }catch(Exception ex){
            return null;

        }
    }
}
