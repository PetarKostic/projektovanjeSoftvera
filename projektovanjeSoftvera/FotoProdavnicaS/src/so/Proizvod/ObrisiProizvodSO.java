/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.Proizvod;

import db.DBBroker;
import domen.Proizvod;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Korisnik
 */
public class ObrisiProizvodSO extends OpstaSistemskaOperacija {

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        System.out.println("Nema preduslova");
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        Proizvod p = (Proizvod) o;
        DBBroker.vratiBroker().obrisi(p);
    }

}
