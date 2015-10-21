package com.blogg.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.blogg.modelos.Entrada;
import com.blogg.modelos.Usuario;
import com.blogg.service.EntradaService;
import com.blogg.service.LoginService;

/**
 * Servlet implementation class PruebaServlet
 */
@WebServlet("/PruebaServlet")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request,
		 *      HttpServletResponse response)
		 */
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");

		if (isdatosvalidos(usuario, password)) {

			if (validarUsuarios(usuario, password)) {

				Usuario usur = new Usuario();
				
				usur.setUsu_usuario(usuario);
				usur.setUsu_password(password);
				
				request.getSession().setAttribute("Usuario", usur);
				request.setAttribute("Usuario",usur);
				
				List<Entrada> entradas = EntradaService.listarEntradas();
				request.setAttribute("entradaList", entradas);
				request.getRequestDispatcher("entrada.jsp").forward(request,response);
			} else {
				String mensaje = "Los datos son Incorrectos";
				request.setAttribute("datosVacios", mensaje);
				request.getRequestDispatcher("login.jsp").forward(request,response);
			}

		} else {

			String mensaje = "Los datos no pueden estar vacios";
			request.setAttribute("datosVacios", mensaje);
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		}

	}

	private boolean validarUsuarios(String usuario, String password) {
		
		Usuario usur = LoginService.accesoBase(usuario, password);
		
		System.out.println(usur);
		
		if ((usur!=null)){
			
			return true;
		}
		
		return false;
	}

	private boolean isdatosvalidos(String usuario, String password) {

		if (usuario != null && password != null && !password.isEmpty()
				&& !usuario.isEmpty()) {
			return true;
		}
		return false;
	}

}
