/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proiektua;
/**
 *
 * @author oier
 */
public class Turista {

    //private String turistaId;
    //private String erreserbaId;
    private String izena;
    private String helbidea;
    private String telefonoa;

    public Turista(String i, String h, String t){
      izena=i;
      helbidea=h;
      telefonoa=t;
    }

    public String getHelbidea() {
        return helbidea;
    }

    public void setHelbidea(String helbidea) {
        this.helbidea = helbidea;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getTelefonoa() {
        return telefonoa;
    }

    public void setTelefonoa(String telefonoa) {
        this.telefonoa = telefonoa;
    }


}