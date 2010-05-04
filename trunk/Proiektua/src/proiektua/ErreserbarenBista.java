
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

/**
 * Aplikazioaren lehen mailaren(Bista) klasea
 */

public class ErreserbarenBista extends JPanel implements Observer
{
    // Kontrolak
    private DefaultListModel itenak; // new DefaultListModel();
    private JList lista; // new JList(itenak);
    // private JTextArea  area = new JTextArea();

    public ErreserbarenBista(ErreserbaSistema erreserbaSistema)
    {
        erreserbaSistema.addObserver(this);
        //
        itenak = new DefaultListModel();
        lista = new JList(itenak);
        lista.setVisibleRowCount(24);
        this.add(new JScrollPane(lista));
    }

    /**
     * Eguneratu bista.
     * @param observable java.util.Observable
     * @param objektua java.lang.Object
     */

    public void update(Observable observable, Object objektua)
    {
        itenak.clear();
        //
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        DateFormat dataFormat = DateFormat.getDateInstance();
        ErreserbaSistema erreserbaSistema = (ErreserbaSistema) observable;


    }
}
