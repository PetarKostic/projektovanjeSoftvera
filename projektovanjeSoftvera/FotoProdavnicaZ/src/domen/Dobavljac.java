/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Korisnik
 */
public class Dobavljac implements Serializable, OpstiDomenskiObjekat {

    private int dobavljacID;
    private String d_naziv;
    private int pib;

    public Dobavljac() {
    }

    public Dobavljac(int dobavljacID, String d_naziv, int pib) {
        this.dobavljacID = dobavljacID;
        this.d_naziv = d_naziv;
        this.pib = pib;
    }

    @Override
    public String toString() {
        return d_naziv;
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuIzResultSet(ResultSet rs) {
        List<OpstiDomenskiObjekat> dobavljaci = new ArrayList<>();
        try {
            while (rs.next()) {
                Dobavljac d = new Dobavljac();
                d.setDobavljacID(rs.getInt("dobavljacID"));
                d.setNaziv(rs.getString("d_naziv"));
                d.setPib(rs.getInt("pib"));
                dobavljaci.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dobavljac.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dobavljaci;
    }

    @Override
    public String vratiNazivTabele() {
        return " dobavljac ";
    }

    @Override
    public String vratiVrednostZaInsert() {
        return dobavljacID + ",'" + d_naziv + "'," + pib;
    }

    @Override
    public String vratiUslovZaPronadjiSlog() {
        return " dobavljacID = " + dobavljacID;
    }

    @Override
    public String vratiNazivTabeleSaJOINom() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaPronadjiSlogoveVezaneZaRoditelja() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaSortiranje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getDobavljacID() {
        return dobavljacID;
    }

    public void setDobavljacID(int dobavljacID) {
        this.dobavljacID = dobavljacID;
    }

    public String getNaziv() {
        return d_naziv;
    }

    public void setNaziv(String d_naziv) {
        this.d_naziv = d_naziv;
    }

    public int getPib() {
        return pib;
    }

    public void setPib(int pib) {
        this.pib = pib;
    }

    @Override
    public String vratiVrednostZaUpdate() {
        return " d_naziv = '" + d_naziv + "', pib=" + pib;
    }

    @Override
    public String vratiUslovZaIzmeniSlog() {
        return "dobavljacID=" + dobavljacID;
    }

    @Override
    public String vratiUslovZaStorniranje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
