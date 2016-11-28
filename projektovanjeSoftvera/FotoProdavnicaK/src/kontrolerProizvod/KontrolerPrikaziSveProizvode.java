/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontrolerProizvod;

import domen.OpstiDomenskiObjekat;
import domen.Proizvod;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import sesija.Sesija;
import table.TableModelProizvodi;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Korisnik
 */
public class KontrolerPrikaziSveProizvode {

    public static void prikaziProizvode(JTable tblSviProizvodi) {
        try {
            ServerTransferObjekat sto = Sesija.getSesion().vratiProizvode();
            if (sto.getIzuzetak() != null) {
                throw new Exception("Nisu vraceni proizvodi");
            }
            JOptionPane.showMessageDialog(null, sto.getPoruka());
            ArrayList<Proizvod> listaProizvoda = (ArrayList<Proizvod>) sto.getPodaci();
            tblSviProizvodi.setModel(new TableModelProizvodi(listaProizvoda));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
