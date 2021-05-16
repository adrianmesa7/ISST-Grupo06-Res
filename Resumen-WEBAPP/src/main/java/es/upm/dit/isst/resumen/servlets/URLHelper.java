package es.upm.dit.isst.resumen.servlets;

public class URLHelper {
	public static String getURL() {
                String envValue = System.getenv("RESUMENSERVICE_SRV_SERVICE_HOST");
                if(envValue == null)
                        return "http://localhost:8080/Resumen-SERVICE/rest/Resumenes";
                else
                        return envValue;
        }
}
