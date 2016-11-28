/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontrolerDobavljac;

import domen.Dobavljac;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import sesija.Sesija;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Korisnik
 */
public class KontrolerVratiDobavljace {

    public static void vratiDobavljace(JComboBox cbDobavljaci) {
        try {
            ServerTransferObjekat sto = Sesija.getSesion().vratiDobavljace();
            List<Dobavljac> dobavljaci = (List<Dobavljac>) sto.getPodaci();
            cbDobavljaci.removeAllItems();
            for (Dobavljac d : dobavljaci) {
                cbDobavljaci.addItem(d);
            }
        } catch (IOException ex) {
            Logger.getLogger(KontrolerVratiDobavljace.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KontrolerVratiDobavljace.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
