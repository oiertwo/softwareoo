package proiektua;

import java.rmi.Naming; //BESTE ADIBIDEAN EZ ZEN BEHARREZKOA
import java.rmi.RemoteException;
import java.util.ListIterator;
import java.util.Observable;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class AplikazioNagusia extends JFrame { //extends Observable?
	//INTERFAZEA
	public static AplikazioNagusiaKudInterfazea nlInt;  //  @jve:decl-index=0:visual-constraint="38,6"

	private static Vector<Agentea> agenteZer = new Vector();
	private static Vector<Ezaugarria> ezaugarriZer = new Vector();  //  @jve:decl-index=0:
	private static Vector<Data> dataZer = new Vector();

	private JFrame frameErreserba = null;
	private JPanel edukiontziErreserba = null;
	private JLabel labAgentea = null;
	private JLabel labPertsonaKop = null;
	private JLabel labaugarriak = null;
	private JLabel labIrteeraData = null;
	private JLabel labBaieztapenZenb = null;
	private JLabel labIzena = null;
	private JLabel labHelbidea = null;
	private JLabel labTelefonoa = null;
	private JComboBox cmbPertsonaKop = null;
	private JComboBox cmbAgenteak = null;
	private JComboBox cmbEzaugarriak = null;
	private JComboBox cmbIrteeraData = null;
	private JTextField txtBaieztapenZenb = null;
	private JTextField txtIzena = null;
	private JTextField txtHelbidea = null;
	private JTextField txtTelefonoa = null;
	private JButton btnErreserbaBerria = null;
	private JButton btnSartuErreserba = null;
	private JButton btnSartuTurista = null;
	private JButton btnBidali = null;
	private JButton btnEzeztatu = null;
	private JTextArea taErreserba = null;
	private JLabel labErreserba = null;

	private JLabel labEzaugarriak = null;
	/**
	 * This method initializes frameErreserba
	 *
	 * @return javax.swing.JFrame
	 */
	private JFrame getFrameErreserba() {
		if (frameErreserba == null) {
			frameErreserba = new JFrame();
			frameErreserba.setSize(new Dimension(738, 408));
			frameErreserba.setTitle("Erreserba sistema");
			frameErreserba.setContentPane(getEdukiontziErreserba());
		}
		return frameErreserba;
	}

	/**
	 * This method initializes edukiontziErreserba
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getEdukiontziErreserba() {
		if (edukiontziErreserba == null) {
			labEzaugarriak = new JLabel();
			labEzaugarriak.setBounds(new Rectangle(13, 67, 141, 16));
			labEzaugarriak.setText("Irteeraren ezaugarriak");
			labErreserba = new JLabel();
			labErreserba.setBounds(new Rectangle(591, 12, 66, 16));
			labErreserba.setText("Erreserba");
			labTelefonoa = new JLabel();
			labTelefonoa.setBounds(new Rectangle(15, 324, 63, 16));
			labTelefonoa.setText("Telefonoa");
			labHelbidea = new JLabel();
			labHelbidea.setBounds(new Rectangle(14, 284, 57, 16));
			labHelbidea.setText("Helbidea");
			labIzena = new JLabel();
			labIzena.setBounds(new Rectangle(14, 244, 41, 16));
			labIzena.setText("Izena");
			labBaieztapenZenb = new JLabel();
			labBaieztapenZenb.setBounds(new Rectangle(13, 212, 127, 16));
			labBaieztapenZenb.setText("Baieztapen zenbakia");
			labIrteeraData = new JLabel();
			labIrteeraData.setBounds(new Rectangle(15, 108, 72, 16));
			labIrteeraData.setText("Irteera data");
			labEzaugarriak = new JLabel();
			labEzaugarriak.setBounds(new Rectangle(14, 66, 136, 16));
			labEzaugarriak.setText("Irteeraren ezaugarriak");
			labPertsonaKop = new JLabel();
			labPertsonaKop.setBounds(new Rectangle(15, 150, 107, 16));
			labPertsonaKop.setText("Pertsona kopurua");
			edukiontziErreserba = new JPanel();
			edukiontziErreserba.setLayout(null);
			edukiontziErreserba.add(getLabAgentea(), null);
			edukiontziErreserba.add(labPertsonaKop, null);
			edukiontziErreserba.add(labEzaugarriak, null);
			edukiontziErreserba.add(labIrteeraData, null);
			edukiontziErreserba.add(labBaieztapenZenb, null);
			edukiontziErreserba.add(labIzena, null);
			edukiontziErreserba.add(labHelbidea, null);
			edukiontziErreserba.add(labTelefonoa, null);
			edukiontziErreserba.add(getCmbPertsonaKop(), null);
			edukiontziErreserba.add(getCmbAgenteak(), null);
			edukiontziErreserba.add(getCmbEzaugarriak(), null);
			edukiontziErreserba.add(getCmbIrteeraData(), null);
			edukiontziErreserba.add(getTxtBaieztapenZenb(), null);
			edukiontziErreserba.add(getTxtIzena(), null);
			edukiontziErreserba.add(getTxtHelbidea(), null);
			edukiontziErreserba.add(getTxtTelefonoa(), null);
			edukiontziErreserba.add(getBtnErreserbaBerria(), null);
			edukiontziErreserba.add(getBtnSartuErreserba(), null);
			edukiontziErreserba.add(getBtnSartuTurista(), null);
			edukiontziErreserba.add(getBtnBidali(), null);
			edukiontziErreserba.add(getBtnEzeztatu(), null);
			edukiontziErreserba.add(getTaErreserba(), null);
			edukiontziErreserba.add(labErreserba, null);
			edukiontziErreserba.add(labEzaugarriak, null);
		}
		return edukiontziErreserba;
	}

	/**
	 * This method initializes labAgentea
	 *
	 * @return javax.swing.JLabel
	 */
	private JLabel getLabAgentea() {
		if (labAgentea == null) {
			labAgentea = new JLabel();
			labAgentea.setText("Erreserba Agentea");
			labAgentea.setBounds(new Rectangle(14, 24, 130, 15));
		}
		return labAgentea;
	}

	/**
	 * This method initializes cmbPertsonaKop
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getCmbPertsonaKop() {
		if (cmbPertsonaKop == null) {
			cmbPertsonaKop = new JComboBox();
			cmbPertsonaKop.setBounds(new Rectangle(169, 144, 53, 25));
			for(int i=1;i<=10;i++){
				cmbPertsonaKop.addItem(i);
			}
		}
		return cmbPertsonaKop;
	}

	/**
	 * This method initializes cmbAgenteak
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getCmbAgenteak() {
		if (cmbAgenteak == null) {
			cmbAgenteak = new JComboBox();
			cmbAgenteak.setBounds(new Rectangle(169, 18, 154, 25));
			agenteakKargatu();
			cmbAgenteak.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if(e.getStateChange() == ItemEvent.SELECTED){
						eguneratuEzaugarriak();
						datakKargatu();
					}
				}
			});
		}
		return cmbAgenteak;
	}

	/**
	 * This method initializes cmbEzaugarriak
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getCmbEzaugarriak() {
		if (cmbEzaugarriak == null) {
			cmbEzaugarriak = new JComboBox();
			cmbEzaugarriak.setBounds(new Rectangle(169, 63, 155, 25));
			eguneratuEzaugarriak();

			cmbEzaugarriak.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if(e.getStateChange() == ItemEvent.SELECTED)
						datakKargatu();
				}
			});
		}
		return cmbEzaugarriak;
	}

	/**
	 * This method initializes cmbIrteeraData
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getCmbIrteeraData() {
		if (cmbIrteeraData == null) {
			cmbIrteeraData = new JComboBox();
			cmbIrteeraData.setBounds(new Rectangle(169, 105, 140, 25));
			datakKargatu();
		}
		return cmbIrteeraData;
	}

	/**
	 * This method initializes txtBaieztapenZenb
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtBaieztapenZenb() {
		if (txtBaieztapenZenb == null) {
			txtBaieztapenZenb = new JTextField();
			txtBaieztapenZenb.setBounds(new Rectangle(168, 211, 79, 20));
			txtBaieztapenZenb.setEnabled(false);
		}
		return txtBaieztapenZenb;
	}

	/**
	 * This method initializes txtIzena
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtIzena() {
		if (txtIzena == null) {
			txtIzena = new JTextField();
			txtIzena.setBounds(new Rectangle(168, 248, 163, 20));
			txtIzena.setEnabled(false);
		}
		return txtIzena;
	}

	/**
	 * This method initializes txtHelbidea
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtHelbidea() {
		if (txtHelbidea == null) {
			txtHelbidea = new JTextField();
			txtHelbidea.setBounds(new Rectangle(168, 285, 181, 20));
			txtHelbidea.setEnabled(false);
		}
		return txtHelbidea;
	}

	/**
	 * This method initializes txtTelefonoa
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtTelefonoa() {
		if (txtTelefonoa == null) {
			txtTelefonoa = new JTextField();
			txtTelefonoa.setBounds(new Rectangle(168, 320, 125, 20));
			txtTelefonoa.setEnabled(false);
		}
		return txtTelefonoa;
	}

	/**
	 * This method initializes btnErreserbaBerria
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getBtnErreserbaBerria() {
		if (btnErreserbaBerria == null) {
			btnErreserbaBerria = new JButton();
			btnErreserbaBerria.setBounds(new Rectangle(366, 86, 142, 35));
			btnErreserbaBerria.setText("Erreserba berria");
			btnErreserbaBerria.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//Aukeratutako bidairako toki libreak dauden begiratu:
					try{
						String agenteId = agenteZer.get(cmbAgenteak.getSelectedIndex()).getId();
						String irteeraId = ezaugarriZer.get(cmbEzaugarriak.getSelectedIndex()).getId();
						String data = dataZer.get(cmbIrteeraData.getSelectedIndex()).getData();
						int bidaiariKop = cmbPertsonaKop.getSelectedIndex()+1;
						//System.out.println("DATUAK: AgenteId:" + agenteId + " IrteeraId:" + irteeraId + " Data:" + data + " BidaiariKop:" + bidaiariKop);
						String zenb = nlInt.getErreserbaBaieztapenZenbakia(agenteId, irteeraId, data, bidaiariKop);
						if(zenb!=null){
							taErreserba.setText("Erreserba egin dezakezu.\nBaieztapen zenbakia: "+zenb+"\n");
							baieztapenInterfazea();
						}
						else{
							taErreserba.setText("Baieztapen zenbaki okerra!\n");
						}
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}
			});
		}
		return btnErreserbaBerria;
	}

	/**
	 * This method initializes btnSartuErreserba
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getBtnSartuErreserba() {
		if (btnSartuErreserba == null) {
			btnSartuErreserba = new JButton();
			btnSartuErreserba.setBounds(new Rectangle(372, 206, 128, 26));
			btnSartuErreserba.setText("Sartu erreserba");
			btnSartuErreserba.setEnabled(false);
			btnSartuErreserba.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//Erabiltzaileak sartutako baieztapen zenbakia zuzena dela baieztatu:
					String sartutakoZenb = txtBaieztapenZenb.getText();
					try {
						if(nlInt.baieztapenZenbakiaKonprobatu(sartutakoZenb)){
							//Baieztapen zenbaki zuzena. Agenteak sartzeko interfazea erakutsi:
							bezeroakSartuInterfazea();
							taErreserba.setText(taErreserba.getText()+"\nBaieztapen zenbakia zuzena.\nErreserba egin daiteke.");
						}
						else{
							taErreserba.setText(taErreserba.getText()+"Baieztapen zenbakia okerra da!\nEzin da erreserbarik egin.");
						}
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				}
			});
		}
		return btnSartuErreserba;
	}

	/**
	 * This method initializes btnSartuTurista
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getBtnSartuTurista() {
		if (btnSartuTurista == null) {
			btnSartuTurista = new JButton();
			btnSartuTurista.setBounds(new Rectangle(372, 244, 128, 26));
			btnSartuTurista.setText("Sartu Turista");
			btnSartuTurista.setEnabled(false);
		}
		return btnSartuTurista;
	}

	/**
	 * This method initializes btnBidali
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getBtnBidali() {
		if (btnBidali == null) {
			btnBidali = new JButton();
			btnBidali.setBounds(new Rectangle(372, 282, 128, 26));
			btnBidali.setText("Bidali");
			btnBidali.setEnabled(false);
		}
		return btnBidali;
	}

	/**
	 * This method initializes btnEzeztatu
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getBtnEzeztatu() {
		if (btnEzeztatu == null) {
			btnEzeztatu = new JButton();
			btnEzeztatu.setBounds(new Rectangle(373, 318, 128, 26));
			btnEzeztatu.setText("Ezeztatu");
			btnEzeztatu.setEnabled(false);
		}
		return btnEzeztatu;
	}

	/**
	 * This method initializes taErreserba
	 *
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getTaErreserba() {
		if (taErreserba == null) {
			taErreserba = new JTextArea();
			taErreserba.setBounds(new Rectangle(527, 37, 197, 151));
			taErreserba.setEditable(false);
		}
		return taErreserba;
	}

	/**
	 * This is the default constructor
	 */
	public AplikazioNagusia() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(750, 400);
		//this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/llanta.gif")));
		this.setResizable(false);
		this.setContentPane(getEdukiontziErreserba());
		this.setTitle("Erreserba sistema");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				try{
					nlInt.deskonektatuDB();
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		this.setLocationRelativeTo(null);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String host = "localhost";
		try{
			nlInt = (AplikazioNagusiaKudInterfazea)Naming.lookup("rmi://"+host+"/erreserba_sistema");
		}
		catch(Exception ex){
			System.out.println("Errorea zerbitzua hastean. " + ex.getMessage());
		}

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AplikazioNagusia thisClass = new AplikazioNagusia();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});	}

	private void agenteakKargatu(){
		try {
			agenteZer = nlInt.getAgenteak();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		//cmbAgenteak.removeAllItems();
		for(int i=0; (agenteZer.size() > i);i++){
			cmbAgenteak.addItem(agenteZer.get(i).getIzena());
		}
	}


	private void eguneratuEzaugarriak(){
		cmbEzaugarriak.removeAllItems();
		ezaugarriZer.removeAllElements();
		try {
			String agenteId = agenteZer.get(cmbAgenteak.getSelectedIndex()).getId();
			ezaugarriZer=nlInt.getEzaugarriak(agenteId);
			for(int i=0; (ezaugarriZer.size() > i);i++){
				cmbEzaugarriak.addItem(ezaugarriZer.get(i).getEzaugarri());
			}
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
	}

	private void datakKargatu(){
		cmbIrteeraData.removeAllItems();
		dataZer.removeAllElements();
		try {
			dataZer=nlInt.getDatak(agenteZer.get(cmbAgenteak.getSelectedIndex()).getId(),ezaugarriZer.get(cmbEzaugarriak.getSelectedIndex()).getId());
			for(int i=0; (dataZer.size() > i);i++){
				cmbIrteeraData.addItem(dataZer.get(i).getData());
		}
		} catch (RemoteException e1) {
			e1.printStackTrace();

		}
	}

	private void baieztapenInterfazea(){
		//Bidaiaren erreserbari buruzko interfazea ezkutatu:
		cmbAgenteak.setEnabled(false);
		cmbEzaugarriak.setEnabled(false);
		cmbIrteeraData.setEnabled(false);
		cmbPertsonaKop.setEnabled(false);
		btnErreserbaBerria.setEnabled(false);
		//Baieztapen zenbakia sartzeko botoia erakutsi:
		txtBaieztapenZenb.setEnabled(true);
		btnSartuErreserba.setEnabled(true);
	}

	private void bezeroakSartuInterfazea(){
		//Baieztapen zenbakia sartzeko botoia ezkutatu.
		txtBaieztapenZenb.setEnabled(false);
		btnSartuErreserba.setEnabled(false);
		//Turistak sartzeko interfazea erakutsi:
		txtIzena.setEnabled(true);
		txtHelbidea.setEnabled(true);
		txtTelefonoa.setEnabled(true);
		btnSartuTurista.setEnabled(true);
		btnEzeztatu.setEnabled(true);
	}
}

/* Uneko frame eskutatzeko eta beste frame bat irekitzeko:
dispose();
ibilgailuaHartuUtzi.IbilgailuaHartuUtzi ibHU = new ibilgailuaHartuUtzi.IbilgailuaHartuUtzi(0);
ibHU.setVisible(true);
*/

