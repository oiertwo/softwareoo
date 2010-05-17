package proiektua;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.Font;

public class AplikazioNagusia extends JFrame { //extends Observable?
	//INTERFAZEA
	public static AplikazioNagusiaKudInterfazea nlInt;

	private String zenb;
	private int unekoPosizioa;

	private JFrame frameErreserba = null;  //  @jve:decl-index=0:visual-constraint="64,420"
	private JPanel edukiontziErreserba = null;
	private JLabel labAgentea = null;
	private JLabel labPertsonaKop = null;
	private JLabel labIrteeraData = null;
	private JLabel labBaieztapenZenb = null;
	private JComboBox cmbPertsonaKop = null;
	private JComboBox cmbAgenteak = null;
	private JComboBox cmbEzaugarriak = null;
	private JComboBox cmbDatak = null;
	private JTextField txtBaieztapenZenb = null;
	private JButton btnErreserbaBerria = null;
	private JButton btnSartuErreserba = null;
	private JLabel labErreserba = null;

	private JLabel labEzaugarriak = null;

	private JTextArea taErreserba = null;
	private JLabel labAukeraIrteera = null;
	private JLabel labAukIr = null;
	private JLabel labPK = null;
	private JLabel labPlazaKop = null;

	private JButton btnTuristaAtzera = null;

	private JButton btnSartuTurista = null;

	private JButton btnEzeztatu = null;

	private JButton btnBidali = null;

	private JButton btnAldatu = null;

	private JLabel labTuristaZenb = null;

	private JLabel labIzena = null;

	private JLabel labHelbidea = null;

	private JLabel labTelefonoa = null;

	private JTextField txtIzena = null;

	private JTextField txtHelbidea = null;

	private JTextField txtTelefonoa = null;

	/**
	 * This method initializes frameErreserba
	 *
	 * @return javax.swing.JFrame
	 */
	private JFrame getFrameErreserba() {
		if (frameErreserba == null) {
			frameErreserba = new JFrame();
			frameErreserba.setSize(new Dimension(875, 467));
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
			labTelefonoa = new JLabel();
			labTelefonoa.setBounds(new Rectangle(166, 376, 70, 16));
			labTelefonoa.setText("Telefonoa:");
			labHelbidea = new JLabel();
			labHelbidea.setBounds(new Rectangle(172, 343, 63, 16));
			labHelbidea.setText("Helbidea:");
			labIzena = new JLabel();
			labIzena.setBounds(new Rectangle(190, 311, 44, 16));
			labIzena.setText("Izena:");
			labTuristaZenb = new JLabel();
			labTuristaZenb.setText("");
			labTuristaZenb.setFont(new Font("Dialog", Font.BOLD, 14));
			labTuristaZenb.setBounds(new Rectangle(291, 398, 38, 23));
			labPlazaKop = new JLabel();
			labPlazaKop.setBounds(new Rectangle(148, 173, 31, 16));
			labPlazaKop.setText("");
			labPK = new JLabel();
			labPK.setBounds(new Rectangle(41, 173, 94, 16));
			labPK.setText("Plaza Kopurua:");
			labAukIr = new JLabel();
			labAukIr.setBounds(new Rectangle(640, 5, 133, 18));
			labAukIr.setText("Aukeratutako irteera");
			labAukeraIrteera = new JLabel();
			labAukeraIrteera.setBounds(new Rectangle(571, 23, 284, 242));
			labAukeraIrteera.setText("");
			labEzaugarriak = new JLabel();
			labEzaugarriak.setBounds(new Rectangle(13, 67, 141, 16));
			labEzaugarriak.setText("Irteeraren ezaugarriak");
			labErreserba = new JLabel();
			labErreserba.setBounds(new Rectangle(420, 5, 66, 16));
			labErreserba.setText("Erreserba");
			labBaieztapenZenb = new JLabel();
			labBaieztapenZenb.setBounds(new Rectangle(6, 257, 125, 16));
			labBaieztapenZenb.setText("Baieztapen zenbakia");
			labIrteeraData = new JLabel();
			labIrteeraData.setBounds(new Rectangle(60, 135, 72, 16));
			labIrteeraData.setText("Irteera data");
			labEzaugarriak = new JLabel();
			labEzaugarriak.setBounds(new Rectangle(5, 60, 136, 16));
			labEzaugarriak.setText("Irteeraren ezaugarriak");
			labPertsonaKop = new JLabel();
			labPertsonaKop.setBounds(new Rectangle(29, 99, 107, 16));
			labPertsonaKop.setText("Pertsona kopurua");
			edukiontziErreserba = new JPanel();
			edukiontziErreserba.setLayout(null);
			edukiontziErreserba.add(getLabAgentea(), null);
			edukiontziErreserba.add(labPertsonaKop, null);
			edukiontziErreserba.add(labEzaugarriak, null);
			edukiontziErreserba.add(labIrteeraData, null);
			edukiontziErreserba.add(labBaieztapenZenb, null);
			edukiontziErreserba.add(getCmbPertsonaKop(), null);
			edukiontziErreserba.add(getCmbAgenteak(), null);
			edukiontziErreserba.add(getCmbEzaugarriak(), null);
			edukiontziErreserba.add(getCmbDatak(), null);
			edukiontziErreserba.add(getTxtBaieztapenZenb(), null);
			edukiontziErreserba.add(getBtnErreserbaBerria(), null);
			edukiontziErreserba.add(getBtnSartuErreserba(), null);
			edukiontziErreserba.add(labErreserba, null);
			edukiontziErreserba.add(getTaErreserba(), null);
			edukiontziErreserba.add(labAukeraIrteera, null);
			edukiontziErreserba.add(labAukIr, null);
			edukiontziErreserba.add(labPK, null);
			edukiontziErreserba.add(labPlazaKop, null);
			edukiontziErreserba.add(getBtnTuristaAtzera(), null);
			edukiontziErreserba.add(getBtnSartuTurista(), null);
			edukiontziErreserba.add(getBtnEzeztatu(), null);
			edukiontziErreserba.add(getBtnBidali(), null);
			edukiontziErreserba.add(getBtnAldatu(), null);
			edukiontziErreserba.add(labIzena, null);
			edukiontziErreserba.add(labHelbidea, null);
			edukiontziErreserba.add(labTelefonoa, null);
			edukiontziErreserba.add(getTxtIzena(), null);
			edukiontziErreserba.add(getTxtHelbidea(), null);
			edukiontziErreserba.add(getTxtTelefonoa(), null);
			edukiontziErreserba.add(labTuristaZenb, null);
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
			labAgentea.setBounds(new Rectangle(27, 26, 113, 15));
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
			cmbPertsonaKop.setBounds(new Rectangle(151, 94, 53, 25));
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
			cmbAgenteak.setBounds(new Rectangle(152, 20, 154, 25));
			agenteakKargatu();
			cmbAgenteak.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if(e.getStateChange() == ItemEvent.SELECTED){
						ezaugarriakKargatu();
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
			cmbEzaugarriak.setBounds(new Rectangle(152, 58, 155, 25));
			ezaugarriakKargatu();

			cmbEzaugarriak.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if(e.getStateChange() == ItemEvent.SELECTED){
						try{
							String auk = nlInt.lortuAukeratutakoEzaugarriId(cmbEzaugarriak);
							labAukeraIrteera.setIcon(new ImageIcon(getClass().getResource("/img/"+auk+".jpg")));
							datakKargatu();
						}catch(RemoteException ex){
							ex.printStackTrace();
						}
					}
				}
			});
		}
		return cmbEzaugarriak;
	}

	/**
	 * This method initializes cmbDatak
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getCmbDatak() {
		if (cmbDatak == null) {
			cmbDatak = new JComboBox();
			cmbDatak.setBounds(new Rectangle(150, 131, 94, 25));
			cmbDatak.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if(e.getStateChange() == ItemEvent.SELECTED){
						eguneratuPlazaKop();
					}
				}
			});
			datakKargatu();
		}
		return cmbDatak;
	}

	/**
	 * This method initializes txtBaieztapenZenb
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtBaieztapenZenb() {
		if (txtBaieztapenZenb == null) {
			txtBaieztapenZenb = new JTextField();
			txtBaieztapenZenb.setBounds(new Rectangle(135, 255, 69, 20));
			txtBaieztapenZenb.setEnabled(false);
		}
		return txtBaieztapenZenb;
	}

	/**
	 * This method initializes btnErreserbaBerria
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getBtnErreserbaBerria() {
		if (btnErreserbaBerria == null) {
			btnErreserbaBerria = new JButton();
			btnErreserbaBerria.setBounds(new Rectangle(73, 199, 142, 35));
			btnErreserbaBerria.setText("Erreserba berria");
			btnErreserbaBerria.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//Aukeratutako bidairako toki libreak dauden begiratu:
					try{
						int bidaiariKop = cmbPertsonaKop.getSelectedIndex()+1;
						String data = cmbDatak.getSelectedItem().toString();
						zenb = nlInt.getErreserbaBaieztapenZenbakia(cmbAgenteak, cmbEzaugarriak, data, bidaiariKop);
						if(zenb!=null){
							taErreserba.setText("Erreserba egin dezakezu.\nBaieztapen zenbakia: "+zenb+"\n*******************************");
							baieztapenInterfazea();
						}
						else{
							taErreserba.setText("Ez dago toki libre nahikorik!\n");
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
			btnSartuErreserba.setBounds(new Rectangle(206, 253, 126, 26));
			btnSartuErreserba.setText("Sartu erreserba");
			btnSartuErreserba.setEnabled(false);
			btnSartuErreserba.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//Erabiltzaileak sartutako baieztapen zenbakia zuzena dela baieztatu:
					String sartutakoZenb = txtBaieztapenZenb.getText();
					try {
						if(nlInt.baieztapenZenbakiaKonprobatu(sartutakoZenb)){
							//Baieztapen zenbaki zuzena. Agenteak sartzeko interfazea erakutsi:
							turistakSartuInterfazea();
						}
						else{
							taErreserba.setText(taErreserba.getText()+"\nBaieztapen zenbakia okerra da!\nEzin da erreserbarik egin.");
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
		this.setSize(860, 460);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/img/hegazkina.jpg"));
		this.setResizable(false);
		this.setContentPane(getEdukiontziErreserba());
		this.setTitle(" BIDAI AGENTZIA");
		hasieratuInterfazea();

		String auk=null;
		try {
			auk = nlInt.lortuAukeratutakoEzaugarriId(cmbEzaugarriak);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		labAukeraIrteera.setIcon(new ImageIcon(getClass().getResource("/img/"+auk+".jpg")));
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
	 * This method initializes taErreserba
	 *
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getTaErreserba() {
		if (taErreserba == null) {
			taErreserba = new JTextArea();
			taErreserba.setBounds(new Rectangle(346, 23, 215, 242));
			taErreserba.setEditable(false);
			taErreserba.setLineWrap(true);
		}
		return taErreserba;
	}

	/**
	 * This method initializes btnTuristaAtzera
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getBtnTuristaAtzera() {
		if (btnTuristaAtzera == null) {
			btnTuristaAtzera = new JButton();
			btnTuristaAtzera.setBounds(new Rectangle(108, 337, 50, 27));
			btnTuristaAtzera.setFont(new Font("Dialog", Font.BOLD, 18));
			btnTuristaAtzera.setText("<");
			btnTuristaAtzera.setFocusable(false);
			btnTuristaAtzera.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					unekoPosizioa--;
					joanPosiziora();
				}
			});
		}
		return btnTuristaAtzera;
	}

	/**
	 * This method initializes btnSartuTurista
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getBtnSartuTurista() {
		if (btnSartuTurista == null) {
			btnSartuTurista = new JButton();
			btnSartuTurista.setBounds(new Rectangle(424, 339, 51, 27));
			btnSartuTurista.setFont(new Font("Dialog", Font.BOLD, 18));
			btnSartuTurista.setText(">");
			btnSartuTurista.setFocusable(false);
			btnSartuTurista.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(txtIzena.getText().equals("") || txtHelbidea.getText().equals("") || txtTelefonoa.getText().equals("")){
						JOptionPane.showMessageDialog(null,"Turistari buruzko datu guztiak bete behar dira.","Turista sartu",JOptionPane.WARNING_MESSAGE);
					}
					else{
						gehituTurista();
						unekoPosizioa++;
						joanPosiziora();
					}
				}
			});
		}
		return btnSartuTurista;
	}

	/**
	 * This method initializes btnEzeztatu
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getBtnEzeztatu() {
		if (btnEzeztatu == null) {
			btnEzeztatu = new JButton();
			btnEzeztatu.setBounds(new Rectangle(690, 336, 87, 31));
			btnEzeztatu.setText("Ezeztatu");
			btnEzeztatu.setFocusable(false);
			btnEzeztatu.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Object[] aukerak = {"Bai","Ez"};
					if(JOptionPane.showOptionDialog(null, "Erreserba ezeztatzera zoaz.\nZiur al zaude?", "Erreserbaren ezeztapena",JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null, aukerak, aukerak[0])==0){
						JOptionPane.showMessageDialog(null,"Erreserba ezeztatu da.","Erreserbaren ezeztapena",JOptionPane.PLAIN_MESSAGE);
						hasieratuInterfazea();
					}
				}
			});
		}
		return btnEzeztatu;
	}

	/**
	 * This method initializes btnBidali
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getBtnBidali() {
		if (btnBidali == null) {
			btnBidali = new JButton();
			btnBidali.setBounds(new Rectangle(532, 336, 82, 31));
			btnBidali.setText("Bidali");
			btnBidali.setFocusable(false);
			btnBidali.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//Erreserba eta Turistak datu basean sartu
					try {
						String ezaugarriId = nlInt.lortuAukeratutakoEzaugarriId(cmbEzaugarriak);
						String agenteId = nlInt.lortuAukeratutakoAgenteId(cmbAgenteak);
						String irteeraData = cmbDatak.getSelectedItem().toString();
						AplikazioNagusia.nlInt.sartuErreserba(zenb, ezaugarriId, agenteId, irteeraData);
						AplikazioNagusia.nlInt.sartuTuristak();
					} catch (RemoteException e1) {
						e1.printStackTrace();
						System.out.println("ERROREA. Erreserba egitean.");
					}
					JOptionPane.showMessageDialog(null,"Erreserbak ondo egin dira.","Erreserbaren baieztapena",JOptionPane.PLAIN_MESSAGE);
					eguneratuPlazaKop();
					hasieratuInterfazea();
				}
			});
		}
		return btnBidali;
	}

	/**
	 * This method initializes btnAldatu
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getBtnAldatu() {
		if (btnAldatu == null) {
			btnAldatu = new JButton();
			btnAldatu.setBounds(new Rectangle(613, 336, 79, 31));
			btnAldatu.setText("Aldatu");
			btnAldatu.setFocusable(false);
			btnAldatu.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					unekoPosizioa=0;
					joanPosiziora();
					turistakSartuInterfazea();
				}
			});
		}
		return btnAldatu;
	}

	/**
	 * This method initializes txtIzena
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtIzena() {
		if (txtIzena == null) {
			txtIzena = new JTextField();
			txtIzena.setBounds(new Rectangle(244, 310, 127, 20));
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
			txtHelbidea.setBounds(new Rectangle(244, 341, 171, 20));
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
			txtTelefonoa.setBounds(new Rectangle(244, 375, 83, 20));
		}
		return txtTelefonoa;
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

	private void baieztapenInterfazea(){
		//Bidaiaren erreserbari buruzko interfazea ezkutatu:
		cmbAgenteak.setEnabled(false);
		cmbEzaugarriak.setEnabled(false);
		cmbDatak.setEnabled(false);
		cmbPertsonaKop.setEnabled(false);
		btnErreserbaBerria.setEnabled(false);
		//Baieztapen zenbakia sartzeko botoia erakutsi:
		btnSartuErreserba.setEnabled(true);
		txtBaieztapenZenb.setEnabled(true);
		txtBaieztapenZenb.requestFocus();
	}

	private void turistakSartuInterfazea(){
		//Kontrolak erakutsi/ezkutatu
		//cmbAgenteak.setEnabled(false);
		//cmbEzaugarriak.setEnabled(false);
		//cmbPertsonaKop.setEnabled(false);
		//cmbDatak.setEnabled(false);
		//btnErreserbaBerria.setEnabled(false);
		txtBaieztapenZenb.setEnabled(false);
		btnSartuErreserba.setEnabled(false);
		taErreserba.setText("");

		txtIzena.setEnabled(true);
		txtHelbidea.setEnabled(true);
		txtTelefonoa.setEnabled(true);
		btnSartuTurista.setEnabled(true);
		btnBidali.setEnabled(false);
		btnAldatu.setEnabled(false);
		btnEzeztatu.setEnabled(true);
		labTuristaZenb.setText(1+"/"+cmbPertsonaKop.getSelectedItem());
		txtIzena.requestFocus();
		unekoPosizioa=0;

	}

	private void agenteakKargatu(){
		try {
			Vector<String> agenteIzenak = nlInt.kargatuAgenteak();
			cmbAgenteak.removeAllItems();
			for(int i=0;i<agenteIzenak.size();i++){
				cmbAgenteak.addItem(agenteIzenak.get(i));
			}
		}catch (RemoteException e1) {
			e1.printStackTrace();
		}
	}

	private void ezaugarriakKargatu(){
		try {
			Vector<String> ezaugarriak = nlInt.kargatuEzaugarriak(cmbAgenteak);
			cmbEzaugarriak.removeAllItems();
			for(int i=0;i<ezaugarriak.size();i++){
				cmbEzaugarriak.addItem(ezaugarriak.get(i));
			}
			String auk = nlInt.lortuAukeratutakoEzaugarriId(cmbEzaugarriak);
			labAukeraIrteera.setIcon(new ImageIcon(getClass().getResource("/img/"+auk+".jpg")));
		}catch (RemoteException e1) {
			e1.printStackTrace();
		}
	}

	private void datakKargatu(){
		try {
			Vector<String> datak = nlInt.kargatuDatak(cmbEzaugarriak, cmbAgenteak);
			cmbDatak.removeAllItems();
			for(int i=0;i<datak.size();i++){
				cmbDatak.addItem(datak.get(i));
			}
		}catch (RemoteException e1) {
			e1.printStackTrace();
		}
	}

	private void eguneratuPlazaKop(){
		try{
			String agenteId = nlInt.lortuAukeratutakoAgenteId(cmbAgenteak);
			String ezaugarriId = nlInt.lortuAukeratutakoEzaugarriId(cmbEzaugarriak);
			String data=cmbDatak.getSelectedItem().toString();
			int plazaKop = nlInt.getPlazaKop(agenteId, ezaugarriId, data);
			labPlazaKop.setText(plazaKop+"");
		}catch(RemoteException ex){
			ex.printStackTrace();
		}
	}

	private void joanPosiziora(){
		Turista t=null;
		int pertsonaKop = new Integer(cmbPertsonaKop.getSelectedItem().toString()).intValue();
		labTuristaZenb.setText((unekoPosizioa+1)+"/"+pertsonaKop);
		try {
			t = AplikazioNagusia.nlInt.lortuTurista(unekoPosizioa);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		txtIzena.setText(t.getIzena());
		txtHelbidea.setText(t.getHelbidea());
		txtTelefonoa.setText(t.getTelefonoa());
		txtIzena.requestFocus();
		if(unekoPosizioa >= pertsonaKop){
			bidaliErreserbaInterfazea();
		}
		else if(unekoPosizioa == 0){
			btnTuristaAtzera.setEnabled(false);
		}
		else btnTuristaAtzera.setEnabled(true);
	}

	private void gehituTurista(){
		try {
			AplikazioNagusia.nlInt.gehituTurista(txtIzena.getText(),txtHelbidea.getText(),txtTelefonoa.getText(),unekoPosizioa);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		taErreserba.setText(taErreserba.getText() + "***** " +
				(unekoPosizioa+1)+ ". Turista" +" *****"
				+ "\nIzena: " +txtIzena.getText() +
				"\nHelbidea: " + txtHelbidea.getText()+
				"\nTelefonoa: " + txtTelefonoa.getText()+"\n");
	}

	private void bidaliErreserbaInterfazea(){
		btnTuristaAtzera.setEnabled(false);
		btnSartuTurista.setEnabled(false);
		txtIzena.setEnabled(false);
		txtHelbidea.setEnabled(false);
		txtTelefonoa.setEnabled(false);
		labTuristaZenb.setVisible(false);
		btnBidali.setEnabled(true);
		btnEzeztatu.setEnabled(true);
		btnAldatu.setEnabled(true);
	}

	private void hasieratuInterfazea(){
		txtIzena.setEnabled(false);
		txtHelbidea.setEnabled(false);
		txtTelefonoa.setEnabled(false);
		btnTuristaAtzera.setEnabled(false);
		btnSartuTurista.setEnabled(false);
		btnBidali.setEnabled(false);
		btnAldatu.setEnabled(false);
		btnEzeztatu.setEnabled(false);
		labTuristaZenb.setText("");
		txtBaieztapenZenb.setText("");

		cmbAgenteak.setEnabled(true);
		cmbEzaugarriak.setEnabled(true);
		cmbPertsonaKop.setEnabled(true);
		cmbDatak.setEnabled(true);
		btnErreserbaBerria.setEnabled(true);
		taErreserba.setText("");
	}
}

/*Uneko frame eskutatzeko eta beste frame bat irekitzeko:
dispose();
ibilgailuaHartuUtzi.IbilgailuaHartuUtzi ibHU = new ibilgailuaHartuUtzi.IbilgailuaHartuUtzi(0);
ibHU.setVisible(true);

Dialogoak:
JOptionPane.showMessageDialog(null,"Erreserba ondo egin da.","Erreserbaren baieztapena",JOptionPane.PLAIN_MESSAGE);
JOptionPane.showOptionDialog(null, "Ziur al zaude " + matrikula +  " erreserbatu nahi duzula?", "Konfirmazioa",JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null, aukerak, aukerak[0])

*/

