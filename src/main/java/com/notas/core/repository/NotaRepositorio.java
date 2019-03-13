package com.notas.core.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notas.core.entity.Nota;

import java.util.List;

@Repository("repositorio")
public interface NotaRepositorio extends JpaRepository<Nota, Serializable>{

	public abstract Nota findByNombre(String nombre);
	
	public abstract List<Nota> findByTitulo(String titulo);
	
	public abstract Nota findByNombreAndTitulo(String nombre, String titulo);
	
	
	public abstract Nota findByNombreAndId(String nombre, long id);


}
