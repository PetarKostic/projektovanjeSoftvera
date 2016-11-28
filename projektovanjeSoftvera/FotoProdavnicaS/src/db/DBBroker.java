/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.OpstiDomenskiObjekat;
import domen.Radnik;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Korisnik
 */
public class DBBroker {

    private static DBBroker broker;
    Connection konekcija;

    public static DBBroker vratiBroker() {
        if (broker == null) {
            broker = new DBBroker();
        }
        return broker;
    }

    public void otvoriBazu() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/vezbanje";
            konekcija = DriverManager.getConnection(url, "root", "");
            konekcija.setAutoCommit(false);
            System.out.println("Uspesno povezivanje sa bazom");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void comit() {
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close() {
        try {
            konekcija.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void rollback() {
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //kao parametar metode stavljam opsti domenski objekat ,jer mogu da mu prosledim posle bilo koji objekat,bilo radnik,proizvod i slicno
    public List<OpstiDomenskiObjekat> vratiSve(OpstiDomenskiObjekat odo) throws Exception {
        //pravimo upit,na osnovu objekta koji smo mu prosledili , mi cemo znati naziv tabele iz koje vucemo podatke
        String sql = "select * from " + odo.vratiNazivTabele();
        System.out.println(odo.vratiNazivTabele());
        //pravimo klasican statement da bi mogli da izvrsimo sql query(upit) nad bazom.
        Statement statement = konekcija.createStatement();
        //u objekat rs se smestaju svi podaci izvuceni iz baze podataka
        ResultSet rs = statement.executeQuery(sql);
        //i vracamo listu podataka iz baze,ako je to radnik,vracamo listu radnika,ako je proizvod vracamo listu proizvoda
        //odo.vratiListuIzResultSet(rs) ova metoda ce se nalaziti u svakoj domenskoj klasi koja implementira interfejs,jer mora da 
        //implementrira sve abstractne metode interfejsa OpstiDomenskiObjekat
        return odo.vratiListuIzResultSet(rs);
    }

    public void sacuvaj(OpstiDomenskiObjekat odo) throws SQLException {
        String sql = "insert into " + odo.vratiNazivTabele() + " values (" + odo.vratiVrednostZaInsert() + ") ";
        System.out.println(sql);
        Statement statement = konekcija.createStatement();
        statement.executeUpdate(sql);
        statement.close();
    }

    public List<OpstiDomenskiObjekat> pronadji(OpstiDomenskiObjekat odo) throws SQLException {
        String sql = "select * from " + odo.vratiNazivTabele() + " where " + odo.vratiUslovZaPronadjiSlog();
        System.out.println(sql);
        Statement statement = konekcija.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        return odo.vratiListuIzResultSet(rs);
    }

    public List<OpstiDomenskiObjekat> vratiDecuRoditelja(OpstiDomenskiObjekat odo) throws SQLException {
        String sql = "select * from " + odo.vratiNazivTabeleSaJOINom() + " where " + odo.vratiUslovZaPronadjiSlogoveVezaneZaRoditelja();
        System.out.println(sql);
        Statement statement = konekcija.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        return odo.vratiListuIzResultSet(rs);
    }

    public void izmeni(OpstiDomenskiObjekat odo) throws SQLException {
        String sql = "update " + odo.vratiNazivTabele() + " set " + odo.vratiVrednostZaUpdate() + " where " + odo.vratiUslovZaIzmeniSlog();
        System.out.println(sql);
        Statement statement = konekcija.createStatement();
        statement.executeUpdate(sql);
        statement.close();

    }

    public void obrisi(OpstiDomenskiObjekat odo) throws SQLException {
        String sql = "delete from " + odo.vratiNazivTabele() + " where " + odo.vratiUslovZaPronadjiSlog();
        System.out.println(sql);
        Statement statement = konekcija.createStatement();
        statement.executeUpdate(sql);
        statement.close();
    }

    public void storniranjeRacuna(OpstiDomenskiObjekat odo) throws SQLException {
        String sql = "UPDATE " + odo.vratiNazivTabele() + " SET " + odo.vratiUslovZaStorniranje() + " WHERE " + odo.vratiUslovZaIzmeniSlog();
        Statement statement = konekcija.createStatement();
        statement.executeUpdate(sql);
        statement.close();
    }
}
