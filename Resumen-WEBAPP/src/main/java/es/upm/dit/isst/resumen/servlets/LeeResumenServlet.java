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
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import es.upm.dit.isst.resumen.model.RESUMEN;

/**
 * Servlet implementation class LeeResumenServlet
 */
@WebServlet("/LeeResumenServlet")
public class LeeResumenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = req.getParameter("email");
		  Client client = ClientBuilder.newClient(new ClientConfig());
		  RESUMEN resumen = null;
		  try {
		         resumen = client.target(URLHelper.getURL() + "/" + email)
		              .request().accept(MediaType.APPLICATION_JSON).get(RESUMEN.class);
		  } catch(Exception e) {}
		  if (resumen != null) {
		       resumen.setTitle(req.getParameter("title"));
		       resumen.setName(req.getParameter("name"));
		       resumen.setPuntuacion(Double.parseDouble(req.getParameter("puntuacion")));
		       client.target(URLHelper.getURL() + "/" +email)
		          .request()
		          .post(Entity.entity(resumen, MediaType.APPLICATION_JSON), Response.class);
		        List<RESUMEN> resumenes = client.target(URLHelper.getURL())
		          .request().accept(MediaType.APPLICATION_JSON)
		          .get(new GenericType<List<RESUMEN>>() {});
		        resumenes.sort(Comparator.comparing(RESUMEN::getPuntuacion).reversed());
		        req.setAttribute("resumenes", resumenes);
		  }
		  getServletContext().getRequestDispatcher("/Resumen.jsp").forward(req,resp);
	}

	

}
