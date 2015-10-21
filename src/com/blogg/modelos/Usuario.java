package com.blogg.modelos;

public class Usuario {
	
	private int usu_id;
	private String usu_usuario;
	private String usu_password;
	
	
	
	public Usuario() {
	}
	
	public Usuario(int id, String usu_usuario, String usu_password) {
		super();
		this.usu_id = id;
		this.usu_usuario = usu_usuario;
		this.usu_password = usu_password;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + usu_id + ", usu_usuario=" + usu_usuario
				+ ", usu_password=" + usu_password + "]";
	}

	public int getId() {
		return usu_id;
	}
	public void setId(int id) {
		this.usu_id = id;
	}
	public String getUsu_usuario() {
		return usu_usuario;
	}
	public void setUsu_usuario(String usu_usuario) {
		this.usu_usuario = usu_usuario;
	}
	public String getUsu_password() {
		return usu_password;
	}
	public void setUsu_password(String usu_password) {
		this.usu_password = usu_password;
	}
	
	
}
