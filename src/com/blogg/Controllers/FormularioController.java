package com.blogg.Controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blogg.modelos.Entrada;
import com.blogg.modelos.Usuario;
import com.blogg.service.EntradaService;
import com.blogg.service.FormularioService;

/**
 * Servlet implementation class FormularioController
 */
@WebServlet("/FormularioController")
public class FormularioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Vamos a usar para eliminar las entradas
		
		String operacion = request.getParameter("operacion");
		if(operacion!=null && operacion.equals("listar")){
			
			List<Entrada> entradas = EntradaService.listarEntradas();
			request.setAttribute("entradaList", entradas);
			request.getRequestDispatcher("entrada.jsp").forward(request, response);
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
        String operacion = request.getParameter("operacion");
		
        if(operacion!=null && operacion.equals("eliminar")){
        		
        	String id = request.getParameter("id");
        	
        	EntradaService.eliminar(id);
        	
        }

		String titulo = request.getParameter("titulo");
		String contenido = request.getParameter("contenido");
		String usuario = request.getParameter("");

		if (isDatosCorrectos(titulo, contenido)) {

			Entrada entrada = new Entrada();

			entrada.settitulo(titulo);
			entrada.setcontenido(contenido);
			entrada.setfecha(new Date());
			Usuario usur = (Usuario)request.getSession().getAttribute("Usuario");
			entrada.setEnt_usu_usuario(usur.getUsu_usuario());
			
			FormularioService.guardarEntrada(entrada);
			
			List<Entrada> entradas = EntradaService.listarEntradas();
			request.setAttribute("entradaList", entradas);
			request.getRequestDispatcher("entrada.jsp").forward(request, response);
		}
	}

	private boolean isDatosCorrectos(String titulo, String contenido) {

		return (titulo != null && contenido != null);
	}

}
