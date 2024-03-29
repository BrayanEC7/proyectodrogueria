package com.iesrfa.curso.clase05.services;

import com.iesrfa.curso.clase05.controllers.dto.CategoriaDto;
import com.iesrfa.curso.clase05.controllers.dto.UsuarioDto;
import com.iesrfa.curso.clase05.controllers.dto.UsuarioLoginResponse;
import com.iesrfa.curso.clase05.models.UsuariosEntity;
import com.iesrfa.curso.clase05.services.repository.UsuariosRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UsuarioService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UsuariosRepository usuariosRepository;

    public List<UsuarioDto> getAll(){
        try{
            return usuariosRepository.findAll()
                    .stream()
                    .map(x->modelMapper.map(x,UsuarioDto.class))
                    .collect(Collectors.toList());
        }catch(Exception ex){
           return null;
        }
    }
    public List<UsuarioDto> findBusquedaBy(String busq) {
        try {
            var datos = usuariosRepository.findBusquedaBy(busq);
            var response = this.listaBusq(datos);
            //System.out.println("DATOS DEL RESPONSE: " + response);
            return response;
        } catch (Exception ex) {
            //log.error("Error al listar Menus 2: " + ex.getMessage());
            return null;
        }
    }
    private List<UsuarioDto> listaBusq(List<Tuple> datos) {
        List<UsuarioDto> lista = new ArrayList<>();
        for (Tuple ele : datos) {
            UsuarioDto dtotmp = new UsuarioDto();
            dtotmp.setId(ele.get("ID") == null ? null : (UUID) ele.get("ID"));
            dtotmp.setUser(ele.get("USUARIO") == null ? null : (String) ele.get("USUARIO"));
            dtotmp.setPassword(ele.get("CLAVE") == null ? null : (String) ele.get("CLAVE"));
            dtotmp.setNombre(ele.get("NOMBRE") == null ? null : (String) ele.get("NOMBRE"));
            lista.add(dtotmp);
        }
        return lista;
    }
    public List<UsuarioDto> getUsuario(UUID idPersona){
        try{
            /*return usuariosRepository.findByPersonaIdpersona(idPersona)
                    .stream()
                    .map(x->modelMapper.map(x,UsuarioDto.class))
                    .collect(Collectors.toList());*/
            return null;
        }catch(Exception ex){
            return null;
        }
    }

    public UsuarioLoginResponse login(String user, String clave){
        UsuarioLoginResponse response= new UsuarioLoginResponse();
        response.setCodigo(400);
        try{
            UsuariosEntity usuariouser=usuariosRepository.findByUser(user);
            if(usuariouser==null){
                response.setMensaje("Usuario no Existe");
                response.setToken("");
                return response;
            }
            System.out.println(usuariouser);
            if(!usuariouser.getPassword().equals(clave)){
                response.setMensaje("Usuario y clave incorrecto");
                return response;
            }
            String datos="id="+usuariouser.getId()+"!=!";
            datos+="usuario="+usuariouser.getUser()+"!=!";
            datos+="password="+usuariouser.getPassword()+"!=!";
            datos+="nombre="+usuariouser.getNombre()+"!=!";
            datos+="fechayhora="+ LocalDateTime.now();
            Base64 base64 = new Base64();
            String token= new String(base64.encode(datos.getBytes()));
            response.setCodigo(200);
            response.setMensaje("Inicio de Sesión Satisfactorio");
            response.setToken(token);
            return response;
        }catch(Exception ex){
            log.error("error al loguearse log",ex.getMessage());
            response.setMensaje("error al loguearse  -> "+ ex.getCause());
            response.setToken("");
            return response;
        }
    }

    public String findByUserAndPassword(String user, String clave){
        try{
            UsuariosEntity usuariosEntity=usuariosRepository.findByUserAndPassword(user,clave);
            if(usuariosEntity.equals(null)) return "";
            String datos="id="+usuariosEntity.getId()+"!=!";
            datos+="usuario="+usuariosEntity.getUser()+"!=!";
            datos+="password="+usuariosEntity.getPassword()+"!=!";
            datos+="nombre="+usuariosEntity.getNombre()+"!=!";
            datos+="fechayhora="+ LocalDateTime.now();
            Base64 base64 = new Base64();
            return new String(base64.encode(datos.getBytes()));
        }catch(Exception ex){
            log.error("error al loguearse",ex.getCause());
            return null;
        }
    }

    public UsuarioDto saveUsuario(UsuarioDto user){
        try{
            return  this.modelMapper.map(
                    usuariosRepository.save(
                    this.modelMapper.map(user,UsuariosEntity.class)
            ),UsuarioDto.class);
        }catch(Exception ex){
            return null;
        }
    }
    public Boolean deleteUsuario(UUID idUsuario){
        try{
            Optional<UsuariosEntity> user=
                    usuariosRepository.findById(idUsuario);
            if(user.isPresent()){
                usuariosRepository.delete(user.get());
                return true;
            }
            return false;
        }catch(Exception ex){
            return false;
        }
    }


}
