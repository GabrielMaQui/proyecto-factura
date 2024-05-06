package com.bolsadeideas.springboot.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bolsadeideas.springboot.app.models.entity.Producto;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {

	@Query("select p from Producto p where p.nombre like %?1%")
	public List<Producto> findByNombre(String term);

	public List<Producto> findByNombreLikeIgnoreCase(String term);

	@Modifying
	@Query(value = "UPDATE productos SET stock = stock - :cantidad WHERE codigo = :id_producto", nativeQuery = true)
	public Integer disminuirStock(@Param("id_producto") Integer id_producto, @Param("cantidad") Integer cantidad);

}