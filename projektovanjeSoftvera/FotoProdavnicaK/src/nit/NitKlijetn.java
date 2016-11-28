/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nit;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import kontrolerBrojac.KontrolerBrojaca;

/**
 *
 * @author Korisnik
 */
public class NitKlijetn extends Thread {
    JTextField txtBrojac;
    public NitKlijetn(JTextField txtBrojac) {
        this.txtBrojac = txtBrojac;
    }

    @Override
    public void run() {
       while(true)
       {
           try {
               int brojac = KontrolerBrojaca.vratiBrojac();
               txtBrojac.setText(Integer.toString(brojac));
               sleep(3000);
           } catch (IOException ex) {
               Logger.getLogger(NitKlijetn.class.getName()).log(Level.SEVERE, null, ex);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(NitKlijetn.class.getName()).log(Level.SEVERE, null, ex);
           } catch (InterruptedException ex) {
               Logger.getLogger(NitKlijetn.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }
    
    
    
    
}
