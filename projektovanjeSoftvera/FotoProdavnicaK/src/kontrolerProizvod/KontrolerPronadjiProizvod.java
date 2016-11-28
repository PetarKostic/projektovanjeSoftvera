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
public class KontrolerPronadjiProizvod {

    public static void pronadjiProizvod(JTextField txtProizvodID, JTextField txtCena, JTextField txtNaziv1, JTextField txtKolicina, JTextField txtOpis, JComboBox cbDobavljaci) {
        try {
            if (txtProizvodID.getText().isEmpty()) {
                throw new Exception("Morate da unesete ID proizvoda");
            }
            Proizvod p = new Proizvod();
            p.setProizvodID(Integer.parseInt(txtProizvodID.getText().trim()));
            ServerTransferObjekat sto = Sesija.getSesion().pronadjiProizvod(p);
            if (sto.getIzuzetak() != null) {
                throw new Exception("Nije pronadjen nijedan proizvod sa tim id-em");
            }
            Proizvod proizvod = (Proizvod) sto.getPodaci();
            txtCena.setText(Double.toString(proizvod.getCena()));
            txtNaziv1.setText(proizvod.getNaziv());
            txtKolicina.setText(Integer.toString(proizvod.getKolicina()));
            txtOpis.setText(proizvod.getOpis());
            System.out.println("dobavljac id " + proizvod.getDobavljac().getDobavljacID());
            System.out.println("dobavljac naziv " + proizvod.getDobavljac().getNaziv());
            System.out.println("dobavljac naziv " + proizvod.getDobavljac().getPib());
            cbDobavljaci.setSelectedItem(proizvod.getDobavljac());
            JOptionPane.showMessageDialog(null, sto.getPoruka());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
