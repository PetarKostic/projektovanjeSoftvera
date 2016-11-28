/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import domen.Racun;
import domen.Radnik;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import sesija.Sesija;
import table.TableModelStavke;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Korisnik
 */
public class KontrolerSacuvajRacunaj {

    public static void sacuvajRacun(JTextField txtRacunID, JTextField txtDatum, JComboBox<Object> cbRadnik, JTable tblStavkeRacuna) {
        try {
            if (txtRacunID.getText().isEmpty()) {
                throw new Exception("Racun nije unet");
            }
            if (txtDatum.getText().isEmpty()) {
                throw new Exception("Datum nije unet");
            }
            if (cbRadnik.getSelectedIndex() == -1) {
                throw new Exception("Nije prijavljen radnik koji unosi racun!");
            }
            Racun racun = ((TableModelStavke) tblStavkeRacuna.getModel()).vratiRacun();
            racun.setRacunID(Integer.parseInt(txtRacunID.getText()));
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date datum = sdf.parse(txtDatum.getText());
            racun.setDatum(datum);
            Radnik radnik = (Radnik) cbRadnik.getSelectedItem();
            racun.setRadnik(radnik);
            racun.setStorniran(false);

            ServerTransferObjekat sto = Sesija.getSesion().sacuvajRacun(racun);
            if (sto.getIzuzetak() != null) {
                throw sto.getIzuzetak();
            }
            JOptionPane.showMessageDialog(null, "Racun je uspesno sacuvan");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Greska pri cuvanju racuna");
        }
    }

}
