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
public class KontrolerPronadjiDobavljaca {

    public static void pronadjiDobavljaca(JTextField txtDobavljacID, JTextField txtNaziv, JTextField txtPIB) {
        try {
            if (txtDobavljacID.getText().isEmpty()) {
                throw new Exception("Unesi id dobavljaca");
            }
            int id = Integer.parseInt(txtDobavljacID.getText().trim());
            Dobavljac dobavljac = new Dobavljac();
            dobavljac.setDobavljacID(id);
            System.out.println(" " + id);
            ServerTransferObjekat sto = Sesija.getSesion().pronadjiDobavljaca(dobavljac);
            if (sto.getIzuzetak() != null) {
                throw new Exception("Sistem ne moze da pronadje Dobavljaca");
            }
            Dobavljac d = (Dobavljac) sto.getPodaci();
            txtDobavljacID.setText(Integer.toString(d.getDobavljacID()));
            txtNaziv.setText(d.getNaziv());
            txtPIB.setText(Integer.toString(d.getPib()));
            JOptionPane.showMessageDialog(null, sto.getPoruka(), "Pretraga Dobavljaca", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        }

    }

}
