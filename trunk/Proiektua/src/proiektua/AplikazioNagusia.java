
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import java.awt.Container;
import java.awt.BorderLayout;

class AplikazioNagusia extends JFrame
{
    /**
    * Aplikazio nagusiaren hasierako klasea
    * ======================================
    */
    private ErreserbaSistema LoturaErreserbaSistema;
    public AplikazioNagusia(String izenburuBat)
    {
        // Eraikitzaileen edukiontzia
        Container contentPane = super.getContentPane();
        setTitle(izenburuBat);
        setSize(700, 600);
        setDefaultCloseOperation(3);
        //Ereduak sortu
        LoturaErreserbaSistema = new ErreserbaSistema();
        //Bistak sortu
        ErreserbaKontroladorea erreserbaKontroladorea = new ErreserbaKontroladorea(LoturaErreserbaSistema);
        ErreserbaBistarenLaburpena erreserbarenBistaSummary =
            new ErreserbaBistarenLaburpena(LoturaErreserbaSistema);
        ErreserbaItenarenBista erreserbaItenarenBista = new ErreserbaItenarenBista(LoturaErreserbaSistema);
        ErreserbarenBista erreserbarenBista = new ErreserbarenBista(LoturaErreserbaSistema);
        //Border erako osagaiak sortu
        erreserbaKontroladorea.setBorder(
            BorderFactory.createTitledBorder("Erreserba Eskaerak"));
        erreserbarenBistaSummary.setBorder(
            BorderFactory.createTitledBorder("Erreserbaren Laburpena"));
        erreserbaItenarenBista.setBorder(
            BorderFactory.createTitledBorder("Azken irteeraren laburpena"));
        erreserbarenBista.setBorder(BorderFactory.createTitledBorder("Erreserba"));
        //
        // Eraiki bista
        contentPane.setLayout(new BorderLayout());
        //contentPane.add(erreserbarenBistaSummary, BorderLayout.NORTH);
        contentPane.add(erreserbaKontroladorea, BorderLayout.CENTER);
        contentPane.add(erreserbarenBista, BorderLayout.EAST);
        //contentPane.add(erreserbaItenarenBista, BorderLayout.SOUTH);
        
        show();
    }
    public static void main(String[] args)
    {
        new AplikazioNagusia("Erreserba Sistema");
    }
}