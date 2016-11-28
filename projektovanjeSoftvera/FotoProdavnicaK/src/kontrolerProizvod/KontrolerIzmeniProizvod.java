/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontrolerProizvod;

import domen.Dobavljac;
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
public class KontrolerIzmeniProizvod {

    public static void promeniProizvod(JTextField txtProizvodID, JTextField txtCena, JTextField txtNaziv1, JTextField txtKolicina, JTextField txtOpis, JComboBox cbDobavljaci) {
        try {
            if (txtProizvodID.getText().isEmpty()) {
                throw new Exception("Unesite id proizvoda");
            }
            if (txtCena.getText().isEmpty()) {
                throw new Exception("Unesite cenu proizvoda");
            }
            if (txtNaziv1.getText().isEmpty()) {
                throw new Exception("Unesite naziv proizvoda");
            }

            if (txtKolicina.getText().isEmpty()) {
                throw new Exception("Unesite kolicinu proizvoda");
            }
            if (txtOpis.getText().isEmpty()) {
                throw new Exception("Unesite opis proizvoda");
            }
            if (cbDobavljaci.getSelectedIndex() == -1) {
                throw new Exception("Nije selektovan dobavljac");
            }
            int id = Integer.parseInt(txtProizvodID.getText().trim());
            double cena = Double.parseDouble(txtCena.getText().trim());
            String naziv = txtNaziv1.getText().trim();
            System.out.println(naziv);
            int kolicina = Integer.parseInt(txtKolicina.getText().trim());
            String opis = txtOpis.getText().trim();
            Dobavljac d = (Dobavljac) cbDobavljaci.getSelectedItem();
            Proizvod p = new Proizvod(id, cena, naziv, kolicina, opis, d);
            ServerTransferObjekat sto = Sesija.getSesion().izmeniProizvod(p);
            if (sto.getIzuzetak() != null) {
                sto.getIzuzetak();
            }
            JOptionPane.showMessageDialog(null, sto.getPoruka());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
