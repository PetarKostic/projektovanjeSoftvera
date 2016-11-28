/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesija;

import domen.Dobavljac;
import domen.Proizvod;
import domen.Racun;
import domen.Radnik;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Konstante;
import transfer.KlijentTransferObjekat;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Korisnik
 */
public class Sesija {

    private static Sesija sesija;
    private Socket soket;
    private ObjectInputStream inSocket;
    private ObjectOutputStream outSocket;
    private Radnik ulogovanRadnik;

    public static Sesija getSesion() {
        if (sesija == null) {
            sesija = new Sesija();
        }
        return sesija;
    }

    public Sesija() {
        try {
            soket = new Socket("localhost", 9000);
            outSocket = new ObjectOutputStream(soket.getOutputStream());
            inSocket = new ObjectInputStream(soket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Sesija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Socket getSoket() {
        return soket;
    }

    public void setSoket(Socket soket) {
        this.soket = soket;
    }

    public Radnik getUlogovanRadnik() {
        return ulogovanRadnik;
    }

    public void setUlogovanRadnik(Radnik ulogovanRadnik) {
        this.ulogovanRadnik = ulogovanRadnik;
    }

    public void posaljiObjekat(KlijentTransferObjekat kto) throws IOException {
        outSocket.writeObject(kto);
    }

    public ServerTransferObjekat procitajObjekat() throws IOException, ClassNotFoundException {
        return (ServerTransferObjekat) inSocket.readObject();
    }

    public void prijaviSe(Radnik radnik) throws IOException {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(Konstante.PRIJAVI_SE);
        kto.setPodaci(radnik);
        posaljiObjekat(kto);
    }

    public ServerTransferObjekat vratiRadnike() throws IOException, ClassNotFoundException {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(Konstante.VRATI_RADNIKE);
        outSocket.writeObject(kto);
        ServerTransferObjekat sto = (ServerTransferObjekat) inSocket.readObject();
        return sto;
    }

    public ServerTransferObjekat sacuvajRacun(Racun racun) throws Exception {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(Konstante.SACUVAJ_RACUN);
        kto.setPodaci(racun);
        outSocket.writeObject(kto);
        ServerTransferObjekat sto = (ServerTransferObjekat) inSocket.readObject();
        return sto;
    }

    public ServerTransferObjekat pronadjiRacun(Racun r) throws IOException, ClassNotFoundException {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(Konstante.PRONADJI_RACUN);
        kto.setPodaci(r);
        posaljiObjekat(kto);
        return procitajObjekat();
    }

    public ServerTransferObjekat sacuvajProizvod(Proizvod p) throws IOException, ClassNotFoundException {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(Konstante.SACUVAJ_PROIZVOD);
        kto.setPodaci(p);
        posaljiObjekat(kto);

        return procitajObjekat();
    }

    public ServerTransferObjekat vratiDobavljace() throws IOException, ClassNotFoundException {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(Konstante.VRATI_DOBAVLJACE);
        posaljiObjekat(kto);
        return procitajObjekat();
    }

    public ServerTransferObjekat sacuvajDobavljaca(Dobavljac d) throws IOException, ClassNotFoundException {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(Konstante.SACUVAJ_DOBAVLJACA);
        kto.setPodaci(d);
        posaljiObjekat(kto);
        return procitajObjekat();
    }

    public ServerTransferObjekat pronadjiDobavljaca(Dobavljac dobavljac) throws IOException, ClassNotFoundException {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(Konstante.PRONADJI_DOBAVLJACA);
        kto.setPodaci(dobavljac);
        posaljiObjekat(kto);
        return procitajObjekat();
    }

    public ServerTransferObjekat izmeniDobavljaca(Dobavljac d) throws IOException, ClassNotFoundException {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(Konstante.UPDATE_DOBAVLJACA);
        kto.setPodaci(d);
        posaljiObjekat(kto);
        return procitajObjekat();
    }

    public ServerTransferObjekat pronadjiProizvod(Proizvod p) throws IOException, ClassNotFoundException {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(Konstante.PRONADJI_PROIZVOD);
        kto.setPodaci(p);
        posaljiObjekat(kto);
        return procitajObjekat();
    }

    public ServerTransferObjekat izmeniProizvod(Proizvod p) throws IOException, ClassNotFoundException {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(Konstante.IZMENI_PROIZVOD);
        kto.setPodaci(p);
        posaljiObjekat(kto);
        return procitajObjekat();
    }

    public ServerTransferObjekat obrisiProizvod(Proizvod p) throws IOException, ClassNotFoundException {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(Konstante.OBRISI_PROIZVOD);
        kto.setPodaci(p);
        posaljiObjekat(kto);
        return procitajObjekat();
    }

    public ServerTransferObjekat vratiProizvode() throws IOException, ClassNotFoundException {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(Konstante.VRATI_PROIZVOD);
        posaljiObjekat(kto);
        return procitajObjekat();
    }

    public ServerTransferObjekat stornirajRacun(Racun racun) throws IOException, ClassNotFoundException {
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(Konstante.STORNIRANJE_RACUNA);
        kto.setPodaci(racun);
        posaljiObjekat(kto);
        return procitajObjekat();
    }

    public ServerTransferObjekat vratiBrojac() throws IOException, ClassNotFoundException {
       KlijentTransferObjekat kto = new KlijentTransferObjekat();
       kto.setOperacija(Konstante.VRATI_BROJAC);
        posaljiObjekat(kto);
        return procitajObjekat();
    }

}
