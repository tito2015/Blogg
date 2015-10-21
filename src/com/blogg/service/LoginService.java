package com.blogg.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.blogg.modelos.Usuario;
import com.blogg.util.Conexion;

public class LoginService {
	
	public static Usuario accesoBase(String usuario, String password){
		
		Usuario usur = null;
		
		try{
			
			Connection conexion = Conexion.getConexion();
			String sql = "select * from usuario where usu_usuario = ? and usu_password = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setString(1, usuario);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				
				usur = new Usuario();
				
				usur.setUsu_usuario(rs.getString("usu_usuario"));
				usur.setUsu_password(rs.getString("usu_password"));
			}
		} catch (Exception e){
			System.out.println("Error"+e);
		}
		
		return usur;
	}

}
