/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;

/**
 *
 * @author Korisnik
 */
public abstract class OpstaSistemskaOperacija {

    public static int brojac = 0;
    //na primer kod prijavljivanja iz Kontrolera smo napravili objekat klase PrijaviSeSO koja nasledjuje ovu abstract klasu
    //i mora da implementrira sve metode ove klase.U zavisnosti koji objekat poziva metodu izvrsiOperaciju(Object o) i koji objekat
    //smo prosledili kao parametar metode.
    //Ova metoda sluzi da se mi povezemo sa bazom,proverimo preduslov,izvrsimo konkretnu operaciju i zatvorimo bazu.
    public final void izvrsiOperaciju(Object o) throws Exception {
        try {
            //otvaramo bazu
            DBBroker.vratiBroker().otvoriBazu();
            //proveravamo uslov 
            proveriPreduslov(o);
            //izvrsavamo konkretnu operaciju u zavisnosti od Klase koja implementira ovu abstract klasu
            izvrsiKonkretnuOperaciju(o);
            //comit transakcije
            DBBroker.vratiBroker().comit();
        } catch (Exception exception) {
            //ako se dodje do greske,hvatamo gresku i ponistavamo sve transakcije
            DBBroker.vratiBroker().rollback();
            throw exception;
        } finally {
            //na kraju finally metoda koja se uvek izvrsava na kraju , zatvara bazu
            DBBroker.vratiBroker().close();
        }
    }

    protected abstract void proveriPreduslov(Object o) throws Exception;

    protected abstract void izvrsiKonkretnuOperaciju(Object o) throws Exception;
}
