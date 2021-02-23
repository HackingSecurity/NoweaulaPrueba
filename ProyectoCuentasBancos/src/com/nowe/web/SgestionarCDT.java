package com.nowe.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nowe.modelo.CDT;
import com.nowe.persistencia.AccesoCuentasBancarias;

/**
 * Servlet implementation class SgestionarCDT
 */
@WebServlet("/sgestionarcdt")
public class SgestionarCDT extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SgestionarCDT() {
        super();
        // TODO Auto-generated constructor stub
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
	
		//1.Declaracion de variables
		boolean respuesta;
		String ocdt;
		AccesoCuentasBancarias acb;
		CDT inversion;
		
		//2. Asignacion de valores
		ocdt = request.getParameter("opcioncdt");
		acb = new AccesoCuentasBancarias(); 
		
		//2. pruebas
		System.out.println(ocdt);
		System.out.println(request.getParameter("opcioncdt"));
		System.out.println(request.getParameter("idcuenta"));
		System.out.println(request.getParameter("interes"));
		System.out.println(request.getParameter("monto"));
		System.out.println(request.getParameter("idcdt"));
		
		
		//3. Comprobamos el tipo de operacion que queremos hacer
		if(ocdt.equalsIgnoreCase("crcdt")) {
			//Necesitamos crear la instancia de Inversion con sus campos correspondientes.
			inversion = new CDT(Integer.parseInt(request.getParameter("idcuenta"))
					, Double.parseDouble(request.getParameter("interes"))
					, Double.parseDouble(request.getParameter("monto"))
					);
					
			try {
				respuesta = acb.crearInversion(inversion);
				if(respuesta) {
					request.setAttribute("ctd_rq", "Creada inversion");
				}else {
					request.setAttribute("ctd_rq", "...");
				}
				RequestDispatcher rd = request.getRequestDispatcher("gestionarCDT.jsp");
				rd.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(ocdt.equalsIgnoreCase("ccdt")) {
		
			try {
				respuesta = acb.cerrarInversion(Integer.parseInt(request.getParameter("idcdt")));
				if(respuesta) {
					request.setAttribute("ctd_rq", "Exito al cerrar");
				}else {
					request.setAttribute("ctd_rq", "...");
				}
				RequestDispatcher rd = request.getRequestDispatcher("gestionarCDT.jsp");
				rd.forward(request, response);
			}catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
