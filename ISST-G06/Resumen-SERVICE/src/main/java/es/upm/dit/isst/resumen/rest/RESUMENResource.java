  package es.upm.dit.isst.resumen.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import es.upm.dit.isst.resumen.dao.RESUMENDAOImplementation;
import es.upm.dit.isst.resumen.model.RESUMEN;

@Path("/TFGs")
public class RESUMENResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<RESUMEN> readAll () {
	        return RESUMENDAOImplementation.getInstance().readAll();
	}


	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(RESUMEN tnew) throws URISyntaxException {
		RESUMEN t = RESUMENDAOImplementation.getInstance().create(tnew);
	    if (t != null) {
	            URI uri = new URI("/RESUMEN-SERVICE/rest/RESUMENES/" + t.getEmail());
	            return Response.created(uri).build();
	    }
	    return Response.status(Response.Status.NOT_FOUND).build();
	}
	
	@GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response read(@PathParam("id") String id) {
		RESUMEN t = RESUMENDAOImplementation.getInstance().read(id);
        if (t == null)
          return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(t, MediaType.APPLICATION_JSON).build();
    }        


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(@PathParam("id") String id, RESUMEN t) {
            System.out.println("Update request for" + id + " " + t.toString());
            RESUMEN told = RESUMENDAOImplementation.getInstance().read(id);
        if ((told == null) || (! told.getEmail().contentEquals(t.getEmail())))
          return Response.notModified().build();
        RESUMENDAOImplementation.getInstance().update(t);
        return Response.ok().build();                
    }


    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String  id) {
    	RESUMEN rold = RESUMENDAOImplementation.getInstance().read(id);
        if (rold == null)
            return Response.notModified().build();
        RESUMENDAOImplementation.getInstance().delete(rold);
        return Response.ok().build();
    }
}
