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
import com.nowe.modelo.Movimiento;
import com.nowe.persistencia.AccesoCuentasBancarias;

/**
 * Servlet implementation class SingresoRetiro
 */
@WebServlet("/singresoretiro")
public class SingresoRetiro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SingresoRetiro() {
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
		String opt;
		AccesoCuentasBancarias acb;
		Movimiento m;
		
		//2. Asignacion de valores
		opt = request.getParameter("opcion");
		acb = new AccesoCuentasBancarias(); 
		m = new Movimiento(Double.parseDouble((String) request.getParameter("idcdt"))
				, Integer.parseInt((String) request.getParameter("idcuenta")));
		
		//2. pruebas
		System.out.println(request.getParameter("opcion"));
		System.out.println(request.getParameter("idcuenta"));
		System.out.println(request.getParameter("idcdt"));
		
		
		//3. Comprobamos el tipo de operacion que queremos hacer
		if(opt.equalsIgnoreCase("ingreso")) {			
			try {
				respuesta = acb.ingreso(m);
				if(respuesta) {
					request.setAttribute("movimientos_rq", "Exito retirada");
				}else {
					request.setAttribute("movimientos_rq", "...");
				}
				RequestDispatcher rd = request.getRequestDispatcher("movimientos.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(opt.equalsIgnoreCase("retiro")) {
		
			try {
				respuesta = acb.retiro(m);
				if(respuesta) {
					request.setAttribute("movimientos_rq", "Exito retirada");
				}else {
					request.setAttribute("movimientos_rq", "...");
				}
				request.setAttribute("movimientos_rq", "Exito retirada");
				RequestDispatcher rd = request.getRequestDispatcher("movimientos.jsp");
				rd.forward(request, response);
			}catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
