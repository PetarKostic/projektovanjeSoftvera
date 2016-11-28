/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.Prijavljivanje;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Radnik;
import java.util.ArrayList;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Korisnik
 */
//ovde nasledjujemo apstraktu klasu OpstaSistemskaOperacija i moramo da implementiramo sve abstract metode
public class PrijaviSeSO extends OpstaSistemskaOperacija {

    Radnik radnik;

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        System.out.println("Nema preduslova");
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        //ovde smo kroz parametar metode izvrsiKonkretnuOperaciju prosledili objekat radnik
        Radnik rd = (Radnik) o;
        //ovde pozivamo metodu iz DBBroker , koja zbog toga sto smo joj prosledili objekat radni
        //vraca listu radnika,tj listu opsti domenskih objekata u ovom slucaju radnici
        List<OpstiDomenskiObjekat> radnici = DBBroker.vratiBroker().vratiSve(rd);
        for (int i = 0; i < radnici.size(); i++) {
            //ovde kastujemo opstidomenski objekat u objekat klase Radnik
            Radnik r = (Radnik) radnici.get(i);
            if (r.getKorisnickoIme().equals(rd.getKorisnickoIme()) && r.getSifra().equals(rd.getSifra())) {
                //setujemo globalnu promenjivu radnik,u ovom slucaju objekat, na vrednost koju smo uzeli iz baze
                radnik = (Radnik) radnici.get(i);
            }
        }
    }

    //vraca objekat setovanog radnika,ako radnik nije setovan ,vratice null
    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

}
