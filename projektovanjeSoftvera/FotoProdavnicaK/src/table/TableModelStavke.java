/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import domen.Proizvod;
import domen.Racun;
import domen.StavkaRacuna;
import java.text.SimpleDateFormat;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class TableModelStavke extends AbstractTableModel {

    Racun racun;
    String[] columnNames = new String[]{"Rb", "Kolicina", "Proizvod"};
    SimpleDateFormat sdf;

    public TableModelStavke(Racun racun) {
        this.racun = racun;
        sdf = new SimpleDateFormat("dd.MM.yyyy");
    }

    @Override
    public int getRowCount() {
        return racun.getListaStavki().size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaRacuna stavka = (StavkaRacuna) racun.getListaStavki().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return stavka.getRbStavke();
            case 1:
                return stavka.getKolicina();
            case 2:
                return stavka.getProizvod();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        StavkaRacuna stavka = (StavkaRacuna) racun.getListaStavki().get(rowIndex);
        switch (columnIndex) {
            case 0:
                stavka.setRbStavke(Integer.parseInt(String.valueOf(aValue)));
                racun.izracunajUkupno();
                break;
            case 1:
                stavka.setKolicina(Integer.parseInt(String.valueOf(aValue)));
                racun.izracunajUkupno();
                break;
            case 2:
                stavka.setProizvod((Proizvod) aValue);
                fireTableDataChanged();
                racun.izracunajUkupno();
                break;

        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public void dodajStavku() {
        racun.dodajStavku();
        fireTableDataChanged();
    }

    public void obrisiStavku(int red) {
        racun.obrisiStavku(red);
        fireTableRowsDeleted(red, red);
    }

    public Racun vratiRacun() {
        return racun;
    }

    public void postaviRacun(Racun r) {
        racun = r;
        fireTableDataChanged();
    }

}
