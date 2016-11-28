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
public class KontrolerIzmeniDobavljac {

    public static void izmeniDobavljaca(JTextField txtDobavljacID, JTextField txtNaziv, JTextField txtPIB) {
        try {
            if (txtDobavljacID.getText().isEmpty()) {
                throw new Exception("Unesi ID dobavljaca");
            }
            if (txtNaziv.getText().isEmpty()) {
                throw new Exception("Unesi naziv dobavljaca");
            }
            if (txtPIB.getText().isEmpty()) {
                throw new Exception("Unesi pib dobavljaca");
            }
            Dobavljac d = new Dobavljac();
            d.setDobavljacID(Integer.parseInt(txtDobavljacID.getText().trim()));
            d.setNaziv(txtNaziv.getText().trim());
            d.setPib(Integer.parseInt(txtPIB.getText().trim()));
            ServerTransferObjekat sto = Sesija.getSesion().izmeniDobavljaca(d);
            if (sto.getIzuzetak() != null) {
                throw new Exception("Sistem nije zapamtio promene o dobavljacau");
            }
            JOptionPane.showMessageDialog(null, "Dobavljac uspesno updejtovan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
