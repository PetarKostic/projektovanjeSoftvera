/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import domen.OpstiDomenskiObjekat;
import domen.Proizvod;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class TableModelProizvodi extends AbstractTableModel {

    List<Proizvod> listaProizvoda;
    String[] columNames = {"cena", "naziv", "kolicina", "opis"};

    @Override
    public String getColumnName(int column) {
        return columNames[column];
    }

    public TableModelProizvodi(List<Proizvod> listaProizvoda) {
        this.listaProizvoda = listaProizvoda;
    }

    @Override
    public int getRowCount() {
        return listaProizvoda.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Proizvod p = listaProizvoda.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getCena();
            case 1:
                return p.getNaziv();
            case 2:
                return p.getKolicina();
            case 3:
                return p.getOpis();
            default:
                return null;
        }
    }

}
