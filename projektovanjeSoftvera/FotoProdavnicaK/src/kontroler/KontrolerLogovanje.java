/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Radnik;
import forme.FrmGlavnaForma;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import sesija.Sesija;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Korisnik
 */
public class KontrolerLogovanje {

    public static void ulogujSe(JTextField txtUsername, JTextField txtSifra) {
        try {
            if (txtUsername.getText().isEmpty()) {
                throw new Exception("Nije unet username");
            }
            if (txtSifra.getText().isEmpty()) {
                throw new Exception("Nije uneta sifra");
            }

            String korisnik = txtUsername.getText().trim();
            String sifra = txtSifra.getText().trim();
            Radnik radnik = new Radnik();
            radnik.setKorisnickoIme(korisnik);
            radnik.setSifra(sifra);

            Sesija.getSesion().prijaviSe(radnik);
            ServerTransferObjekat sto = Sesija.getSesion().procitajObjekat();
            if (sto.getIzuzetak() != null) {
                throw sto.getIzuzetak();
            }
            Radnik rd = (Radnik) sto.getPodaci();
            String ulogovan = rd.getIme();
            JOptionPane.showMessageDialog(null, sto.getPoruka(), ulogovan, JOptionPane.INFORMATION_MESSAGE);
            Sesija.getSesion().setUlogovanRadnik(radnik);
            FrmGlavnaForma forma = new FrmGlavnaForma(rd);
            forma.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "GRESKA", JOptionPane.ERROR_MESSAGE);
        }
    }

}
