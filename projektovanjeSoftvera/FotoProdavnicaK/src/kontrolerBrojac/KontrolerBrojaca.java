/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontrolerBrojac;

import java.io.IOException;
import sesija.Sesija;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Korisnik
 */
public class KontrolerBrojaca {

    public static int vratiBrojac() throws IOException, ClassNotFoundException {
        ServerTransferObjekat sto = Sesija.getSesion().vratiBrojac();
        int brojac = (int) sto.getPodaci();
        return brojac;
    }
    
}
