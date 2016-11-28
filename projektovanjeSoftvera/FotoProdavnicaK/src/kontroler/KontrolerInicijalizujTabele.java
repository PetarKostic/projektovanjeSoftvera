/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Proizvod;
import domen.Racun;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import sesija.Sesija;
import table.TableModelStavke;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Korisnik
 */
public class KontrolerInicijalizujTabele {

    public static void inicijalizujTabelu(JTable tblStavkeRacuna) {
        try {
            tblStavkeRacuna.setModel(new TableModelStavke(new Racun()));
            ServerTransferObjekat sto = Sesija.getSesion().vratiProizvode();
            ArrayList<Proizvod> proizvodi = (ArrayList<Proizvod>) sto.getPodaci();
            JComboBox cbProizvodi = new JComboBox();
            cbProizvodi.setModel(new DefaultComboBoxModel(proizvodi.toArray()));
            TableColumnModel tcm = tblStavkeRacuna.getColumnModel();
            TableColumn tc = tcm.getColumn(2);
            tc.setCellEditor(new DefaultCellEditor(cbProizvodi));
        } catch (Exception e) {
        }

    }

}
