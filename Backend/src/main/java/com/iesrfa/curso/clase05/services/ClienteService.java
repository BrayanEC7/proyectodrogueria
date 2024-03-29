package com.iesrfa.curso.clase05.services;

import com.iesrfa.curso.clase05.controllers.dto.ClienteDto;
import com.iesrfa.curso.clase05.models.ClienteEntity;
import com.iesrfa.curso.clase05.services.repository.ClienteRepository;
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
public class ClienteService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ClienteRepository clienteRepository;

    public List<ClienteDto> getAll() {
        try {
            return clienteRepository.findAll()
                    .stream()
                    .map(x -> modelMapper.map(x, ClienteDto.class))
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            return null;
        }
    }

    public List<ClienteDto> findBusquedaBy(String busq) {
        try {
            var datos = clienteRepository.findBusquedaBy(busq);
            var response = this.listaBusq(datos);
            return response;
        } catch (Exception ex) {
            return null;
        }
    }
    private List<ClienteDto> listaBusq(List<Tuple> datos) {
        List<ClienteDto> lista = new ArrayList<>();
        for (Tuple ele : datos) {
            ClienteDto dtotmp = new ClienteDto();
            dtotmp.setId(ele.get("ID") == null ? null : (UUID) ele.get("ID"));
            dtotmp.setTipoDocumento(ele.get("TIPO") == null ? null : (String) ele.get("TIPO"));
            dtotmp.setNumDocCliente(ele.get("NUM") == null ? null : (String) ele.get("NUM"));
            dtotmp.setNombreCliente(ele.get("NOMBRE") == null ? null : (String) ele.get("NOMBRE"));
            dtotmp.setCelularCliente(ele.get("CELULAR") == null ? null : (String) ele.get("CELULAR"));
            dtotmp.setCorreoCliente(ele.get("CORREO") == null ? null : (String) ele.get("CORREO"));
            dtotmp.setDireccionCliente(ele.get("DIRECCION") == null ? null : (String) ele.get("DIRECCION"));


            lista.add(dtotmp);
        }
        return lista;
    }

    public ClienteDto findBusq(String numDocCliente) {
        try {
            var datos = clienteRepository.findByNumDocCliente(numDocCliente);
            ClienteDto response= modelMapper.map(datos,ClienteDto.class);
            //System.out.println("DATOS DEL RESPONSE: " + response);
            return response;
        } catch (Exception ex) {
            //log.error("Error al listar Menus 2: " + ex.getMessage());
            return null;
        }
    }
    private List<ClienteDto> listaNombresClientes(List<Tuple> datos) {
        List<ClienteDto> lista2 = new ArrayList<>();
        for (Tuple ele : datos) {
            ClienteDto dtotmp = new ClienteDto();
            dtotmp.setId(ele.get("ID") == null ? null : (UUID) ele.get("ID"));
            dtotmp.setNombreCliente(ele.get("NOMBRE") == null ? null : (String) ele.get("NOMBRE"));
            lista2.add(dtotmp);
        }
        return lista2;
    }
    public ClienteDto getOrden() {
        try {
            /*return this.modelMapper.map(
                    repository.findByOrden(nombre,apellidos),
                    MenuDto.class);*/
            return null;
        } catch (Exception ex) {
            return null;
        }
    }

    public ClienteDto saveCliente(ClienteDto registrar) {
        try {
            return this.modelMapper.map(
                    clienteRepository.save(
                            this.modelMapper.map(registrar, ClienteEntity.class)
                    ), ClienteDto.class);

        } catch (Exception ex) {
            return null;
        }
    }

    public Boolean deleteCliente(UUID numDocCliente) {
        try {

            Optional<ClienteEntity> registro =
                    clienteRepository.findById(numDocCliente);
            if (registro.isPresent()) {
                clienteRepository.delete(registro.get());
                return true;
            }
            return false;
        } catch (Exception ex) {
            return null;

        }
    }
}
