/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.Racun;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Radnik;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Korisnik
 */
public class VratiRadnikeSO extends OpstaSistemskaOperacija {

    private List<OpstiDomenskiObjekat> listaRadnika;

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        System.out.println("Nema preduslova");
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        Radnik radnik = (Radnik) o;
        listaRadnika = DBBroker.vratiBroker().vratiSve(radnik);
    }

    public List<OpstiDomenskiObjekat> getListaRadnika() {
        return listaRadnika;
    }

    public void setListaRadnika(List<OpstiDomenskiObjekat> listaRadnika) {
        this.listaRadnika = listaRadnika;
    }

}
