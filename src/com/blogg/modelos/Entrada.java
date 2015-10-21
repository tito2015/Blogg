package com.blogg.modelos;

import java.util.Date;

public class Entrada {
	
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String titulo;
	private String contenido;
	private Date fecha;
	private String ent_usu_usuario;
	
	
	
	@Override
	public String toString() {
		return "Entrada [id="+ id +", titulo=" + titulo + ", contenido=" + contenido
				+ ", fecha=" + fecha + ", ent_usu_usuario=" + ent_usu_usuario
				+ "]";
	}
	public String getEnt_usu_usuario() {
		return ent_usu_usuario;
	}
	public void setEnt_usu_usuario(String ent_usu_usuario) {
		this.ent_usu_usuario = ent_usu_usuario;
	}
	public String gettitulo() {
		return titulo;
	}
	public void settitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getcontenido() {
		return contenido;
	}
	public void setcontenido(String contenido) {
		this.contenido = contenido;
	}
	public Date getfecha() {
		return fecha;
	}
	public void setfecha(Date fecha) {
		this.fecha = fecha;
	}
	
	

}
