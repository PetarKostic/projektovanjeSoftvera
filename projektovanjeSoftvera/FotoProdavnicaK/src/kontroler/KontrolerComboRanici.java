/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Radnik;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import sesija.Sesija;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Korisnik
 */
public class KontrolerComboRanici {

    public static void prikaziRadnike(JComboBox cbRadnik) {
        try {
            ServerTransferObjekat sto = Sesija.getSesion().vratiRadnike();
            if (sto.isSignal()) {
                cbRadnik.removeAllItems();
                List<Radnik> lista = (List<Radnik>) sto.getPodaci();
                for (Radnik r : lista) {
                    cbRadnik.addItem(r);
                }
            } else {
                JOptionPane.showMessageDialog(null, sto.getPoruka());
            }
            cbRadnik.setSelectedItem(Sesija.getSesion().getUlogovanRadnik());
            cbRadnik.setEnabled(false);
        } catch (IOException ex) {
            Logger.getLogger(KontrolerComboRanici.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KontrolerComboRanici.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
