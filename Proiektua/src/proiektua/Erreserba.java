package proiektua;
/**
 *
 * @author Administrador
 */
public class Erreserba {
    //private String erreserbaId;
    //private String irteeraId;
    //private String agenteId;
    private String baieztapenZenbakia;
    private int turistaKop;
    //private Vector turistaZerrenda;

    public Erreserba(String baiZenb, int turKop){
        this.baieztapenZenbakia=baiZenb;
        this.turistaKop=turKop;
    }

    public String getBaieztapenZenbakia() {
        return baieztapenZenbakia;
    }

    public void setBaieztapenZenbakia(String baieztapenZenbakia) {
        this.baieztapenZenbakia = baieztapenZenbakia;
    }

    public int getTuristaKop() {
        return turistaKop;
    }

    public void setTuristaKop(int turistaKop) {
        this.turistaKop = turistaKop;
    }
    
}
