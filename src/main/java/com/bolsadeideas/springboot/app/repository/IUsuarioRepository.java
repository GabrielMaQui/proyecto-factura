package com.bolsadeideas.springboot.app.repository;
import com.bolsadeideas.springboot.app.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

	public Usuario findByUsername(String username);
}
