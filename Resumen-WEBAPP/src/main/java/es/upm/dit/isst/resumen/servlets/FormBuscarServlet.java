package es.upm.dit.isst.resumen.servlets;

import java.io.IOException;
import java.util.ArrayList;
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


@WebServlet("/FormBuscarServlet")
public class FormBuscarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
        String busqueda = req.getParameter("busqueda");
        Client client = ClientBuilder.newClient(new ClientConfig());

        List<RESUMEN> resumenesTodos  = client.target(URLHelper.getURL())
                    .request().accept(MediaType.APPLICATION_JSON)
                    .get(new GenericType<List<RESUMEN>>() {});            
        
        List<RESUMEN> resumenes = new ArrayList<RESUMEN>();
		
        for (int i=0; i<resumenesTodos.size(); i++) {
        	if (resumenesTodos.get(i).getTitle().contains(busqueda)) {
        		resumenes.add(resumenesTodos.get(i));
        	}
        }
        resumenes.sort(Comparator.comparing(RESUMEN::getPuntuacion).reversed());
        req.setAttribute("resumenes", resumenes);
        getServletContext().getRequestDispatcher("/Buscar.jsp").forward(req,resp);
        return;

     }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
