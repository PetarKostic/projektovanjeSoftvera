/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Dobavljac;
import domen.OpstiDomenskiObjekat;
import domen.Proizvod;
import domen.Racun;
import domen.Radnik;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import konstante.Konstante;
import kontroler.Kontroler;
import transfer.KlijentTransferObjekat;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Korisnik
 */
public class NitObradaKlijenta extends Thread {

    Socket soket;
    ObjectInputStream inSocket;
    ObjectOutputStream outSocket;

    NitObradaKlijenta(Socket soket) throws IOException {
        this.soket = soket;
        inSocket = new ObjectInputStream(soket.getInputStream());
        outSocket = new ObjectOutputStream(soket.getOutputStream());
    }

    @Override
    public void run() {

        try {
            while (true) {
                Object objekat = inSocket.readObject();
                KlijentTransferObjekat kto = (KlijentTransferObjekat) objekat;
                int operacija = kto.getOperacija();
                ServerTransferObjekat sto = new ServerTransferObjekat();

                switch (operacija) {
                    case Konstante.PRIJAVI_SE:
                        try {
                            Radnik ulogovan = null;
                            Radnik radnik = (Radnik) kto.getPodaci();
                            //ako metoda prijaviSe vrati null,znaci da u bazi ne postoji radnik sa tim podacima,
                            //ako se inicijalizuje objekat ,onda ce da se vrati taj radnik i ulogovan nece imati null vrednost
                            ulogovan = Kontroler.getInstance().prijaviSe(radnik);
                            if (ulogovan == null) {
                                sto.setIzuzetak(new Exception("Trazeni radnik ne postoji u bazi"));
                            }
                            sto.setPodaci(ulogovan);
                            sto.setPoruka("Uspesno logovanje");
                        } catch (Exception e) {
                            sto.setIzuzetak(e);
                        }
                        break;

                    case Konstante.VRATI_RADNIKE:
                        try {
                            List<OpstiDomenskiObjekat> radnici = Kontroler.getInstance().vratiRadnike();
                            sto.setSignal(true);
                            sto.setPodaci(radnici);
                        } catch (Exception e) {
                            sto.setSignal(false);
                            sto.setPoruka("Radnici nisu vraceni");
                        }
                        break;

                    case Konstante.SACUVAJ_RACUN:
                        try {
                            Object racun = kto.getPodaci();
                            Kontroler.getInstance().sacuvajRacun((Racun) racun);
                            sto.setSignal(true);
                            sto.setPoruka("Racun je uspesno sacuvan");
                        } catch (Exception e) {
                            sto.setIzuzetak(new Exception("Racun nije sacuvan"));
                        }
                        break;
                    case Konstante.PRONADJI_RACUN:
                        try {
                            Racun racun = (Racun) kto.getPodaci();
                            System.out.println(racun.getRacunID());
                            Racun r = Kontroler.getInstance().pronadjiRacun(racun);
                            if (r == null) {
                                sto.setIzuzetak(new Exception("Trazeni racun nije pronadjen"));
                            }
                            sto.setSignal(true);
                            sto.setPodaci(r);
                            sto.setPoruka("Uspesno vracen racun");

                        } catch (Exception e) {
                            sto.setIzuzetak(e);
                        }
                        break;

                    case Konstante.SACUVAJ_PROIZVOD:
                        try {
                            Proizvod p = (Proizvod) kto.getPodaci();
                            System.out.println(p.getNaziv());
                            Kontroler.getInstance().sacuvajProizvod(p);
                            sto.setSignal(true);
                            sto.setPoruka("Proizvod je uspesno sacuvan");
                        } catch (Exception e) {
                            sto.setIzuzetak(new Exception("Proizvod nije sacuvan"));
                        }
                        break;

                    case Konstante.VRATI_DOBAVLJACE:
                        try {
                            List<OpstiDomenskiObjekat> dobavljaci = Kontroler.getInstance().vratiDobavljace();
                            sto.setSignal(true);
                            sto.setPodaci(dobavljaci);
                        } catch (Exception e) {
                            sto.setIzuzetak(new Exception("Nisu vraceni dobavljaci"));
                        }
                        break;
                    case Konstante.SACUVAJ_DOBAVLJACA:
                        try {
                            Dobavljac d = (Dobavljac) kto.getPodaci();
                            Kontroler.getInstance().sacuvajDobavljaca(d);
                            sto.setSignal(true);
                            sto.setPoruka("Uspesno ubacen dobavljac");
                        } catch (Exception e) {
                            sto.setIzuzetak(new Exception("Doslos je do greske pri cuvanju dobavljaca"));
                        }
                        break;
                    case Konstante.PRONADJI_DOBAVLJACA:
                        try {
                            Dobavljac d = (Dobavljac) kto.getPodaci();
                            Dobavljac dob = Kontroler.getInstance().pronadjiDobavljaca(d);
                            System.out.println(dob.getNaziv());
                            sto.setPodaci(dob);
                            sto.setSignal(true);
                            sto.setPoruka("Dobavljac uspesno pronadjen");
                        } catch (Exception e) {
                            sto.setIzuzetak(new Exception("Sistem ne moze da pronadje dobavljaca"));
                        }
                        break;

                    case Konstante.UPDATE_DOBAVLJACA:
                        try {
                            Dobavljac d = (Dobavljac) kto.getPodaci();
                            Kontroler.getInstance().izmeniDobavljaca(d);
                            sto.setSignal(true);
                            sto.setPoruka("Uspesno uradjen update");
                        } catch (Exception e) {
                            sto.setIzuzetak(new Exception("Greska pri update"));
                        }
                        break;

                    case Konstante.PRONADJI_PROIZVOD:
                        try {
                            Proizvod p = (Proizvod) kto.getPodaci();
                            Proizvod pro = Kontroler.getInstance().pronadjiProizvod(p);
                            System.out.println(pro.getNaziv());
                            sto.setPoruka("Sistem je uspesno vrati zenljeni proizvod");
                            sto.setSignal(true);
                            sto.setPodaci(pro);
                        } catch (Exception e) {
                            sto.setIzuzetak(e);
                        }
                        break;
                    case Konstante.IZMENI_PROIZVOD:
                        try {
                            Proizvod p = (Proizvod) kto.getPodaci();
                            Kontroler.getInstance().izmeniProizvod(p);
                            sto.setSignal(true);
                            sto.setPoruka("Uspesno izmenjen proizvod");
                        } catch (Exception e) {
                            sto.setIzuzetak(new Exception("Proizvod nije izmenjen"));
                        }
                        break;
                    case Konstante.OBRISI_PROIZVOD:
                        try {
                            Proizvod p = (Proizvod) kto.getPodaci();
                            Kontroler.getInstance().obrisiProizvod(p);
                            sto.setSignal(true);
                            sto.setPoruka("Proizvod uspesno obrisan");
                        } catch (Exception e) {
                            sto.setIzuzetak(e);
                        }
                        break;
                    case Konstante.VRATI_PROIZVOD:
                        try {
                            List<OpstiDomenskiObjekat> proizvodi = Kontroler.getInstance().vratiProizvode();
                            sto.setPodaci(proizvodi);
                            sto.setPoruka("Uspesno vraceni proizvodi");

                        } catch (Exception e) {
                            sto.setIzuzetak(e);
                        }
                        break;

                    case Konstante.STORNIRANJE_RACUNA:
                        try {
                            Racun racun = (Racun) kto.getPodaci();
                            System.out.println(racun.getRacunID());
                            Kontroler.getInstance().stornirajRacun(racun);
                            sto.setPoruka("Uspesno storniranje racuna");
                        } catch (Exception e) {
                            sto.setIzuzetak(new Exception("Greska prilikom storniranje izuzetka"));
                        }
                        break;
                    case Konstante.VRATI_BROJAC:
                        try {
                            sto.setPodaci(Kontroler.getInstance().getBrojac());
                        } catch (Exception e) {
                        }
                }
                outSocket.writeObject(sto);
            }
        } catch (Exception e) {
        }
    }

}
