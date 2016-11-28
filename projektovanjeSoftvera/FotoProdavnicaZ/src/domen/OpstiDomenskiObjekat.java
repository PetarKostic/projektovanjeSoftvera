/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public interface OpstiDomenskiObjekat {

    public List<OpstiDomenskiObjekat> vratiListuIzResultSet(ResultSet rs);

    public String vratiNazivTabele();

    public String vratiVrednostZaInsert();

    public String vratiUslovZaPronadjiSlog();

    public String vratiNazivTabeleSaJOINom();

    public String vratiUslovZaPronadjiSlogoveVezaneZaRoditelja();

    ;;
    public String vratiUslovZaSortiranje();

    public String vratiVrednostZaUpdate();

    public String vratiUslovZaIzmeniSlog();

    public String vratiUslovZaStorniranje();
}
