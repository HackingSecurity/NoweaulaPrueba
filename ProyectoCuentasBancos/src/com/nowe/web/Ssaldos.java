package com.nowe.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nowe.persistencia.AccesoCuentasBancarias;


/**
 * Servlet implementation class SverSaldos
 */
@WebServlet("/ssaldos")
public class Ssaldos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ssaldos() {
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
		double saldo;
		String tSaldo;
		AccesoCuentasBancarias acb;
		
		//2. Asignacion de valores
		tSaldo = request.getParameter("tsaldo");
		acb = new AccesoCuentasBancarias();
		
		//2. pruebas
		System.out.println(request.getParameter("tsaldo"));
		System.out.println(request.getParameter("dato"));
		
		//3. Comprobamos que tipo de cuenta es
		if(tSaldo.equalsIgnoreCase("sc")) {
			//Necesitamos dni
			try {
				saldo = acb.consultaSaldoTotal(request.getParameter("dato"));
				request.setAttribute("jspSaldo_rq", saldo);
				RequestDispatcher rd = request.getRequestDispatcher("versaldo.jsp");
				rd.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(tSaldo.equalsIgnoreCase("scdt")) {
			//Necesitamos un id
			try {
				saldo = acb.consultaSaldoCDT(Integer.parseInt(request.getParameter("dato")));
				request.setAttribute("jspSaldo_rq", saldo);
				RequestDispatcher rd = request.getRequestDispatcher("versaldo.jsp");
				rd.forward(request, response);
			}catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(tSaldo.equalsIgnoreCase("scl")) {
			//Necesitamos un id
			try {
				saldo = acb.consultaSaldo(Integer.parseInt(request.getParameter("dato")));
				request.setAttribute("jspSaldo_rq", saldo);
				RequestDispatcher rd = request.getRequestDispatcher("versaldo.jsp");
				rd.forward(request, response);
			}catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
