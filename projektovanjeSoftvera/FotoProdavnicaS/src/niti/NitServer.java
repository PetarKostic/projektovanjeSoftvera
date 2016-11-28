/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Korisnik
 */
public class NitServer extends Thread {

    public NitServer() {
    }

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(9000);
            System.out.println("Server pokrenut");
            while (true) {
                Socket soket = server.accept();
                System.out.println("Klijent se povezao");

                NitObradaKlijenta nit = new NitObradaKlijenta(soket);
                nit.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(NitServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
