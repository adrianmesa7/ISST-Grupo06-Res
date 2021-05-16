package es.upm.dit.isst.resumen.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.dit.isst.resumen.dao.RESUMENDAO;
import es.upm.dit.isst.resumen.dao.RESUMENDAOImplementation;
import es.upm.dit.isst.resumen.model.RESUMEN;

class TestRESUMENDAOImplementation {
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testBasedeDatos() {
		RESUMENDAO rdao = RESUMENDAOImplementation.getInstance();
		RESUMEN resumen = new RESUMEN();
		
		resumen.setEmail("Juan@escritor.es");
		resumen.setPassword("1234");
		resumen.setName("Juan");
		resumen.setTitle("titulo");
		resumen.setPuntuacion(2);

		rdao.create(resumen);
		
		RESUMEN resumen2 = rdao.read("titulo");
		assertEquals(resumen2.getEmail(), resumen.getEmail());
		assertEquals(resumen2.getName(),resumen.getName());
		assertEquals(resumen2.getTitle(),resumen.getTitle());
		assertEquals(resumen2.getName(),"Juan");
		assertEquals(resumen2.getPuntuacion(),resumen.getPuntuacion());
		
		
		rdao.delete(resumen);
		resumen2 = rdao.read("Juan@escritor.es");

        assertNull(resumen2);
		
		
		
		
	}
	
	
	
	
}
