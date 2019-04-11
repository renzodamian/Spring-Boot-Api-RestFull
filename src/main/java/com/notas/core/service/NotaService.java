package com.notas.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.notas.core.converter.Convertidor;
import com.notas.core.entity.Nota;
import com.notas.core.model.MNota;
import com.notas.core.repository.NotaRepositorio;

@Service("servicio")
public class NotaService {
	//Inyectar un Bin
	@Autowired
	//Como se llama el bin
	@Qualifier("repositorio")
	private NotaRepositorio repositorio;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;
	
	
	public boolean crear(Nota nota) {
		try {
			
			repositorio.save(nota);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean actualizar(Nota nota) {
		try {
			//De ves verificar si el id es null o cero si no esta el registro debe crearlo
			repositorio.save(nota);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean borrar(String nombre, long id) {
		try {
			
			Nota nota = repositorio.findByNombreAndId(nombre, id);
			repositorio.delete(nota);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	
	public List<MNota>obtener(){
		return convertidor.convertirLista(repositorio.findAll());
	}
	
	
	public MNota obtenerPorNombreTitulo(String nombre, String titulo) {
		return new MNota(repositorio.findByNombreAndTitulo(nombre, titulo));
	}
	
	public List<MNota>obtenerTitulo(String titulo){
		return convertidor.convertirLista(repositorio.findByTitulo(titulo));
	}
	
	
	public MNota obtenerPorNombre(String nombre) {
		return new MNota(repositorio.findByNombre(nombre));
	}
}
