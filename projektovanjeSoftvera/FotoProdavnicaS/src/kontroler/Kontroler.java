/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import db.DBBroker;
import domen.Dobavljac;
import domen.OpstiDomenskiObjekat;
import domen.Proizvod;
import domen.Racun;
import domen.Radnik;
import java.util.List;
import so.Dobavljac.IzmeniDobavljacaSO;
import so.Dobavljac.PronadjiDobavljacaSO;
import so.Dobavljac.SacuvajDobavljacaSO;
import so.Dobavljac.VratiDobavljaceSO;
import so.OpstaSistemskaOperacija;
import so.Prijavljivanje.PrijaviSeSO;
import so.Proizvod.IzmeniProizvodSO;
import so.Proizvod.ObrisiProizvodSO;
import so.Proizvod.PronadjiProizvodSO;
import so.Proizvod.SacuvajProizvodSo;
import so.Proizvod.VratiProizvodeSO;
import so.Racun.PronadjiRacunSO;
import so.Racun.SacuvajRacunSO;
import so.Racun.StorniranjeRacunaSO;
import so.Racun.VratiRadnikeSO;

/**
 *
 * @author Korisnik
 */
public class Kontroler {

    private DBBroker db;
    private static Kontroler instance;
    private int brojac = OpstaSistemskaOperacija.brojac;
    
    public Kontroler() {
        db = new DBBroker();
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public Radnik prijaviSe(Radnik radnik) throws Exception {
        //pravimo objekat sistemske operacije za prijavljivanje
        PrijaviSeSO rd = new PrijaviSeSO();
        //pozivamo metodu izvrsiOperaciju ,to je metoda klase OpstaSistemskaOperacija
        //i prosledjujemo joj objekat radnik
        rd.izvrsiOperaciju(radnik);
        brojac++;
//        System.out.println(rd.getRadnik()); //ova metoda bi ispisala pera,zbog metode toString() u klasi radnik
        //vraca null ako objekat nije setovan u klasi PrijaviSeSO , a ako jeste ,tj ako postoji u bazi vraca bas tog radnika
        return rd.getRadnik();
    }

    public List<OpstiDomenskiObjekat> vratiRadnike() throws Exception {
        VratiRadnikeSO vr = new VratiRadnikeSO();
        vr.izvrsiOperaciju(new Radnik());
        return vr.getListaRadnika();
    }

    public void sacuvajRacun(Racun racun) throws Exception {
        SacuvajRacunSO sr = new SacuvajRacunSO();
        sr.izvrsiOperaciju(racun);
        brojac++;
    }

    public Racun pronadjiRacun(Racun racun) throws Exception {
        PronadjiRacunSO pr = new PronadjiRacunSO();
        pr.izvrsiOperaciju(racun);
        brojac++;
        return pr.getRacun();

    }

    public void sacuvajProizvod(Proizvod p) throws Exception {
        SacuvajProizvodSo sp = new SacuvajProizvodSo();
        sp.izvrsiOperaciju(p);
        brojac++;
    }

    public List<OpstiDomenskiObjekat> vratiDobavljace() throws Exception {
        VratiDobavljaceSO vd = new VratiDobavljaceSO();
        vd.izvrsiOperaciju(new Dobavljac());
        brojac++;
        return vd.getDobavljaci();
    }

    public void sacuvajDobavljaca(Dobavljac d) throws Exception {
        SacuvajDobavljacaSO sd = new SacuvajDobavljacaSO();
        sd.izvrsiOperaciju(d);
        brojac++;
    }

    public Dobavljac pronadjiDobavljaca(Dobavljac d) throws Exception {
        PronadjiDobavljacaSO pd = new PronadjiDobavljacaSO();
        pd.izvrsiOperaciju(d);
        brojac++;
        return pd.getDob();
    }

    public void izmeniDobavljaca(Dobavljac d) throws Exception {
        IzmeniDobavljacaSO id = new IzmeniDobavljacaSO();
        id.izvrsiOperaciju(d);
        brojac++;
    }

    public Proizvod pronadjiProizvod(Proizvod p) throws Exception {
        PronadjiProizvodSO pp = new PronadjiProizvodSO();
        pp.izvrsiOperaciju(p);
        brojac++;
        return pp.getP();
    }

    public void izmeniProizvod(Proizvod p) throws Exception {
        IzmeniProizvodSO ip = new IzmeniProizvodSO();
        ip.izvrsiOperaciju(p);
        brojac++;
    }

    public void obrisiProizvod(Proizvod p) throws Exception {
        ObrisiProizvodSO op = new ObrisiProizvodSO();
        op.izvrsiOperaciju(p);
        brojac++;
    }

    public List<OpstiDomenskiObjekat> vratiProizvode() throws Exception {
        VratiProizvodeSO vp = new VratiProizvodeSO();
        vp.izvrsiOperaciju(new Proizvod());
        brojac++;
        return vp.getListaProizvoda();

    }

    public void stornirajRacun(Racun racun) throws Exception {
        StorniranjeRacunaSO sr = new StorniranjeRacunaSO();
        sr.izvrsiOperaciju(racun);
        brojac++;
    }

    public int getBrojac() {
        return brojac;
    }

    public void setBrojac(int brojac) {
        this.brojac = brojac;
    }

}
