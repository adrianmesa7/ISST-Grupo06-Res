package es.upm.dit.isst.resumen.dao;

import java.util.List;
import es.upm.dit.isst.resumen.model.RESUMEN;

public interface RESUMENDAO {
	public RESUMEN create(RESUMEN resumen);
	public RESUMEN read(String email);
	public RESUMEN update(RESUMEN resumen);
	public RESUMEN delete(RESUMEN resumen);
	public List<RESUMEN> readAll();
}
