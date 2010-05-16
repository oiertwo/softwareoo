package proiektua;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class AplikazioNagusiaTuristak extends JFrame{

	private JFrame turistakSartuFrame = null;  //  @jve:decl-index=0:visual-constraint="145,13"
	private JPanel turistakSartuEdukiontzia = null;
	private JLabel labIzena = null;
	private JLabel labHelbidea = null;
	private JLabel labTelefonoa = null;
	private JTextField txtIzena = null;
	private JTextField txtHelbidea = null;
	private JTextField txtTelefonoa = null;
	private JTextArea taErreserba = null;
	private JLabel labErreserba = null;
	private JLabel labTuristakSartu = null;
	private JButton btnSartuTurista = null;
	private JLabel labTuristaZenb = null;
	private JButton btnTuristaAtzera = null;
	private JButton btnBidali = null;
	private JButton btnEzeztatu = null;

	private int unekoPosizioa;

	private String zenb;
	private String ezaugarriId;
	private String agenteId;
	private String irteeraData;
	private int pertsonaKop;
	private JButton btnAldatu = null;

	public AplikazioNagusiaTuristak(String z, String ezaugId, String agId, String data, int perKop){
		super();
		initialize();
		zenb=z;
		ezaugarriId=ezaugId;
		agenteId=agId;
		irteeraData=data;
		pertsonaKop=perKop;
		unekoPosizioa=0;
		turistaSartuErreserbaInterfazea();
		txtIzena.requestFocus();
	}

	private void initialize() {
		this.setSize(550, 324);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/img/turista.png"));
		this.setResizable(false);
		this.setContentPane(getTuristakSartuEdukiontzia());
		this.setTitle(" TURISTEN DATUEN SARRERA");
		this.setLocationRelativeTo(null);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				hasieratuInterfazea();
			}
		});
	}

	/**
	 * This method initializes turistakSartuFrame
	 *
	 * @return javax.swing.JFrame
	 */
	private JFrame getTuristakSartuFrame() {
		if (turistakSartuFrame == null) {
			turistakSartuFrame = new JFrame();
			turistakSartuFrame.setSize(new Dimension(519, 296));
			turistakSartuFrame.setTitle("Turistak sartu");
			turistakSartuFrame.setContentPane(getTuristakSartuEdukiontzia());
		}
		return turistakSartuFrame;
	}

	/**
	 * This method initializes turistakSartuEdukiontzia
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getTuristakSartuEdukiontzia() {
		if (turistakSartuEdukiontzia == null) {
			labTuristaZenb = new JLabel();
			labTuristaZenb.setBounds(new Rectangle(109, 174, 46, 23));
			labTuristaZenb.setHorizontalTextPosition(SwingConstants.LEADING);
			labTuristaZenb.setHorizontalAlignment(SwingConstants.CENTER);
			labTuristaZenb.setText("");
			labTuristakSartu = new JLabel();
			labTuristakSartu.setBounds(new Rectangle(25, 8, 249, 27));
			labTuristakSartu.setFont(new Font("Dialog", Font.BOLD, 18));
			labTuristakSartu.setText("TURISTEN DATUAK SARTU");
			labErreserba = new JLabel();
			labErreserba.setBounds(new Rectangle(360, 7, 62, 16));
			labErreserba.setText("Erreserba");
			labTelefonoa = new JLabel();
			labTelefonoa.setBounds(new Rectangle(16, 133, 68, 16));
			labTelefonoa.setText("Telefonoa");
			labHelbidea = new JLabel();
			labHelbidea.setBounds(new Rectangle(18, 93, 59, 16));
			labHelbidea.setText("Helbidea");
			labIzena = new JLabel();
			labIzena.setBounds(new Rectangle(18, 53, 41, 16));
			labIzena.setText("Izena");
			turistakSartuEdukiontzia = new JPanel();
			turistakSartuEdukiontzia.setLayout(null);
			turistakSartuEdukiontzia.add(labIzena, null);
			turistakSartuEdukiontzia.add(labHelbidea, null);
			turistakSartuEdukiontzia.add(labTelefonoa, null);
			turistakSartuEdukiontzia.add(getTxtIzena(), null);
			turistakSartuEdukiontzia.add(getTxtHelbidea(), null);
			turistakSartuEdukiontzia.add(getTxtTelefonoa(), null);
			turistakSartuEdukiontzia.add(getTaErreserba(), null);
			turistakSartuEdukiontzia.add(labErreserba, null);
			turistakSartuEdukiontzia.add(labTuristakSartu, null);
			turistakSartuEdukiontzia.add(getBtnSartuTurista(), null);
			turistakSartuEdukiontzia.add(labTuristaZenb, null);
			turistakSartuEdukiontzia.add(getBtnTuristaAtzera(), null);
			turistakSartuEdukiontzia.add(getBtnBidali(), null);
			turistakSartuEdukiontzia.add(getBtnEzeztatu(), null);
			turistakSartuEdukiontzia.add(getBtnAldatu(), null);
		}
		return turistakSartuEdukiontzia;
	}

	/**
	 * This method initializes txtIzena
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtIzena() {
		if (txtIzena == null) {
			txtIzena = new JTextField();
			txtIzena.setBounds(new Rectangle(104, 51, 128, 20));
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
			txtHelbidea.setBounds(new Rectangle(103, 90, 167, 20));
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
			txtTelefonoa.setBounds(new Rectangle(103, 131, 96, 20));
		}
		return txtTelefonoa;
	}

	/**
	 * This method initializes taErreserba
	 *
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getTaErreserba() {
		if (taErreserba == null) {
			taErreserba = new JTextArea();
			taErreserba.setBounds(new Rectangle(297, 26, 192, 219));
			taErreserba.setEditable(false);
		}
		return taErreserba;
	}

	/**
	 * This method initializes btnSartuTurista
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getBtnSartuTurista() {
		if (btnSartuTurista == null) {
			btnSartuTurista = new JButton();
			btnSartuTurista.setBounds(new Rectangle(154, 174, 63, 23));
			btnSartuTurista.setFont(new Font("Dialog", Font.BOLD, 24));
			btnSartuTurista.setText(">");
			btnSartuTurista.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(txtIzena.getText().equals("") || txtHelbidea.getText().equals("") || txtTelefonoa.getText().equals("")){
						JOptionPane.showMessageDialog(null,"Turistari buruzko datu guztiak bete behar dira.","Turista sartu",JOptionPane.WARNING_MESSAGE);
					}
					else{
						gehituTurista(unekoPosizioa);
						unekoPosizioa++;
						joanPosiziora(unekoPosizioa);
					}
				}
			});
		}
		return btnSartuTurista;
	}

	/**
	 * This method initializes btnTuristaAtzera
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getBtnTuristaAtzera() {
		if (btnTuristaAtzera == null) {
			btnTuristaAtzera = new JButton();
			btnTuristaAtzera.setBounds(new Rectangle(47, 174, 62, 23));
			btnTuristaAtzera.setFont(new Font("Dialog", Font.BOLD, 24));
			btnTuristaAtzera.setText("<");
			btnTuristaAtzera.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//gehituTurista(unekoPosizioa);
					unekoPosizioa--;
					joanPosiziora(unekoPosizioa);
				}
			});
		}
		return btnTuristaAtzera;
	}

	/**
	 * This method initializes btnBidali
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getBtnBidali() {
		if (btnBidali == null) {
			btnBidali = new JButton();
			btnBidali.setBounds(new Rectangle(47, 196, 85, 27));
			btnBidali.setText("Bidali");
			btnBidali.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//Erreserba eta Turistak datu basean sartu
					try {
						AplikazioNagusia.nlInt.sartuErreserba(zenb, ezaugarriId, agenteId, irteeraData);
						AplikazioNagusia.nlInt.sartuTuristak();
					} catch (RemoteException e1) {
						e1.printStackTrace();
						System.out.println("ERROREA. Erreserba egitean.");
					}
					JOptionPane.showMessageDialog(null,"Erreserbak ondo egin dira.","Erreserbaren baieztapena",JOptionPane.PLAIN_MESSAGE);
					hasieratuInterfazea();
				}
			});
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
			btnEzeztatu.setBounds(new Rectangle(132, 196, 85, 27));
			btnEzeztatu.setText("Ezeztatu");
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
	 * This method initializes btnAldatu
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getBtnAldatu() {
		if (btnAldatu == null) {
			btnAldatu = new JButton();
			btnAldatu.setBounds(new Rectangle(67, 222, 129, 29));
			btnAldatu.setText("Erreserba aldatu");
			btnAldatu.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					unekoPosizioa=0;
					joanPosiziora(0);
					turistaSartuErreserbaInterfazea();
				}
			});
		}
		return btnAldatu;
	}

	private void hasieratuInterfazea(){
		try {
			AplikazioNagusia.nlInt.ezabatuTuristak();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		dispose();
		AplikazioNagusia aplikNagusi = new AplikazioNagusia();
		aplikNagusi.setVisible(true);
	}

	private void turistaSartuErreserbaInterfazea(){
		txtIzena.setEnabled(true);
		txtHelbidea.setEnabled(true);
		txtTelefonoa.setEnabled(true);
		labTuristaZenb.setVisible(true);
		labTuristaZenb.setText((unekoPosizioa+1)+"/"+pertsonaKop);
		btnTuristaAtzera.setEnabled(false);
		btnSartuTurista.setEnabled(true);
		btnBidali.setEnabled(false);
		btnEzeztatu.setEnabled(false);
		btnAldatu.setEnabled(false);
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

	private void gehituTurista(int pos){
		try {
			AplikazioNagusia.nlInt.gehituTurista(txtIzena.getText(),txtHelbidea.getText(),txtTelefonoa.getText(),pos);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		taErreserba.setText(taErreserba.getText() + "***** " +
				(unekoPosizioa+1)+ ". Turista" +" *****"
				+ "\nIzena: " +txtIzena.getText() +
				"\nHelbidea: " + txtHelbidea.getText()+
				"\nTelefonoa: " + txtTelefonoa.getText()+"\n");
	}

	private void joanPosiziora(int pos){
		Turista t=null;
		labTuristaZenb.setText((pos+1)+"/"+pertsonaKop);
		try {
			t = AplikazioNagusia.nlInt.lortuTurista(pos);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		txtIzena.setText(t.getIzena());
		txtHelbidea.setText(t.getHelbidea());
		txtTelefonoa.setText(t.getTelefonoa());
		if(pos >= pertsonaKop){
			bidaliErreserbaInterfazea();
		}
		else if(unekoPosizioa == 0){
			btnTuristaAtzera.setEnabled(false);
		}
		else btnTuristaAtzera.setEnabled(true);
	}

}  //  @jve:decl-index=0:visual-constraint="10,490"
