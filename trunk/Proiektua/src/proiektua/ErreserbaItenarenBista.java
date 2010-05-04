package proiektua;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

/**
 * Lehen mailarekin(Bista)lan egiten duen klasea. 
 */

public class ErreserbaItenarenBista extends JPanel implements Observer
{
    // Kontrolak
    private JLabel etiketaKopurua = new JLabel("Kopurua     ");
    private JLabel etiketaDeskripzioa = new JLabel("Deskribapena ");
    private JLabel etiketaPrezioa = new JLabel("Prezioa       ");
    private JLabel etiketaLuzapena = new JLabel("Luzapena   ");
    //
    private JTextField testuEremuaKopurua = new JTextField("1");
    private JTextField textFieldDeskribapena = new JTextField();
    private JTextField testuEremuaPrezioa = new JTextField();
    private JTextField testuEremuaLuzapena = new JTextField();
    public ErreserbaItenarenBista(ErreserbaSistema erreserbaSistema)
    {
        //  
        erreserbaSistema.addObserver(this);
        
        setLayout(new GridLayout(1, 5, 25, 25));
        setFont(new Font("Arial", Font.PLAIN, 12));
        setBackground(Color.lightGray);
        setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        // row 1
        add(testuEremuaKopurua);
        add(new JLabel("@       "));
        add(testuEremuaPrezioa);
        add(textFieldDeskribapena);
        add(testuEremuaLuzapena);
        //testu eremuak irakurtzeko bakarrik aldatu
        testuEremuaKopurua.setEditable(false);
        textFieldDeskribapena.setEditable(false);
        testuEremuaPrezioa.setEditable(false);
        testuEremuaLuzapena.setEditable(false);
    }
    /**
     * Bista eguneratzen
     * @param observable java.util.Observable
     * @param objektua java.lang.Object
     */


    public void update(Observable observable, Object objektua)
    {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        // Sarrera
        ErreserbaSistema erreserbaSistema = (ErreserbaSistema) observable;
        // Prozesua
        if (erreserbaSistema.getLoturaErreserba() != null)
            {
        }
        else
            {
            testuEremuaKopurua.setText("");
            textFieldDeskribapena.setText("");
            testuEremuaPrezioa.setText("");
            testuEremuaLuzapena.setText("");
        }
    }
}
