/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class Proizvod implements Serializable, OpstiDomenskiObjekat {

    private int proizvodID;
    private double cena;
    private String naziv;
    private int kolicina;
    private String opis;
    private Dobavljac dobavljac;

    public Proizvod() {
    }

    public Proizvod(int proizvodID, double cena, String naziv, int kolicina, String opis, Dobavljac dobavljac) {
        this.proizvodID = proizvodID;
        this.cena = cena;
        this.naziv = naziv;
        this.kolicina = kolicina;
        this.opis = opis;
        this.dobavljac = dobavljac;
    }

    @Override
    public String vratiNazivTabele() {
        return "proizvod";
    }

    public int getProizvodID() {
        return proizvodID;
    }

    public void setProizvodID(int proizvodID) {
        this.proizvodID = proizvodID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Dobavljac getDobavljac() {
        return dobavljac;
    }

    public void setDobavljac(Dobavljac dobavljac) {
        this.dobavljac = dobavljac;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Proizvod pro = (Proizvod) obj;
        if (this.proizvodID != pro.proizvodID) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.proizvodID;
        return hash;
    }

    @Override
    public String vratiVrednostZaInsert() {
        return proizvodID + ", " + cena + ", '" + naziv + "', " + kolicina + ", '" + opis + "', " + dobavljac.getDobavljacID();
    }

    @Override
    public String vratiUslovZaPronadjiSlog() {
        return "proizvodID=" + proizvodID;
    }

    @Override
    public String vratiNazivTabeleSaJOINom() {
        return "proizvod join dobavljac using(dobavljacID)";
    }

    @Override
    public String vratiUslovZaPronadjiSlogoveVezaneZaRoditelja() {
        return "proizvodID=" + proizvodID;
    }

    @Override
    public String vratiUslovZaSortiranje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostZaUpdate() {
        return "cena= " + cena + ", naziv='" + naziv + "', kolicina=" + kolicina + ", opis='" + opis + "', dobavljacID=" + dobavljac.getDobavljacID();
    }

    @Override
    public String vratiUslovZaIzmeniSlog() {
        return "proizvodID=" + proizvodID;
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuIzResultSet(ResultSet rs) {
        List<OpstiDomenskiObjekat> proizvodi = new ArrayList<>();
        try {
            while (rs.next()) {
                Dobavljac d = new Dobavljac();
                d.setDobavljacID(rs.getInt("dobavljacID"));
//                d.setNaziv(rs.getString("d_naziv"));
//                d.setPib(rs.getInt("pib"));
//               

                Proizvod p = new Proizvod();
                p.setProizvodID(rs.getInt("proizvodID"));
                p.setCena(rs.getDouble("cena"));
                p.setNaziv(rs.getString("naziv"));
                p.setKolicina(rs.getInt("kolicina"));
                p.setOpis(rs.getString("opis"));
                p.setDobavljac(d);

                proizvodi.add(p);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return proizvodi;
    }

    @Override
    public String vratiUslovZaStorniranje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
