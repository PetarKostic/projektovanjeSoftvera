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
public class PronadjiDobavljacaSO extends OpstaSistemskaOperacija {

    Dobavljac dob;

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        System.out.println("Nema preduslova");
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        Dobavljac d = (Dobavljac) o;
        List<OpstiDomenskiObjekat> listaDobavljaca = DBBroker.vratiBroker().pronadji(d);
        if (listaDobavljaca.size() > 0) {
            dob = (Dobavljac) listaDobavljaca.get(0);
        }

    }

    public Dobavljac getDob() {
        return dob;
    }

    public void setDob(Dobavljac dob) {
        this.dob = dob;
    }

}
