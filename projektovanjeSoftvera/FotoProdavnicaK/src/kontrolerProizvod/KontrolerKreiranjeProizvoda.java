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
public class KontrolerKreiranjeProizvoda {

    public static void sacuvajProizvod(JTextField txtProizvodID, JTextField txtCena, JTextField txtNaziv1, JTextField txtKolicina, JTextField txtOpis, JComboBox<String> cbDobavljaci) {
        try {
            if (txtProizvodID.getText().isEmpty()) {
                throw new Exception("ID proizvoda nije unet!!!");
            }
            if (txtCena.getText().isEmpty()) {
                throw new Exception("Cena proizvoda nije uneta..");
            }
            if (txtNaziv1.getText().isEmpty()) {
                throw new Exception("Unesite naziv proizvoda");
            }
            if (txtKolicina.getText().isEmpty()) {
                throw new Exception("Unesite kolicunu proizvoda");
            }
            if (txtOpis.getText().isEmpty()) {
                throw new Exception("Unesite opis proizvoda");
            }
            if (cbDobavljaci.getSelectedIndex() == -1) {
                throw new Exception("Nije izabran dobavljac");
            }

            int proizvodID = Integer.parseInt(txtProizvodID.getText().trim());
            double cena = Double.parseDouble(txtCena.getText().trim());
            String naziv = txtNaziv1.getText().trim();
            int kolicina = Integer.parseInt(txtKolicina.getText().trim());
            String opis = txtOpis.getText().trim();
            Dobavljac d = (Dobavljac) cbDobavljaci.getSelectedItem();
            Proizvod p = new Proizvod(proizvodID, cena, naziv, kolicina, opis, d);

            ServerTransferObjekat sto = Sesija.getSesion().sacuvajProizvod(p);
            if (sto.getIzuzetak() != null) {
                throw sto.getIzuzetak();
            }
            JOptionPane.showMessageDialog(null, sto.getPoruka());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }

}
