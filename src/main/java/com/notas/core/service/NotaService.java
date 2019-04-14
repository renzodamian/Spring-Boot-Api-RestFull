package com.notas.core.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
	//Log  son los mensajes que lanza spring cuando esta corriendo nuestra App
	private static final Log logger=LogFactory.getLog(NotaService.class);
	
	public boolean crear(Nota nota) {
		logger.info("CREANDO NOTA");
		
		try {
			
			repositorio.save(nota);
			logger.info("NOTA CREADA");
			return true;
		}catch(Exception e) {
			logger.error("Hubo ERROR");
			return false;
		}
	}
	
	public boolean actualizar(Nota nota) {
		logger.info("ACTUALIZANDO NOTA");
		try {
			//De ves verificar si el id es null o cero si no esta el registro debe crearlo
			repositorio.save(nota);
			logger.info("NOTA ACTUZALIDA");
			return true;
			
		}catch(Exception e) {
			logger.error("Hubo ERROR");
			return false;
		}
	}
	
	public boolean borrar(String nombre, long id) {
		logger.warn("BORRANDO NOTA");
		try {
			
			Nota nota = repositorio.findByNombreAndId(nombre, id);
			repositorio.delete(nota);
			logger.info("NOTA BORRADA");
			return true;
		}catch(Exception e) {
			logger.error("Hubo ERROR");
			return false;
		}
	}

	
	public List<MNota>obtener(){
		logger.info("OBTENIENDO TODOS LOS ELEMENTOS");
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
