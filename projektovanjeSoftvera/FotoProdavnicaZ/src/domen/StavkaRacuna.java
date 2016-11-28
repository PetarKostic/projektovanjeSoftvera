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
public class StavkaRacuna implements Serializable, OpstiDomenskiObjekat {

    private Racun racun;
    private int rbStavke;
    private int kolicina;
    private Proizvod proizvod;

    public StavkaRacuna() {
    }

    public StavkaRacuna(Racun racun, int rbStavke, int kolicina, Proizvod proizvod) {
        this.racun = racun;
        this.rbStavke = rbStavke;
        this.kolicina = kolicina;
        this.proizvod = proizvod;
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    public int getRbStavke() {
        return rbStavke;
    }

    public void setRbStavke(int rbStavke) {
        this.rbStavke = rbStavke;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuIzResultSet(ResultSet rs) {
        List<OpstiDomenskiObjekat> listaStavki = new ArrayList<>();
        try {
            while (rs.next()) {
                Racun r = new Racun();
                r.setRacunID(rs.getInt("racunID"));
                Proizvod p = new Proizvod();
                p.setProizvodID(rs.getInt("proizvodID"));
                p.setNaziv(rs.getString("naziv"));
                p.setCena(rs.getDouble("cena"));
                p.setOpis(rs.getString("opis"));
                StavkaRacuna st = new StavkaRacuna();
                st.setRacun(r);
                st.setRbStavke(rs.getInt("rbStavke"));
                st.setKolicina(rs.getInt("kolicina"));
                st.setProizvod(p);
                listaStavki.add(r);
            }
        } catch (Exception e) {
        }
        return listaStavki;
    }

    @Override
    public String vratiNazivTabele() {
        return "stavkaRacuna";
    }

    @Override
    public String vratiVrednostZaInsert() {
        return racun.getRacunID() + ", " + rbStavke + "," + kolicina + "," + proizvod.getProizvodID();
    }

    @Override
    public String vratiUslovZaPronadjiSlog() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiNazivTabeleSaJOINom() {
        return "proizvod join (racun join stavkaRacuna using(racunID)) using (proizvodID)";
    }

    @Override
    public String vratiUslovZaPronadjiSlogoveVezaneZaRoditelja() {
        return "stavkaRacuna.racunID=" + racun.getRacunID();
    }

    @Override
    public String vratiUslovZaSortiranje() {
        return "stavkaRacuna.rbStavke";
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
