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
import java.util.Date;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class Racun implements Serializable, OpstiDomenskiObjekat {

    private int racunID;
    private Date datum;
    private double iznos;
    private Radnik radnik;
    private List<OpstiDomenskiObjekat> listaStavki;
    private boolean storniran;

    public Racun() {
        listaStavki = new ArrayList<OpstiDomenskiObjekat>();
    }

    public Racun(int racunID, Date datum, double iznos, List<OpstiDomenskiObjekat> listaStavki, boolean storniran) {
        this.racunID = racunID;
        this.datum = datum;
        this.iznos = iznos;
        this.listaStavki = listaStavki;
        this.storniran = storniran;
    }

    public int getRacunID() {
        return racunID;
    }

    public void setRacunID(int racunID) {
        this.racunID = racunID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public List<OpstiDomenskiObjekat> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(List<OpstiDomenskiObjekat> listaStavki) {
        this.listaStavki = listaStavki;
    }

    public boolean isStorniran() {
        return storniran;
    }

    public void setStorniran(boolean storniran) {
        this.storniran = storniran;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuIzResultSet(ResultSet rs) {
        List<OpstiDomenskiObjekat> racuni = new ArrayList<>();
        try {
            while (rs.next()) {
                Radnik radnik = new Radnik();
                radnik.setRadnikID(rs.getInt("radnikID"));
                radnik.setKorisnickoIme(rs.getString("korisnickoIme"));
                radnik.setIme(rs.getString("ime"));
                radnik.setSifra(rs.getString("sifra"));
                radnik.setJmbg(rs.getInt("jmbg"));
                Racun r = new Racun();
                r.setRacunID(rs.getInt("racunID"));
                r.setDatum(rs.getDate("datum"));
                r.setIznos(rs.getDouble("iznos"));
                racuni.add(r);

            }
        } catch (Exception e) {
        }
        return racuni;
    }

    @Override
    public String vratiNazivTabele() {
        return " racun ";
    }

    public void dodajStavku() {
        StavkaRacuna stavka = new StavkaRacuna(this, 0, 0, new Proizvod());
        listaStavki.add(stavka);
    }

//     public void dodajStavku() {
//        int i;
//        if (listaStavki.isEmpty()) {
//            int rb = listaStavki.size() + 1; //rb ce biti 1
//            StavkaRacuna stavka = new StavkaRacuna(this, rb, 0, new Proizvod());
//            listaStavki.add(stavka);
//        } else {
//            for (i = 0; i < listaStavki.size() - 1;) {
//                i++;
//            }
//            StavkaRacuna st = (StavkaRacuna) listaStavki.get(i);
//            int stavkaID = st.getRbStavke();
//            StavkaRacuna stavka = new StavkaRacuna(this, stavkaID + 1, 0, new Proizvod());
//            listaStavki.add(st);
//
//        }
//    }
    public void obrisiStavku(int red) {
        listaStavki.remove(red);
        izracunajUkupno();
    }

    public void izracunajUkupno() {
        iznos = 0.0;
        for (int i = 0; i < listaStavki.size(); i++) {
            StavkaRacuna s = (StavkaRacuna) listaStavki.get(i);
            iznos += s.getKolicina() * s.getProizvod().getCena();
        }
    }

    @Override
    public String vratiVrednostZaInsert() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return racunID + ",'" + sdf.format(datum) + "', " + iznos + ", " + radnik.getRadnikID() + ", " + storniran;
    }

    @Override
    public String vratiUslovZaPronadjiSlog() {
        return "racunID = " + racunID;
    }

    @Override
    public String vratiNazivTabeleSaJOINom() {
        return "racun join radnik using(radnikID)";
    }

    @Override
    public String vratiUslovZaPronadjiSlogoveVezaneZaRoditelja() {
        return "racunID= " + racunID;
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
        return "racunID=" + racunID;
    }

    @Override
    public String vratiUslovZaStorniranje() {
        return "storniran = " + storniran;
    }

}
