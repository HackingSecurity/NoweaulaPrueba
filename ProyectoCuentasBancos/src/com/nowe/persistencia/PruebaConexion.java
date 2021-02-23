package com.nowe.persistencia;

import java.sql.SQLException;

public class PruebaConexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Conexion c = new Conexion();
		
		try {
			c.abrirConexion();
			System.out.println("Se abrio la conexion");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
