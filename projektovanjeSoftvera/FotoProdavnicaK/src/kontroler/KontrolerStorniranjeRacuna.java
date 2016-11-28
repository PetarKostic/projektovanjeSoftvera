/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Racun;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import sesija.Sesija;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Korisnik
 */
public class KontrolerStorniranjeRacuna {

    public static void stornirajRacun(JTextField txtRacunID) {
        try {
            if (txtRacunID.getText().isEmpty()) {
                throw new Exception("Unesite id racuna");
            }

            Racun racun = new Racun();
            int id = Integer.parseInt(txtRacunID.getText().trim());
            System.out.println(id);
            racun.setRacunID(id);
            racun.setStorniran(true);
            System.out.println(racun.isStorniran());
            ServerTransferObjekat sto = Sesija.getSesion().stornirajRacun(racun);
            if (sto.getIzuzetak() != null) {
                throw new Exception("Doslo je do greske prilikom storniranja racuna");
            }

            JOptionPane.showMessageDialog(null, sto.getPoruka());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
