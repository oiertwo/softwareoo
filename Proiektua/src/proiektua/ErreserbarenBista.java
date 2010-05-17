package proiektua;

import java.rmi.RemoteException;
import java.util.*;
import javax.swing.ImageIcon;

public class ErreserbarenBista implements Observer{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String zenb;
	private int plazaKop;

	public void update(Observable ob, Object par){
		if(par.equals("HASI_INTERFAZE_NAGUSIA")){
			hasieratuKontrolak();
			kargatuAgenteak();
			kargatuEzaugarriak();
			kargatuDatak();
			kargatuArgazkia();
		}
		else if(par.equals("AGENTEAK")){
			kargatuEzaugarriak();
			kargatuDatak();
			kargatuArgazkia();
		}
		else if(par.equals("EZAUGARRIAK")){
			kargatuDatak();
			kargatuArgazkia();
		}
		else if(par.equals("DATA")){
			kargatuPlazaKop();
		}
		else if(par.equals("ERRES_BERRI")){
			try{
				int bidaiariKop = AplikazioNagusia.cmbPertsonaKop.getSelectedIndex()+1;
				String data = AplikazioNagusia.cmbDatak.getSelectedItem().toString();
				zenb = AplikazioNagusia.nlInt.getErreserbaBaieztapenZenbakia(AplikazioNagusia.cmbAgenteak, AplikazioNagusia.cmbEzaugarriak, data, bidaiariKop);
				if(zenb!=null){
					AplikazioNagusia.taErreserba.setText("Erreserba egin dezakezu.\nBaieztapen zenbakia: "+zenb+"\n*******************************");
					baieztapenInterfazea();
				}
				else{
					AplikazioNagusia.taErreserba.setText("Ez dago nahiko tokirik bidaia honentzat!\n");
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		else if(par.equals("ERRES_SARTU")){
			//Kontrolak erakutsi/ezkutatu
			AplikazioNagusia.txtBaieztapenZenb.setEnabled(false);
			AplikazioNagusia.btnSartuErreserba.setEnabled(false);
			AplikazioNagusia.taErreserba.setText("");

			AplikazioNagusia.txtIzena.setEnabled(true);
			AplikazioNagusia.txtHelbidea.setEnabled(true);
			AplikazioNagusia.txtTelefonoa.setEnabled(true);
			AplikazioNagusia.btnSartuTurista.setEnabled(true);
			AplikazioNagusia.btnBidali.setEnabled(false);
			AplikazioNagusia.btnAldatu.setEnabled(false);
			AplikazioNagusia.btnEzeztatu.setEnabled(true);
			AplikazioNagusia.labTuristaZenb.setText(1+"/"+AplikazioNagusia.cmbPertsonaKop.getSelectedItem());
			AplikazioNagusia.txtIzena.requestFocus();
			AplikazioNagusia.unekoPosizioa=0;
		}
	}

	//FUNTZIO LAGUNGARRIAK:
	private void hasieratuKontrolak(){
		AplikazioNagusia.txtIzena.setEnabled(false);
		AplikazioNagusia.txtHelbidea.setEnabled(false);
		AplikazioNagusia.txtTelefonoa.setEnabled(false);
		AplikazioNagusia.btnTuristaAtzera.setEnabled(false);
		AplikazioNagusia.btnSartuTurista.setEnabled(false);
		AplikazioNagusia.btnBidali.setEnabled(false);
		AplikazioNagusia.btnAldatu.setEnabled(false);
		AplikazioNagusia.btnEzeztatu.setEnabled(false);
		AplikazioNagusia.labTuristaZenb.setText("");
		AplikazioNagusia.txtBaieztapenZenb.setText("");

		AplikazioNagusia.cmbAgenteak.setEnabled(true);
		AplikazioNagusia.cmbEzaugarriak.setEnabled(true);
		AplikazioNagusia.cmbPertsonaKop.setEnabled(true);
		AplikazioNagusia.cmbDatak.setEnabled(true);
		AplikazioNagusia.btnErreserbaBerria.setEnabled(true);
		AplikazioNagusia.btnSartuErreserba.setEnabled(false);
		AplikazioNagusia.taErreserba.setText("");
		AplikazioNagusia.cmbPertsonaKop.setSelectedIndex(0);
	}

	private void kargatuAgenteak(){
		try {
			Vector<String> agenteIzenak = AplikazioNagusia.nlInt.kargatuAgenteak();
			AplikazioNagusia.cmbAgenteak.removeAllItems();
			for(int i=0;i<agenteIzenak.size();i++){
				AplikazioNagusia.cmbAgenteak.addItem(agenteIzenak.get(i));
			}
		}catch (RemoteException e1) {
			e1.printStackTrace();
		}
	}

	private void kargatuEzaugarriak(){
		try {
			Vector<String> ezaugarriak = AplikazioNagusia.nlInt.kargatuEzaugarriak(AplikazioNagusia.cmbAgenteak);
			AplikazioNagusia.cmbEzaugarriak.removeAllItems();
			for(int i=0;i<ezaugarriak.size();i++){
				AplikazioNagusia.cmbEzaugarriak.addItem(ezaugarriak.get(i));
			}
			kargatuArgazkia();
		}catch (RemoteException e1) {
			e1.printStackTrace();
		}
	}

	private void kargatuArgazkia(){
		String auk=null;
		try {
			auk = AplikazioNagusia.nlInt.lortuAukeratutakoEzaugarriId(AplikazioNagusia.cmbEzaugarriak);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		AplikazioNagusia.labAukeraIrteera.setIcon(new ImageIcon(getClass().getResource("/img/"+auk+".jpg")));
	}

	private void kargatuDatak(){
		try {
			Vector<String> datak = AplikazioNagusia.nlInt.kargatuDatak(AplikazioNagusia.cmbEzaugarriak, AplikazioNagusia.cmbAgenteak);
			AplikazioNagusia.cmbDatak.removeAllItems();
			for(int i=0;i<datak.size();i++){
				AplikazioNagusia.cmbDatak.addItem(datak.get(i));
			}
		}catch (RemoteException e1) {
			e1.printStackTrace();
		}
	}

	private void kargatuPlazaKop(){
		String agenteId=null;
		String  ezaugarriId=null;
		String data=null;
		try {
			agenteId = AplikazioNagusia.nlInt.lortuAukeratutakoAgenteId(AplikazioNagusia.cmbAgenteak);
			ezaugarriId = AplikazioNagusia.nlInt.lortuAukeratutakoEzaugarriId(AplikazioNagusia.cmbEzaugarriak);
			data = AplikazioNagusia.cmbDatak.getSelectedItem().toString();
			plazaKop = AplikazioNagusia.nlInt.getPlazaKop(agenteId, ezaugarriId, data);
			AplikazioNagusia.labPlazaKop.setText(plazaKop+"");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		System.out.println(" plaza kop librea:"+plazaKop);
	}

	private void baieztapenInterfazea(){
		//Bidaiaren erreserbari buruzko interfazea ezkutatu:
		AplikazioNagusia.cmbAgenteak.setEnabled(false);
		AplikazioNagusia.cmbEzaugarriak.setEnabled(false);
		AplikazioNagusia.cmbDatak.setEnabled(false);
		AplikazioNagusia.cmbPertsonaKop.setEnabled(false);
		AplikazioNagusia.btnErreserbaBerria.setEnabled(false);
		//Baieztapen zenbakia sartzeko botoia erakutsi:
		AplikazioNagusia.btnSartuErreserba.setEnabled(true);
		AplikazioNagusia.txtBaieztapenZenb.setEnabled(true);
		AplikazioNagusia.txtBaieztapenZenb.requestFocus();
	}
}