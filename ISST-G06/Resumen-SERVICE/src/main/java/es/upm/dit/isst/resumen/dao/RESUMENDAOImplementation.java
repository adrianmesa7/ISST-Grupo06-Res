package es.upm.dit.isst.resumen.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;


import es.upm.dit.isst.resumen.model.RESUMEN;

public class RESUMENDAOImplementation implements RESUMENDAO{

	private static  RESUMENDAOImplementation instancia = null; 
	private RESUMENDAOImplementation() {
	}

	public static RESUMENDAOImplementation getInstance() {
		if( null == instancia )
			instancia = new RESUMENDAOImplementation();
		return instancia;
	}

	@Override
	public RESUMEN create(RESUMEN resumen) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
			try {
				session.save(resumen);
			} catch(Exception e) {
				resumen = null;
			}
			session.getTransaction().commit();
			session.close();
		return resumen;
	}
	
	@Override
	public RESUMEN read (String email) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		RESUMEN tfg = session.get(RESUMEN.class, email);
		session.getTransaction().commit();
		session.close();
		return tfg;
	}
	
	@Override
	public RESUMEN update(RESUMEN resumen) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(resumen);
		session.getTransaction().commit();
		session.close();
		return resumen;
	}

	
	@Override
	public RESUMEN delete(RESUMEN resumen) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(resumen);
		session.getTransaction().commit();
		session.close();
		return resumen;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RESUMEN> readAll() {
			List<RESUMEN> resumenes = new ArrayList<RESUMEN> ();
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		resumenes.addAll(session.createQuery("from RESUMEN").list());
		session.getTransaction().commit();
		session.close();
		return resumenes;
	}

}
