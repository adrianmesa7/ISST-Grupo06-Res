package es.upm.dit.isst.resumen.servlets;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;

import es.upm.dit.isst.resumen.model.RESUMEN;

/**
 * Servlet implementation class FormLoginServlet
 */
@WebServlet("/FormLoginServlet")
public class FormLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String ADMIN_EMAIL = "root";
    private final String ADMIN_PASSWORD = "root";
       
 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Client client = ClientBuilder.newClient(new ClientConfig());
        
        
        // autenticacion para el admin con root root
        if( ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password) ) {        
             req.getSession().setAttribute("admin", true);
             List<RESUMEN> resumenes  = client.target(URLHelper.getURL())
                    .request().accept(MediaType.APPLICATION_JSON)
                    .get(new GenericType<List<RESUMEN>>() {});
             resumenes.sort(Comparator.comparing(RESUMEN::getPuntuacion).reversed());
             req.setAttribute("resumenes", resumenes);
             getServletContext().getRequestDispatcher("/Admin.jsp").forward(req,resp);
             return;
        }
       
        
        // autenticacion escritor
        if ( email.contains("@escritor.es")) {
        	/*
             req.getSession().setAttribute("escritor", email);
             List<RESUMEN> resumenes  = client.target(URLHelper.getURL())
                         .request().accept(MediaType.APPLICATION_JSON)
                         .get(new GenericType<List<RESUMEN>>() {});
             req.setAttribute("resumenes", resumenes);
             */
             getServletContext().getRequestDispatcher("/Escritor.jsp").forward(req,resp);
             return;
        }  
        
        
        // autenticacion visitante
        if (email.contains("@visitante.es")) {
            req.getSession().setAttribute("visitante", email);
            List<RESUMEN> resumenes  = client.target(URLHelper.getURL())
                        .request().accept(MediaType.APPLICATION_JSON)
                        .get(new GenericType<List<RESUMEN>>() {});
            resumenes.sort(Comparator.comparing(RESUMEN::getPuntuacion).reversed());
            req.setAttribute("resumenes", resumenes);
            getServletContext().getRequestDispatcher("/Visitante.jsp").forward(req,resp);
            return;
       } 
        
        
        // autenticacion lector
        if ( email.contains("@lector.es")) {
            req.getSession().setAttribute("lector", email);
            List<RESUMEN> resumenes  = client.target(URLHelper.getURL())
                        .request().accept(MediaType.APPLICATION_JSON)
                        .get(new GenericType<List<RESUMEN>>() {});
            resumenes.sort(Comparator.comparing(RESUMEN::getPuntuacion).reversed());
            req.setAttribute("resumenes", resumenes);
            getServletContext().getRequestDispatcher("/Lector.jsp").forward(req,resp);
            return;
       } 
        
        
        // autenticacion3
        RESUMEN resumen = null;
        try { resumen = client.target(URLHelper.getURL() + "/" + email)
                        .request().accept(MediaType.APPLICATION_JSON).get(RESUMEN.class);
        }catch (Exception e) {
        }
        if ( null != resumen ) {
                req.getSession().setAttribute("resumen", resumen);
                getServletContext().getRequestDispatcher("/Resumen.jsp").forward(req,resp);
                return;
        }
        getServletContext().getRequestDispatcher("/index.html").forward(req,resp);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
