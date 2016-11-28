/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.Racun;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Racun;
import domen.Radnik;
import domen.StavkaRacuna;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author Korisnik
 */
public class PronadjiRacunSO extends OpstaSistemskaOperacija {

    private Racun racun;

    @Override
    protected void proveriPreduslov(Object o) throws Exception {
        System.out.println("Neme preduslova");
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object o) throws Exception {
        List<OpstiDomenskiObjekat> listaRacuna = DBBroker.vratiBroker().vratiDecuRoditelja((Racun) o);
        if (listaRacuna.size() > 0) {
//            Racun r = (Racun) listaRacuna.get(0);
//            StavkaRacuna stavka = new StavkaRacuna();
//            stavka.setRacun(racun);
//            r.setListaStavki(DBBroker.vratiBroker().vratiDecuRoditelja(stavka));
//            List<OpstiDomenskiObjekat> stavke = r.getListaStavki();
//            racun = r;

            racun = (Racun) listaRacuna.get(0);
        }
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

}
