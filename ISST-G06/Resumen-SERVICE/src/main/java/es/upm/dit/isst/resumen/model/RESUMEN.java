package es.upm.dit.isst.resumen.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RESUMEN implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String title; //título resumen
	private String email; 
	private String password; //contraseña
	private String name; //nombre escritor
	private double puntuacion;
	private String urlResumen;
	private String urlAudio;
	private String urlImage;
	private int count;
	
	

	public RESUMEN() {}
	
	
	
	public String getUrlAudio() {
		return urlAudio;
	}


	public String getUrlImage() {
		return urlImage;
	}



	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}



	public void setUrlAudio(String urlAudio) {
		this.urlAudio = urlAudio;
	}


	public String geturlResumen() {
		return urlResumen;
	}


	public void seturlResumen(String urlResumen) {
		this.urlResumen = urlResumen;
	}


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

	
	public int getcount() {
		return count;
	}


	public void setcount(int count) {
		this.count = count;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "RESUMEN [title=" + title + ", email=" + email + ", password=" + password + ", name=" + name
				+ ", puntuacion=" + puntuacion + ", urlResumen=" + urlResumen + ", urlAudio=" + urlAudio + ", urlImage="
				+ urlImage + ", count=" + count + "]";
	}






}
