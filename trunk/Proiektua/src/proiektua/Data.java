package proiektua;

import java.io.Serializable;

public class Data implements Serializable {

	private String data;
	private static int plazakop;
	private String agenteId;
	private String irteeraId;

	public Data(String d, String aId, String iId, int pk){
		data=d;
		agenteId=aId;
		irteeraId=iId;
		plazakop=pk;

	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public static int getPlazakop() {
		return plazakop;
	}

	public static void setPlazakop(int plazakop) {
		Data.plazakop = plazakop;
	}

	public String getAgenteId() {
		return agenteId;
	}

	public void setAgenteId(String agenteId) {
		this.agenteId = agenteId;
	}

	public String getIrteeraId() {
		return irteeraId;
	}

	public void setIrteeraId(String irteeraId) {
		this.irteeraId = irteeraId;
	}


}
