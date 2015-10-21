package com.blogg.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.blogg.modelos.Entrada;
import com.blogg.util.Conexion;

public class EntradaService {
	
	public static List<Entrada> listarEntradas(){
		
		//Listado con las entradas que se encuentran en la bd
		ArrayList<Entrada> listarEntradas = new ArrayList<Entrada>();
		//Objeto para preparar la cunsulta a la bd
		PreparedStatement pstm = null;
		//Objeto que nos da los registros
		ResultSet resultado = null;
		
		try {
			
			final String sql = "Select * from entrada";
			
			//Obtengo la conexion a la bd
			Connection conexion = Conexion.getConexion();
			
			//Preparar la consulta a la bd
			pstm = conexion.prepareStatement(sql);
			
			//Obtenemos los resultados
			resultado = pstm.executeQuery();
			
			//Recorremos los registros y los guardamos
			while(resultado.next()){
				
				Entrada entrada = new Entrada();
				
				entrada.setId(resultado.getInt("id"));
				entrada.settitulo(resultado.getString("ent_titulo"));
				entrada.setfecha(resultado.getDate("ent_fecha"));
				entrada.setcontenido(resultado.getString("ent_contenido"));
				entrada.setEnt_usu_usuario(resultado.getString("ent_usu_usuario"));
				
				listarEntradas.add(entrada);
			}
			
		} catch (Exception e) {
			throw new RuntimeException("Error listando las entradas"+e);
		}
		
		return listarEntradas;
	}
	
	public static void main(String[] args){
		
		List<Entrada> entradas = EntradaService.listarEntradas();
		for (Entrada entrada : entradas) {
			System.out.println(entrada);
		}
	}
	
   public static void eliminar(String id){
	
		PreparedStatement pstm = null;

		try {
			
			final String sql = "delete from entrada where id=?";
			
			//Obtengo la conexion a la bd
			Connection conexion = Conexion.getConexion();
			
			//Preparar la consulta a la bd
			pstm = conexion.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.executeUpdate();
		} catch(Exception e){
			
		}
   }

}
