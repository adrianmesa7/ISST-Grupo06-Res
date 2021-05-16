package es.upm.dit.isst.resumen.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;



@ApplicationPath("rest")
public class RESUMENApp extends ResourceConfig {
        public RESUMENApp() {
                packages("es.upm.dit.isst.resumen.rest");

        }

}