package proiektua;

import java.io.Serializable;

public class Ezaugarria implements Serializable {

	private String ezaugarri;
	private String id;

	public Ezaugarria(String ident, String eza){
		ezaugarri=eza;
		this.id=ident;
	}

	public String getEzaugarri() {
		return ezaugarri;
	}

	public void setEzaugarri(String ezaugarri) {
		this.ezaugarri = ezaugarri;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
