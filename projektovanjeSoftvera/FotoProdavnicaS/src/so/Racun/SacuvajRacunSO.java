/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.Racun;

import db.DBBroker;
import domen.Racun;
import domen.Radnik;
import domen.StavkaRacuna;
import java.util.Iterator;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Korisnik
 */
public class SacuvajRacunSO extends OpstaSistemskaOperacija {

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        System.out.println("Nema preduslova");
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        Racun r = (Racun) o;
        DBBroker.vratiBroker().sacuvaj(r);
        for (Iterator it = r.getListaStavki().iterator(); it.hasNext();) {
            StavkaRacuna stavka = (StavkaRacuna) it.next();
            DBBroker.vratiBroker().sacuvaj(stavka);
        }
    }

}
