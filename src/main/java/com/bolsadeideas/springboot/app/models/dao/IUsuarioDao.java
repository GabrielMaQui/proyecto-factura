package com.bolsadeideas.springboot.app.models.dao;
import com.bolsadeideas.springboot.app.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioDao extends JpaRepository<Usuario, Long> {

	public Usuario findByUsername(String username);
}
