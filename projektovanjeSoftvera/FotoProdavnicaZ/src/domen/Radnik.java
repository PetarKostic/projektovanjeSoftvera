/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class Radnik implements Serializable, OpstiDomenskiObjekat {

    private int radnikID;
    private String korisnickoIme;
    private String ime;
    private String sifra;
    private int jmbg;

    public Radnik() {
    }

    public Radnik(int radnikID, String korisnickoIme, String ime, String sifra, int jmbg) {
        this.radnikID = radnikID;
        this.korisnickoIme = korisnickoIme;
        this.ime = ime;
        this.sifra = sifra;
        this.jmbg = jmbg;
    }

    public int getJmbg() {
        return jmbg;
    }

    public void setJmbg(int jmbg) {
        this.jmbg = jmbg;
    }

    public int getRadnikID() {
        return radnikID;
    }

    public void setRadnikID(int radnikID) {
        this.radnikID = radnikID;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    @Override
    public String toString() {
        return ime;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Radnik radnik = (Radnik) obj;
        if (this.radnikID != radnik.radnikID) {
            return false;
        }
        return true;
    }

    public String vratiNazivTabele() {
        return "radnik";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.radnikID;
        return hash;
    }

    @Override
    //posto smo implementirali interfejs OpstiDomenskiObjekat moramo da implementiramo sve njegove metode,jer su mu sve metode abstract
    //prosledjujemo mu kao parametar ResultSet koji sadrzi sve podatke iz baze podataka
    //na ovaj nacin komuniciramo odavde sa bazom podataka
    public List<OpstiDomenskiObjekat> vratiListuIzResultSet(ResultSet rs) {
        //pravimo praznu listu OpstiDomenskiObjekat i smestamo sve radnike u nju
        List<OpstiDomenskiObjekat> radnici = new ArrayList<>();

        try {
            while (rs.next()) {
                Radnik r = new Radnik();
                r.setRadnikID(rs.getInt("radnikID"));
                r.setJmbg(rs.getInt("jmbg"));
                r.setKorisnickoIme(rs.getString("korisnickoIme"));
                r.setIme(rs.getString("ime"));
                r.setSifra(rs.getString("sifra"));
                radnici.add(r);
            }
        } catch (Exception e) {
        }
        return radnici;
    }

    @Override
    public String vratiVrednostZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaPronadjiSlog() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    @Override
    public String vratiVrednostZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaIzmeniSlog() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaStorniranje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
