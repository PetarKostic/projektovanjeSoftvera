/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontrolerDobavljac;

import domen.Dobavljac;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import sesija.Sesija;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Korisnik
 */
public class KontrolerSacuvajDobavljaca {

    public static void sacuvajDobavljaca(JTextField txtDobavljacID, JTextField txtNaziv, JTextField txtPIB) {
        try {
            if (txtDobavljacID.getText().isEmpty()) {
                throw new Exception("Unesi id dobavljaca");
            }
            if (txtNaziv.getText().isEmpty()) {
                throw new Exception("Unesi naziv dobavljaca");
            }
            if (txtPIB.getText().isEmpty()) {
                throw new Exception("Unesi PIB dobavljaca");
            }
            int id = Integer.parseInt(txtDobavljacID.getText().trim());
            String naziv = txtNaziv.getText().trim();
            int pib = Integer.parseInt(txtPIB.getText().trim());
            Dobavljac d = new Dobavljac(id, naziv, pib);
            ServerTransferObjekat sto = Sesija.getSesion().sacuvajDobavljaca(d);
            if (sto.getIzuzetak() != null) {
                throw sto.getIzuzetak();
            }
            JOptionPane.showMessageDialog(null, sto.getPoruka());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "unos dobavljaca", JOptionPane.ERROR_MESSAGE);
        }
    }

}
