package proiektua;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.Point;

public class AplikazioNagusia extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static AplikazioNagusiEntzulea entzulea = new AplikazioNagusiEntzulea();  //  @jve:decl-index=0:
	public static AplikazioNagusiaKudInterfazea nlInt;

	private JFrame frameErreserba = null;  //  @jve:decl-index=0:visual-constraint="64,420"
	private JPanel edukiontziErreserba = null;
	private JLabel labAgentea = null;
	private JLabel labPertsonaKop = null;
	private JLabel labIrteeraData = null;
	private JLabel labBaieztapenZenb = null;
	public static JTextField txtBaieztapenZenb = null;
	public static JComboBox cmbPertsonaKop = null;
	public static JComboBox cmbAgenteak = null;
	public static JComboBox cmbEzaugarriak = null;
	public static JComboBox cmbDatak = null;
	public static JButton btnErreserbaBerria = null;
	public static JButton btnSartuErreserba = null;
	public static JLabel labErreserba = null;
	public static JTextField txtIzena = null;
	public static JTextField txtHelbidea = null;
	public static JTextField txtTelefonoa = null;
	public static JTextArea taErreserba = null;
	public static JButton btnTuristaAtzera = null;
	public static JButton btnSartuTurista = null;
	public static JButton btnEzeztatu = null;
	public static JButton btnBidali = null;
	public static JButton btnAldatu = null;
	public static JLabel labTuristaZenb = null;
	public static JLabel labAukeraIrteera = null;
	public static JLabel labPlazaKop = null;
	private JLabel labEzaugarriak = null;
	private JLabel labAukIr = null;
	private JLabel labPK = null;
	private JLabel labIzena = null;
	private JLabel labHelbidea = null;
	private JLabel labTelefonoa = null;
	private JScrollPane scroll = null;
	private TuristenBista turObserver;
	private ErreserbarenBista erresObserver;


	/**
	 * This method initializes frameErreserba
	 *
	 * @return javax.swing.JFrame
	 */
	private JFrame getFrameErreserba() {
		if (frameErreserba == null) {
			frameErreserba = new JFrame();
			frameErreserba.setSize(new Dimension(875, 467));
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
			labPlazaKop.setBounds(new Rectangle(151, 170, 31, 16));
			labPlazaKop.setText("");
			labPK = new JLabel();
			labPK.setBounds(new Rectangle(40, 170, 94, 16));
			labPK.setText("Plaza Kopurua:");
			labAukIr = new JLabel();
			labAukIr.setBounds(new Rectangle(611, 5, 188, 18));
			labAukIr.setText("Aukeratutako tokiaren argazkia");
			labAukeraIrteera = new JLabel();
			labAukeraIrteera.setText("");
			labAukeraIrteera.setSize(new Dimension(260, 230));
			labAukeraIrteera.setLocation(new Point(571, 25));
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
			edukiontziErreserba.add(getScroll(), null);
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
			cmbAgenteak.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if(e.getStateChange() == ItemEvent.SELECTED){
						entzulea.aukeratuAgentea();
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

			cmbEzaugarriak.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if(e.getStateChange() == ItemEvent.SELECTED){
						entzulea.aukeratuEzaugarria();
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
						entzulea.aukeratuData();
					}
				}
			});
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
			txtBaieztapenZenb.setBounds(new Rectangle(135, 255, 63, 20));
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
			btnErreserbaBerria.setBounds(new Rectangle(85, 197, 131, 35));
			btnErreserbaBerria.setText("  BERRIA");
			btnErreserbaBerria.setIcon(new ImageIcon(getClass().getResource("/img/erres_berria.png")));
			btnErreserbaBerria.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnErreserbaBerria.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//Aukeratutako bidairako toki libreak dauden begiratu:
					entzulea.erreserbaBerria();
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
			btnSartuErreserba.setBounds(new Rectangle(202, 250, 114, 32));
			btnSartuErreserba.setText(" SARTU");
			btnSartuErreserba.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnSartuErreserba.setIcon(new ImageIcon(getClass().getResource("/img/sartu.gif")));
			btnSartuErreserba.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//Erabiltzaileak sartutako baieztapen zenbakia zuzena dela baieztatu:
					String zenb = txtBaieztapenZenb.getText();
					try {
						if(nlInt.baieztapenZenbakiaKonprobatu(zenb)){
							//Baieztapen zenbaki zuzena. Agenteak sartzeko interfazea erakutsi:
							entzulea.sartuErreserba();
							String agenteId=null;
							String ezaugarriId=null;
							String data=null;
							int pertsonaKop=0;
							try{
								agenteId=nlInt.lortuAukeratutakoAgenteId(cmbAgenteak);
								ezaugarriId=nlInt.lortuAukeratutakoEzaugarriId(cmbEzaugarriak);
								data=cmbDatak.getSelectedItem().toString();
								pertsonaKop=cmbPertsonaKop.getSelectedIndex()+1;
							}catch(Exception ex){
								ex.printStackTrace();
							}
							turObserver = new TuristenBista(agenteId,ezaugarriId,data,zenb,pertsonaKop);
							entzulea.addObserver(turObserver);
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
		this.setResizable(false);
		this.setContentPane(getEdukiontziErreserba());
		this.setTitle("BIDAIEN ERRESERBA SISTEMA");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/hegazkina.jpg")));
		erresObserver = new ErreserbarenBista();
		entzulea.addObserver(erresObserver);
		entzulea.hasiInterfazeNagusia();

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
			taErreserba.setEditable(false);
			taErreserba.setLocation(new Point(340, 25));
			taErreserba.setSize(new Dimension(220, 230));
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
			btnTuristaAtzera.setBounds(new Rectangle(113, 330, 43, 38));
			btnTuristaAtzera.setFont(new Font("Dialog", Font.BOLD, 18));
			btnTuristaAtzera.setText("");
			btnTuristaAtzera.setIcon(new ImageIcon(getClass().getResource("/img/back.png")));
			btnTuristaAtzera.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnTuristaAtzera.setFocusable(false);
			btnTuristaAtzera.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					entzulea.aurrekoTuristaraJoan();
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
			btnSartuTurista.setBounds(new Rectangle(424, 334, 44, 39));
			btnSartuTurista.setFont(new Font("Dialog", Font.BOLD, 18));
			btnSartuTurista.setText("");
			btnSartuTurista.setIcon(new ImageIcon(getClass().getResource("/img/next.png")));
			btnSartuTurista.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnSartuTurista.setFocusable(false);
			btnSartuTurista.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(txtIzena.getText().equals("") || txtHelbidea.getText().equals("") || txtTelefonoa.getText().equals("")){
						JOptionPane.showMessageDialog(null,"Turistari buruzko datu guztiak bete behar dira.","Turista sartu",JOptionPane.WARNING_MESSAGE);
					}
					try{
					    Integer.parseInt(txtTelefonoa.getText().toString());
						entzulea.hurrengoTuristaraJoan();
					}catch(NumberFormatException ex){
						JOptionPane.showMessageDialog(null,"Kontuz! Turistaren telefonoak zenbakiak soilik izan ditzake.","Turista sartu",JOptionPane.WARNING_MESSAGE);
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
			btnEzeztatu.setBounds(new Rectangle(693, 311, 149, 47));
			btnEzeztatu.setText("  EZEZTATU");
			btnEzeztatu.setIcon(new ImageIcon(getClass().getResource("/img/no.png")));
			btnEzeztatu.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnEzeztatu.setFocusable(false);
			btnEzeztatu.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Object[] aukerak = {"Bai","Ez"};
					if(JOptionPane.showOptionDialog(null, "Erreserba ezeztatzera zoaz.\nZiur al zaude?", "Erreserbaren ezeztapena",JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null, aukerak, aukerak[0])==0){
						entzulea.ezeztatuErreserba();
						entzulea.hasiInterfazeNagusia();
						entzulea.deleteObserver(turObserver);
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
			btnBidali.setBounds(new Rectangle(529, 311, 145, 47));
			btnBidali.setText("  BIDALI");
			btnBidali.setIcon(new ImageIcon(getClass().getResource("/img/ok.png")));
			btnBidali.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnBidali.setFocusable(false);
			btnBidali.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					entzulea.bidaliErreserba();
					entzulea.hasiInterfazeNagusia();
					entzulea.deleteObserver(turObserver);
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
			btnAldatu.setBounds(new Rectangle(614, 369, 137, 46));
			btnAldatu.setText("  ALDATU");
			btnAldatu.setIcon(new ImageIcon(getClass().getResource("/img/aldatu.png")));
			btnAldatu.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnAldatu.setFocusable(false);
			btnAldatu.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					entzulea.aldatuErreserba();
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
	 * This method initializes scroll
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getScroll() {
		if (scroll == null) {
			scroll = new JScrollPane(taErreserba);
			scroll.setBounds(new Rectangle(342, 23, 219, 256));
		}
		return scroll;
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
}

