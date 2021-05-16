package es.upm.dit.isst.resumen.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import es.upm.dit.isst.resumen.model.RESUMEN;

/**
 * Servlet implementation class FormCreaTFGServlet
 */
@WebServlet("/FormCreaResumenAdminServlet")
public class FormCreaResumenAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                RESUMEN resumen = new RESUMEN();
                resumen.setEmail(req.getParameter("email"));
                resumen.setPassword(req.getParameter("password"));
                resumen.setPuntuacion(0.0);
                resumen.setcount(0);
                resumen.setUrlAudio("urldelaudio");
                resumen.setTitle(req.getParameter("title"));
                resumen.setName(req.getParameter("name"));
                resumen.setUrlResumen(req.getParameter("urlResumen"));
                resumen.setUrlImage(req.getParameter("urlImage"));
                Client client = ClientBuilder.newClient(new ClientConfig());
                client.target(URLHelper.getURL()).request()
                        .post(Entity.entity(resumen, MediaType.APPLICATION_JSON)
                       , Response.class);
                if (resumen != null) {
                	List<RESUMEN> resumenes = client.target(URLHelper.getURL())
              	          .request().accept(MediaType.APPLICATION_JSON)
              	          .get(new GenericType<List<RESUMEN>>() {});
              	        req.setAttribute("resumenes", resumenes);
                }
	             
	        getServletContext().getRequestDispatcher("/FormLoginServlet?email=root&password=root").forward(req, resp);
	}

}