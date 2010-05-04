package proiektua;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;



public class ErreserbaBistarenLaburpena extends JPanel implements Observer
{
    // Kontrolak
    private JLabel etiketaData = new JLabel("Erreserbaren Data  ");
    private JLabel etiketaAgentearenIzena = new JLabel("Erreserbaren Agentea ");
    private JLabel etiketaErreserbaZenbakia = new JLabel("Erreserbaren Zenbakia");
    private JLabel etiketaGuztira = new JLabel("Guztira         ");
    private JTextField testuEremuaData = new JTextField();
    private JTextField testuEremuaAgentearenIzena = new JTextField();
    private JTextField testuEremuaErreserbarenZenbakia = new JTextField();
    private JTextField testuEremuaGuztira = new JTextField();
    public ErreserbaBistarenLaburpena(ErreserbaSistema erreserbaSistema)
    {
        erreserbaSistema.addObserver(this);
        
        setLayout(new GridLayout(2, 4, 25, 25));
        setFont(new Font("Arial", Font.PLAIN, 12));
        setBackground(Color.lightGray);
        setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        // row 1
        add(etiketaData);
        add(testuEremuaData);
        add(etiketaAgentearenIzena);
        add(testuEremuaAgentearenIzena);
        // row 2
        add(etiketaErreserbaZenbakia);
        add(testuEremuaErreserbarenZenbakia);
        add(etiketaGuztira);
        add(testuEremuaGuztira);
        //testu eremuak irakurtzeko bakarrik aldatu
        testuEremuaData.setEditable(false);
        testuEremuaAgentearenIzena.setEditable(false);
        testuEremuaErreserbarenZenbakia.setEditable(false);
        testuEremuaGuztira.setEditable(false);
    }
    /**
     * Eguneratu Bista
     * @param observable java.util.Observable
     * @param objektua java.lang.Object
     */
    public void update(Observable observable, Object objektua)
    {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        DateFormat dataFormat = DateFormat.getDateInstance();
        ErreserbaSistema erreserbaSistema = (ErreserbaSistema) observable;
        //
        if (erreserbaSistema.getLoturaErreserba() != null)
            {
        }
        else
            {
            testuEremuaData.setText("");
            testuEremuaGuztira.setText("");
            testuEremuaAgentearenIzena.setText("");
            testuEremuaErreserbarenZenbakia.setText("");
        }
    }
}
