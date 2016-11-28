/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import javax.swing.JTable;
import table.TableModelStavke;

/**
 *
 * @author Korisnik
 */
public class KontrolerDodajStavku {

    public static void dodajStavku(JTable tblStavkeRacuna) {
        ((TableModelStavke) tblStavkeRacuna.getModel()).dodajStavku();
    }

}
