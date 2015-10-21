package com.blogg.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.blogg.modelos.Entrada;
import com.blogg.modelos.Usuario;
import com.blogg.util.Conexion;

public class FormularioService {
	
	public static void guardarEntrada(Entrada entrada){
		
try{
			
			Connection conexion = Conexion.getConexion();
			String sql = "INSERT INTO entrada VALUES (?,?,?,?,?)";
			PreparedStatement ps = conexion.prepareStatement(sql);
			
			ps.setString(1, null);
			ps.setString(2, entrada.gettitulo());
			ps.setDate(3, getCurrentDate());
			ps.setString(4, entrada.getcontenido());
			ps.setString(5, entrada.getEnt_usu_usuario());
			int registros = ps.executeUpdate();
		} catch (Exception e){
			System.out.println("Error"+e);
		}
	}
	
	private static java.sql.Date getCurrentDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}
}
