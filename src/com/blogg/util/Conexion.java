package com.blogg.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	public static Connection conexion = null;
	private static final String USUARIO = "root";
	private static final String PASSWORD = "";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String HOST = "jdbc:mysql://localhost/blog";
	
	
	private Conexion() {
	}
	
	public static Connection getConexion() {
		if(conexion == null){
			levantarConexion();
		}
		return conexion;
	}

	private static void levantarConexion() {
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(HOST, USUARIO, PASSWORD);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
