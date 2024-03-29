package com.iesrfa.curso.clase05.services.repository;
import com.iesrfa.curso.clase05.models.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;
import java.util.UUID;

@Repository
public interface UsuariosRepository extends JpaRepository<UsuariosEntity, UUID>{
    //List<UsuariosEntity> findByPersonaIdpersona(UUID idpersona);

    @Query("SELECT u FROM UsuariosEntity u WHERE u.user=?1 AND u.password=?2")
    UsuariosEntity login(String usuario, String clave);
    UsuariosEntity findByUser(String usuario);
    UsuariosEntity findByUserAndPassword(String user, String clave);

    @Query("SELECT id AS ID, user AS USUARIO, password AS CLAVE, nombre AS NOMBRE  " +
            "FROM UsuariosEntity WHERE lower(usuario) LIKE ?1%")
    List<Tuple> findBusquedaBy(String usuario);
}