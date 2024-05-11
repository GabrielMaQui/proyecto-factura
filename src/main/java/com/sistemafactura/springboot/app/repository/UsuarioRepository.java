package com.sistemafactura.springboot.app.repository;

import com.sistemafactura.springboot.app.models.entity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findByUsername(String username);

    @Transactional
    @Modifying
    @Query(value = "UPDATE users SET nombre=:nombres, apellido=:apellidos, " +
            "enabled=:activo, password=:password WHERE id=:idusuario",
            nativeQuery = true)
    void actualizarUsuario(@Param("nombres") String nombres,
                           @Param("apellidos") String apellidos,
                           @Param("activo") boolean activo,
                           @Param("password") String password,
                           @Param("idusuario") Long idusuario);
}
