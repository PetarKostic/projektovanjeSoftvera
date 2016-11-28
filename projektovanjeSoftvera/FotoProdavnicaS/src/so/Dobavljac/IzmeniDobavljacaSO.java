/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.Dobavljac;

import db.DBBroker;
import domen.Dobavljac;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Korisnik
 */
public class IzmeniDobavljacaSO extends OpstaSistemskaOperacija {

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        System.out.println("Nema uslova");
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        Dobavljac d = (Dobavljac) o;
        DBBroker.vratiBroker().izmeni(d);
    }

}
