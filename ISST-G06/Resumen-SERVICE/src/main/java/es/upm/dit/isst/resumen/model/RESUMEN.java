package es.upm.dit.isst.resumen.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class RESUMEN implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String email;
	private String password;
	private String user;
	private String name;
	private String title;
	private double puntuacion;
	private String comentario;
	private String autor;
	private String escritor;
	@Lob
	private byte[] document;
	
	
	public RESUMEN() {}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public double getPuntuacion() {
		return puntuacion;
	}


	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}


	public String getComentario() {
		return comentario;
	}


	public void setComentario(String comentario) {
		this.comentario = comentario;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public String getEscritor() {
		return escritor;
	}


	public void setEscritor(String escritor) {
		this.escritor = escritor;
	}


	public byte[] getDocument() {
		return document;
	}


	public void setDocument(byte[] document) {
		this.document = document;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RESUMEN other = (RESUMEN) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "RESUMEN [email=" + email + ", password=" + password + ", user=" + user + ", name=" + name + ", title="
				+ title + ", puntuacion=" + puntuacion + ", comentario=" + comentario + ", autor=" + autor
				+ ", escritor=" + escritor + ", document=" + Arrays.toString(document) + "]";
	}
	
	
}
