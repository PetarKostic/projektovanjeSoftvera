/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.Proizvod;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Proizvod;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Korisnik
 */
public class VratiProizvodeSO extends OpstaSistemskaOperacija {

    private List<OpstiDomenskiObjekat> listaProizvoda;

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        System.out.println("Nema preduslova");
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        Proizvod p = (Proizvod) o;
        listaProizvoda = DBBroker.vratiBroker().vratiSve(p);
    }

    public List<OpstiDomenskiObjekat> getListaProizvoda() {
        return listaProizvoda;
    }

    public void setListaProizvoda(List<OpstiDomenskiObjekat> listaProizvoda) {
        this.listaProizvoda = listaProizvoda;
    }

}
