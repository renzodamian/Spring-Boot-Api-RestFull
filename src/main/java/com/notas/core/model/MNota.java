package com.notas.core.model;

import com.notas.core.entity.Nota;

public class MNota {
		
		public MNota() {
			
		}
		//Constructor que pida una entidad Nota
		public MNota(Nota nota) {
			this.id = getId();
			this.nombre = getNombre();
			this.titulo = getTitulo();
			this.contenido = getContenido();
			
		}
		public MNota(long id, String nombre, String titulo, String contenido) {
			this.id = id;
			this.nombre = nombre;
			this.titulo = titulo;
			this.contenido = contenido;
		}
		private long id;
		private String nombre;
		private String titulo;
		private String contenido;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getTitulo() {
			return titulo;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public String getContenido() {
			return contenido;
		}
		public void setContenido(String contenido) {
			this.contenido = contenido;
		}
	}