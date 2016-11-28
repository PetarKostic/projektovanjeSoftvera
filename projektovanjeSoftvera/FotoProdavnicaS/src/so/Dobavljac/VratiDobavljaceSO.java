/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.Dobavljac;

import db.DBBroker;
import domen.Dobavljac;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Korisnik
 */
public class VratiDobavljaceSO extends OpstaSistemskaOperacija {

    private List<OpstiDomenskiObjekat> dobavljaci;
    Dobavljac d;

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        System.out.println("Nema preduslova");
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        d = (Dobavljac) o;
        dobavljaci = DBBroker.vratiBroker().vratiSve(d);
    }

    public List<OpstiDomenskiObjekat> getDobavljaci() {
        return dobavljaci;
    }

    public void setDobavljaci(List<OpstiDomenskiObjekat> dobavljaci) {
        this.dobavljaci = dobavljaci;
    }

}
