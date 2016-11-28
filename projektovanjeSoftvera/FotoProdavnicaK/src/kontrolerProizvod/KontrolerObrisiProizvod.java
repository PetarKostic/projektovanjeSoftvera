/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontrolerProizvod;

import domen.Proizvod;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import sesija.Sesija;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Korisnik
 */
public class KontrolerObrisiProizvod {

    public static void obrisiProizvod(JTextField txtProizvodID, JTextField txtCena, JTextField txtNaziv1, JTextField txtKolicina, JTextField txtOpis, JComboBox<String> cbDobavljaci) {
        try {
            if (txtProizvodID.getText().isEmpty()) {
                throw new Exception("Unesi id proizvoda");
            }
            Proizvod p = new Proizvod();
            p.setProizvodID(Integer.parseInt(txtProizvodID.getText().trim()));
            ServerTransferObjekat sto = Sesija.getSesion().obrisiProizvod(p);
            if (sto.getIzuzetak() != null) {
                throw new Exception("Sistem nije obrisao proizvod");
            }
            JOptionPane.showMessageDialog(null, sto.getPoruka());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
