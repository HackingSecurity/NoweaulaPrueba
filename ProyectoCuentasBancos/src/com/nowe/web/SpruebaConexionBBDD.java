package com.nowe.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.nowe.persistencia.Conexion;

/**
 * Servlet implementation class SPrueba
 */
@WebServlet("/sPrueba")
public class SpruebaConexionBBDD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpruebaConexionBBDD() {
        super();
        // TODO Auto-generated constructor stub
        Conexion c = new Conexion();
        System.out.println("Esto es una prueba1");
		try {
			c.abrirConexion();
			System.out.println("Esto es una prueba");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		Conexion c = new Conexion();
		try {
			c.abrirConexion();
			System.out.println("Esto es una prueba");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		
		//Declaracion de variables
		AccesoCuentasBancarias acb;
		boolean exitoConsulta;
		Movimiento m1;
		int idCuenta;
		double precio;
	
		System.out.println("Estoy por aqui");
		
		//Asignacion de variables
		exitoConsulta = false;
		acb = new AccesoCuentasBancarias();
		idCuenta = Integer.parseInt(request.getParameter("id"));
		precio = Double.parseDouble(request.getParameter("precio"));
		m1 = new Movimiento(precio, idCuenta);
		
		
		//Abligatorio envolverlo en un try-catch
		try {
		
			exitoConsulta = acb.ingreso(m1);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(exitoConsulta) {
			System.out.println("Id cuenta: " + idCuenta);
			System.out.println("Total Ingreso: " + precio);
		}
		
		*/
		/*
		 * Aqui ya podero s jugar con nuestra variable
		 */
		
	}

}
