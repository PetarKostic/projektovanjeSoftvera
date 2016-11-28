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
public class KontrolerObrisiStavku {

    public static void obrisiStavku(JTable tblStavkeRacuna, int red) {
        ((TableModelStavke) tblStavkeRacuna.getModel()).obrisiStavku(red);
    }

}
