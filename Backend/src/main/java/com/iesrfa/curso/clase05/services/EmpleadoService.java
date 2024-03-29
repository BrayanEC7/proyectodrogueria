package com.iesrfa.curso.clase05.services;

import com.iesrfa.curso.clase05.controllers.dto.CategoriaDto;
import com.iesrfa.curso.clase05.controllers.dto.EmpleadoDto;
import com.iesrfa.curso.clase05.models.EmpleadoEntity;
import com.iesrfa.curso.clase05.services.repository.EmpleadoRepository;
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
public class EmpleadoService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    EmpleadoRepository empleadoRepository;

    public List<EmpleadoDto> getAll() {
        try {
            return empleadoRepository.findAll()
                    .stream()
                    .map(x -> modelMapper.map(x, EmpleadoDto.class))
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            return null;
        }
    }
    public List<EmpleadoDto> findBusquedaBy(String busq) {
        try {
            var datos = empleadoRepository.findBusquedaBy(busq);
            var response = this.listaBusq(datos);
            //System.out.println("DATOS DEL RESPONSE: " + response);
            return response;
        } catch (Exception ex) {
            //log.error("Error al listar Menus 2: " + ex.getMessage());
            return null;
        }
    }
    private List<EmpleadoDto> listaBusq(List<Tuple> datos) {
        List<EmpleadoDto> lista = new ArrayList<>();
        for (Tuple ele : datos) {
            EmpleadoDto dtotmp = new EmpleadoDto();
            dtotmp.setId(ele.get("ID") == null ? null : (UUID) ele.get("ID"));
            dtotmp.setNombreEmpleado(ele.get("NOMBRE") == null ? null : (String) ele.get("NOMBRE"));
            dtotmp.setCargo(ele.get("CARG") == null ? null : (String) ele.get("CARG"));
            dtotmp.setTelefono(ele.get("TELEF") == null ? null : (String) ele.get("TELEF"));
            dtotmp.setCorreo(ele.get("COR") == null ? null : (String) ele.get("COR"));
            dtotmp.setFechanacimiento(ele.get("FECHA") == null ? null : (String) ele.get("FECHA"));
            lista.add(dtotmp);
        }
        return lista;
    }
    public EmpleadoDto saveEmpleado(EmpleadoDto registrar){
        try{
            return this.modelMapper.map(
                    empleadoRepository.save(
                            this.modelMapper.map(registrar, EmpleadoEntity.class)
                    ),EmpleadoDto.class);

        }catch(Exception ex){
            return null;
        }
    }
    public Boolean deleteEmpleado(UUID idEmpleado){
        try{

            Optional<EmpleadoEntity> registro=
                    empleadoRepository.findById(idEmpleado);
            if(registro.isPresent()){
                empleadoRepository.delete(registro.get());
                return true;
            }
            return false;
        }catch(Exception ex){
            return null;

        }
    }
}
