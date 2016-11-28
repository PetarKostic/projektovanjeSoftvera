/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.Racun;

import db.DBBroker;
import domen.Racun;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Korisnik
 */
public class StorniranjeRacunaSO extends OpstaSistemskaOperacija {

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        System.out.println("Nema preduslova");
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        Racun racun = (Racun) o;
        System.out.println(racun.getRacunID());
        System.out.println(racun.isStorniran());
        DBBroker.vratiBroker().storniranjeRacuna(racun);
    }

}
