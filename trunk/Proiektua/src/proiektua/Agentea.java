package proiektua;

import java.io.Serializable;

public class Agentea implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String agenteId;
	private String agenteIzena;

	public Agentea(String id, String izena){
		this.agenteId = id;
		this.agenteIzena = izena;
	}

	public String getAgenteId(){
		return this.agenteId;
	}
	public String getAgenteIzena(){
		return this.agenteIzena;
	}
	public void setAgenteIzena(String izena){
		this.agenteIzena = izena;
	}
}
