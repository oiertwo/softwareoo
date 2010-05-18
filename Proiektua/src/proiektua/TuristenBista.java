package proiektua;

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

public class TuristenBista implements Observer {
	private int pertsonaKop;
	private int unekoPosizioa;
	private String ezaugarriId;
	private String agenteId;
	private String data;
	private String zenb;

	public TuristenBista(String agId, String ezId, String d, String z, int kop){
		agenteId=agId;
		ezaugarriId=ezId;
		data=d;
		pertsonaKop=kop;
		unekoPosizioa=0;
		zenb=z;
	}

	public void update(Observable ob, Object par) {
		if(par.equals("HASI_TURISTEN_INTERFAZEA")){
			this.hasieratuTuristenInterfazea();
		}
		else if(par.equals("HURRENGO_TURISTA")){
			if(AplikazioNagusia.txtIzena.getText().equals("") || AplikazioNagusia.txtHelbidea.getText().equals("") || AplikazioNagusia.txtTelefonoa.getText().equals("")){
				JOptionPane.showMessageDialog(null,"Turistari buruzko datu guztiak bete behar dira.","Turista sartu",JOptionPane.WARNING_MESSAGE);
			}
			else{
				gehituTurista(unekoPosizioa);
				unekoPosizioa++;
				joanPosiziora(unekoPosizioa);
				AplikazioNagusia.txtIzena.requestFocus();
			}
		}
		else if(par.equals("AURREKO_TURISTA")){
			unekoPosizioa--;
			joanPosiziora(unekoPosizioa);
		}
		else if(par.equals("BIDALI_ERRESERBA")){
			//Erreserba eta Turistak datu basean sartu
			try {
				AplikazioNagusia.nlInt.sartuErreserba(zenb, ezaugarriId, agenteId, data);
				AplikazioNagusia.nlInt.sartuTuristak();
			} catch (RemoteException e1) {
				e1.printStackTrace();
				System.out.println("ERROREA. Erreserba egitean arazoa");
			}
			JOptionPane.showMessageDialog(null,"Erreserbak ondo egin dira.","Erreserbaren baieztapena",JOptionPane.PLAIN_MESSAGE);
			hasieratuInterfazea();
		}
		else if(par.equals("EZEZTATU_ERRESERBA")){
			JOptionPane.showMessageDialog(null,"Erreserba ezeztatu da.","Erreserbaren ezeztapena",JOptionPane.PLAIN_MESSAGE);
			hasieratuInterfazea();
		}
		else if(par.equals("ALDATU_ERRESERBA")){
			unekoPosizioa=0;
			joanPosiziora(0);
			hasieratuTuristenInterfazea();
		}
	}

	//FUNTZIO LAGUNGARRIAK:
	private void gehituTurista(int pos){
		try {
			AplikazioNagusia.nlInt.gehituTurista(AplikazioNagusia.txtIzena.getText(),AplikazioNagusia.txtHelbidea.getText(),AplikazioNagusia.txtTelefonoa.getText(),pos);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		AplikazioNagusia.taErreserba.setText(AplikazioNagusia.taErreserba.getText() + "***** " +
				(unekoPosizioa+1)+ ". Turista" +" *****"
				+ "\nIzena: " + AplikazioNagusia.txtIzena.getText() +
				"\nHelbidea: " + AplikazioNagusia.txtHelbidea.getText()+
				"\nTelefonoa: " + AplikazioNagusia.txtTelefonoa.getText()+"\n");
	}

	private void joanPosiziora(int pos){
		Turista t=null;
		AplikazioNagusia.labTuristaZenb.setText((pos+1)+"/"+pertsonaKop);
		try {
			t = AplikazioNagusia.nlInt.lortuTurista(pos);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		AplikazioNagusia.txtIzena.setText(t.getIzena());
		AplikazioNagusia.txtHelbidea.setText(t.getHelbidea());
		AplikazioNagusia.txtTelefonoa.setText(t.getTelefonoa());

		if(pos >= pertsonaKop){
			bidaliErreserbaInterfazea();
		}
		else if(unekoPosizioa == 0){
			AplikazioNagusia.btnTuristaAtzera.setEnabled(false);
		}
		else AplikazioNagusia.btnTuristaAtzera.setEnabled(true);
	}

	private void bidaliErreserbaInterfazea(){
		AplikazioNagusia.btnTuristaAtzera.setEnabled(false);
		AplikazioNagusia.btnSartuTurista.setEnabled(false);
		AplikazioNagusia.txtIzena.setEnabled(false);
		AplikazioNagusia.txtHelbidea.setEnabled(false);
		AplikazioNagusia.txtTelefonoa.setEnabled(false);
		AplikazioNagusia.labTuristaZenb.setVisible(false);
		AplikazioNagusia.btnBidali.setEnabled(true);
		AplikazioNagusia.btnEzeztatu.setEnabled(true);
		AplikazioNagusia.btnAldatu.setEnabled(true);
	}

	private void hasieratuInterfazea(){
		try {
			AplikazioNagusia.nlInt.ezabatuTuristak();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		unekoPosizioa=0;
		pertsonaKop=0;
		AplikazioNagusia.txtIzena.setText("");
		AplikazioNagusia.txtHelbidea.setText("");
		AplikazioNagusia.txtTelefonoa.setText("");
	}

	private void hasieratuTuristenInterfazea(){
		AplikazioNagusia.txtIzena.setEnabled(true);
		AplikazioNagusia.txtHelbidea.setEnabled(true);
		AplikazioNagusia.txtTelefonoa.setEnabled(true);
		AplikazioNagusia.labTuristaZenb.setVisible(true);
		AplikazioNagusia.labTuristaZenb.setText((unekoPosizioa+1)+"/"+pertsonaKop);
		AplikazioNagusia.btnTuristaAtzera.setEnabled(false);
		AplikazioNagusia.btnSartuTurista.setEnabled(true);
		AplikazioNagusia.btnBidali.setEnabled(false);
		AplikazioNagusia.btnEzeztatu.setEnabled(false);
		AplikazioNagusia.btnAldatu.setEnabled(false);
		AplikazioNagusia.taErreserba.setText("");

		System.out.println("DATAK: agenteId="+agenteId+" ezaugarriId"+ezaugarriId+" data:"+data+
				" zenbakia="+zenb+ "pertsonaKop="+pertsonaKop);
	}
}
