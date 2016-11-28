/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Racun;
import java.text.SimpleDateFormat;
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
public class KontrolerPronadjiRacun {

    public static void pronadjiRacun(JTextField txtRacunID, JTextField txtDatum, JComboBox<Object> cbRadnik, JTable tblStavkeRacuna, JTextField txtIznosRacuna) {
        try {
            if (txtRacunID.getText().isEmpty()) {
                throw new Exception("ID racuna nije unet");
            }
            Racun r = new Racun();
            r.setRacunID(Integer.parseInt(txtRacunID.getText()));
            System.out.println(r.getRacunID());
            ServerTransferObjekat sto = Sesija.getSesion().pronadjiRacun(r);
            Racun pronadjeniRacun = (Racun) sto.getPodaci();
            if (sto.getIzuzetak() != null) {
                throw new Exception("Server transfer objekat vraca null");
            }

            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date datum = pronadjeniRacun.getDatum();
            txtDatum.setText(datum.toString());
            txtIznosRacuna.setText(Double.toString(pronadjeniRacun.getIznos()));
            System.out.println(pronadjeniRacun.getRadnik());

            ((TableModelStavke) tblStavkeRacuna.getModel()).postaviRacun(r);

            JOptionPane.showConfirmDialog(null, sto.getPoruka());
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage(), "greska", JOptionPane.ERROR_MESSAGE);
        }
    }

}
