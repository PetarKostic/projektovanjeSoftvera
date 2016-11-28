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
public class PronadjiProizvodSO extends OpstaSistemskaOperacija {

    Proizvod p;

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        System.out.println("Nema preduslova");
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        Proizvod pro = (Proizvod) o;
        List<OpstiDomenskiObjekat> proizvodi = DBBroker.vratiBroker().vratiDecuRoditelja(pro);
        if (proizvodi.size() > 0) {
            p = (Proizvod) proizvodi.get(0);
        }

    }

    public Proizvod getP() {
        return p;
    }

    public void setP(Proizvod p) {
        this.p = p;
    }

}
